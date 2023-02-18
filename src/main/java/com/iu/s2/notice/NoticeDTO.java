package com.iu.s2.notice;

import java.sql.Date;

public class NoticeDTO {
	private Long postNum;
	private String postName;
	private String postArticle;
	private String postAuthor;
	private Date postDate;
	private Long postSeen;

	public Long getPostNum() {
		return postNum;
	}
	public void setPostNum(Long postNum) {
		this.postNum = postNum;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostArticle() {
		return postArticle;
	}
	public void setPostArticle(String postArticle) {
		this.postArticle = postArticle;
	}
	public String getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Long getPostSeen() {
		return postSeen;
	}
	public void setPostSeen(Long postSeen) {
		this.postSeen = postSeen;
	}



}
