<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Create Account</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/views/create/fonts/linearicons/style.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/views/create/css/style.css">
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<img src="${pageContext.request.contextPath}/views/create/images/image-1.png" alt="" class="image-1">
				<form action="">
					<h3>New Account?</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control" name="email" placeholder="Email">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" class="form-control" name="password" placeholder="Password">
					</div>
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" class="form-control" name="fullname" placeholder="Full Name">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="text" class="form-control" name="address" placeholder="Address">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="text" class="form-control" name="phone" placeholder="Phone Number">
					</div>
		
					<button>
						<span>Register</span>
					</button>
				</form>
				<img src="${pageContext.request.contextPath}/views/create/images/image-2.png" alt="" class="image-2">
			</div>
			
		</div>
		
		<script src="${pageContext.request.contextPath}/views/create/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/views/create/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>