<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="navbar-nav">
	<c:if test="${empty sessionScope.session1}">
	<li class="nav-item"><a class="nav-link" href="/notice/login" style="font-size:11px">login</a></li> <!--블럭태그는 밑으로 정렬-->		
	</c:if>
	<c:if test="${not empty sessionScope.session1}">
	<li class="nav-item"><a class="nav-link" href="/notice/logout" style="font-size:11px">logout</a></li> <!--블럭태그는 밑으로 정렬-->	
	</c:if>

</ul>