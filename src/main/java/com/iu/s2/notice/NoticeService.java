package com.iu.s2.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s2.util.Pager;

@Service
public class NoticeService {

	@Autowired NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getNoticeList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getNoticeCount();

		pager.setPageNum(totalCount);
		pager.setRowNum();
		
		
		return noticeDAO.getNoticeList(pager);
	}
	public int setNotice(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setNotice(noticeDTO);
	}
	
	
	
}
