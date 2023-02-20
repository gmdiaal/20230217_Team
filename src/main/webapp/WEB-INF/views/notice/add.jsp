<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<div class="container-fluid">
		<form action="./add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">제목</label>
			  <input type="text" name="postName" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlTextarea1" class="form-label">본문</label>
			  <textarea class="form-control" name="postArticle" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">작성자</label>
			  <input type="text" name="postAuthor" value="${sessionScope.session1.postAuthor}" readonly class="form-control" id="exampleFormControlInput1"
			   placeholder="${sessionScope.session.postAuthor}">
			</div>

			  <div class="mb-3">
			    <label for="files" class="form-label">이미지</label>
				<input type="file" class="form-control" id="files" name="multipartFile">
			  </div>

			<button type="submit" class="btn btn-primary">제출</button>
		</form>
	</div>
	
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>