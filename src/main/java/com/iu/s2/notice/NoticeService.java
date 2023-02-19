package com.iu.s2.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s2.util.FileManger;
import com.iu.s2.util.Pager;

@Service
public class NoticeService {

	@Autowired NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManger fileManger;
	
	public List<NoticeDTO> getNoticeList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getNoticeCount();

		pager.setPageNum(totalCount);
		pager.setRowNum();
		
		
		return noticeDAO.getNoticeList(pager);
	}
	public int setNotice(NoticeDTO noticeDTO, MultipartFile multipartFile) throws Exception {
		
		int result = noticeDAO.setNotice(noticeDTO);
		
		
		if(!multipartFile.isEmpty()) { //pic.getSize()!=0, 혹은 oriname있냐? //파일이 없는 경우
			
			//1. file을 hdd에 저장
			//project가 아닌 os의 경로 (C:/)
//			String realPath = servletContext.getRealPath("/resources/upload/bankBook");
			String realPath = servletContext.getRealPath("/resources/upload/notice");
			System.out.println("service realpath: "+realPath);
			String fileName = fileManger.fileSave(multipartFile, realPath);
			//2. DB에 저장
			NoticeImgDTO noticeImgDTO = new NoticeImgDTO();
			noticeImgDTO.setFileName(fileName);
			noticeImgDTO.setOriName(multipartFile.getOriginalFilename());
			noticeImgDTO.setPostNum(noticeDTO.getPostNum());
			
			result = noticeDAO.setNoticeImgAdd(noticeImgDTO);
		}
	
		return result;
	}
	
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.getNoticeDetail(noticeDTO);
	}
	
	public int setNoticeDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setNoticeDelete(noticeDTO);
	}
	public int setNoticeUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setNoticeUpdate(noticeDTO);
	}	
	
}
