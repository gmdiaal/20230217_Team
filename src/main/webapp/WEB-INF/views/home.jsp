<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body class="bg-black text-white">


<a href="./notice/list">Notice List</a>

<P>  The time on the server is ${serverTime}. </P>





	<c:import url="./template/common_js.jsp"></c:import>
</body>
</html>
