package com.iu.s2.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s2.MyTestCase;

public class noticeTest extends MyTestCase {

	@Autowired
	NoticeDAO noticeDAO;
	
	@Test
	public void setNotice() throws Exception {
		int result=0;
		
		for (int i=26;i<100;i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setPostName("test"+i);
		noticeDTO.setPostAuthor("test"+i);
		noticeDTO.setPostArticle("test"+i);
		result = noticeDAO.setNotice(noticeDTO);
		}
		assertEquals(1, result);
	}
}
