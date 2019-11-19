<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
  	
          
      <div id="mycart" class="mycart">
      		<li class="header-cart dropdown default-dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
								<strong class="text-uppercase">My Cart:</strong>
									<div class="header-btns-icon">
									<i class="fa fa-shopping-cart"></i>
									<span class="qty">${cart.size()}</span>
								</div>
							</a>
							<div class="custom-menu">
								<div id="shopping-cart">
									<div class="shopping-cart-list">
									<c:forEach items="${cart}" var="cart">
										<div class="product product-widget">
											<div class="product-thumb">
												<img src="${pageContext.request.contextPath}/upload/${cart.picture}" alt="">
											</div>
											<div class="product-body">
												<h3 class="product-price">${cart.price_new} <span class="qty">x ${cart.amount}</span></h3>
												<h2 class="product-name"><a href="#">${cart.product_name}</a></h2>
											</div>
											<input type="text" value="${cart.product_name}" hidden="hidden" id="product_name" name="product_name">
											<%-- 	<a onclick="delorder(${cart.product_name})" href="javascript:void(0)" class="cancel-btn">
														<i class="fa fa-trash"></i>
												</a> --%>
										</div>
									</c:forEach>
									</div>
									<div class="shopping-cart-btns">
											<a href="${pageContext.request.contextPath}/cart">	<button class="main-btn">View Cart </button></a>
										<button class="primary-btn">Checkout <i class="fa fa-arrow-circle-right"></i></button>
									</div>
								</div>
							</div>
						</li>
      </div>
      
 
</body>
</html>