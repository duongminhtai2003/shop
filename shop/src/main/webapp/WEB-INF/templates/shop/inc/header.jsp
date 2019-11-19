<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>

	<header>
		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="#">
							<img src="${pageContext.request.contextPath}/shop/img/logoh.jpg" alt="">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Search -->
					<div class="header-search">
					<!-- 	<form>
							<input class="input search-input" type="text" placeholder="Enter your keyword">
							<select class="input search-categories">
								<option value="0">All Categories</option>
								<option value="1">Category 01</option>
								<option value="1">Category 02</option>
							</select>
							<button class="search-btn"><i class="fa fa-search"></i></button>
						</form> -->
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<a href="#" class="text-uppercase">Login</a>  <a href="#" class="text-uppercase"></a>
							<ul class="custom-menu">
								<li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
								<li><a href="#"><i class="fa fa-unlock-alt"></i> Login</a></li>
								<li><a href="#"><i class="fa fa-user-plus"></i> Create An Account</a></li>
							</ul>	
						</li>
						<!-- /Account -->

						<!-- Cart -->
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
									<%-- 		<a onclick="delorder(${cart.product_name})" href="javascript:void(0)" class="cancel-btn">
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

						<!-- /Cart -->

						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
<script type="text/javascript">
	function order(id) {
		$.ajax({
			url : "${pageContext.request.contextPath}/add/order",
			type : 'POST',
			dataType : 'html',
			data : {
				id : id
			},
			success : function(data) {
				$('.mycart').html(data);
			},
			error : function() {
				alert('Có lỗi xảy ra');
			}
		});
	}
</script>
<!-- <script type="text/javascript">
	function delorder(product_name) {
		$.ajax({
			url : "${pageContext.request.contextPath}/del/order",
			type : 'POST',
			dataType : 'html',
			data : {
				product_name : product_name
			},
			success : function(data) {
				$('.mycart').html(data);
			},
			error : function() {
				alert('Có lỗi xảy ra');
			}
		});
	}
</script> -->
	