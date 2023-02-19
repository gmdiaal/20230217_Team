<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>

	<h3>번호: ${dto.postNum}</h3>
	<h3>이름: ${dto.postName}</h3>
	<h3>내용: ${dto.postArticle}</h3>
	<h3>작성자: ${dto.postAuthor}</h3>
	<h3>작성일: ${dto.postDate}</h3>
	<h3>조회수: ${dto.postSeen}</h3>
			<div>
				<c:if test="${not empty dto.noticeImgDTO}">
				<img src="../resources/upload/bankBook/${detail.noticeImgDTO.fileName}">
				</c:if>
				<c:if test="${empty dto.noticeImgDTO}"><h4>이미지 없음</h4></c:if>
			</div>	
	<a href="./list">돌아가기</a>
	<a href="./update?postNum=${dto.postNum}">수정</a>
	<a href="./delete?postNum=${dto.postNum}">삭제</a>

	<c:import url="../template/common_js_jsp"></c:import>
</body>
</html>