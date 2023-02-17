package com.iu.s2.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getNoticeList() throws Exception {
		return noticeDAO.getNoticeList();
	}
	public int setNotice(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setNotice(noticeDTO);
	}
	
	
	
}
