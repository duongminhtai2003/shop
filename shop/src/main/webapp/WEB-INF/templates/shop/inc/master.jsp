<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>HOGWARTS SHOP</title>

	<!-- Google font -->
<!-- 	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">
 -->
	 <style>
		@import url('https://fonts.googleapis.com/css?family=Chewy&display=swap');
	</style>
	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/slick.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/css/style.css" />

</head>

<body>
	<!-- HEADER -->
	<tiles:insertAttribute name="header" />
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<tiles:insertAttribute name="rightbar" />
	<!-- /NAVIGATION -->
		
	<!-- HOME -->
	<tiles:insertAttribute name="content" />
	<!-- /section -->
	<!-- FOOTER -->
	<tiles:insertAttribute name="footer" />
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="${pageContext.request.contextPath}/shop/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/shop/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/shop/js/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/shop/js/nouislider.min.js"></script>
	<script src="${pageContext.request.contextPath}/shop/js/jquery.zoom.min.js"></script>
	<script src="${pageContext.request.contextPath}/shop/js/main.js"></script>

</body>

</html>
