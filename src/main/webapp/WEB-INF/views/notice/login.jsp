<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
		<form action="./login" method="post">
			이름
			<input type="text" name="postAuthor">
			<button class="btn btn-primary" type="submit">제출</button>
		</form>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>