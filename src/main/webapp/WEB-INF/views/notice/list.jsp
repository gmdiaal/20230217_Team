<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>

<body class="bg-secondary text-white ">
	<h3>Notice List</h3>

	<div class="container fluid p-3" style="--bs-bg-opacity: .5;">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">이름</th>
		      <th scope="col">본문</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
			  <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody>
				<c:forEach items="${list}" var="dto">
		    <tr>
					<td>${dto.postNum}</td>
					<td>${dto.postName}</td>
					<td>${dto.postArticle}</td>
					<td>${dto.postAuthor}</td>
					<td>${dto.postDate}</td>
					<td>${dto.postSeen}</td>
		    </tr>
				</c:forEach>
		  </tbody>
		</table>
	
	<!-- 페이저 -->


    <div class="col d-flex justify-content-center">
    


			<nav aria-label="Page navigation example">
			  <ul class="mx-5 pagination">
			    <li class="page-item ${pager.before?'disabled':''}">
			      <a class="page-link" href="./list?page=1" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}">Previous</a></li>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
			    </c:forEach>
			    <li class="page-item"><a class="page-link" href="./list?page=${pager.lastNum+1}">Next</a></li>
			    <li class="page-item ${pager.after eq false?'disabled':''}">
			      <a class="page-link" href="./list?page=${pager.totalPage}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>

    </div>

<!-- 페이지 끝 -->
		
	</div> 
	
	<a class="btn btn-outline-warning" href="./add">작성</a>
	
	<c:import url="../template/common_js_jsp"></c:import>
</body>
</html>