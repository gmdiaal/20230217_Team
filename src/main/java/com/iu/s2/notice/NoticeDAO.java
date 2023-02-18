package com.iu.s2.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s2.util.Pager;

@Repository
public class NoticeDAO {
	@Autowired SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.s2.notice.NoticeDAO.";
	
	public List<NoticeDTO> getNoticeList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getNoticeList", pager);
	}
	
	public Long getNoticeCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getNoticeCount");
	}
	
	public int setNotice(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setNotice", noticeDTO);
	}
	
}
