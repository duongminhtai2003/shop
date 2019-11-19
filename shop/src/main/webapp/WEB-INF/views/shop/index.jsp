<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
	<div id="home">
		<!-- container -->
		<div class="container">
			<!-- home wrap -->
			<div class="home-wrap">
				<!-- home slick -->
				<div id="home-slick">
					<!-- banner -->
					<div class="banner banner-1" style="height: 300px;">
						<img style="height: 300px;"  src="${pageContext.request.contextPath}/shop/img/h1.jpg" alt="">
						<div class="banner-caption text-center">
							<h1>Big Sale</h1>
							<h3 class="white-color font-weak">Up to 50% Discount</h3>
							<button class="primary-btn">Shop Now</button>
						</div>
					</div>
					<!-- /banner -->

					<!-- banner -->
					<div class="banner banner-1" style="height: 300px;">
						<img style="height: 300px;" src="${pageContext.request.contextPath}/shop/img/h2.jpg" alt="">
						<div class="banner-caption">
							<h1 class="primary-color">News<br><span class="white-color font-weak">New products</span></h1>
							<button class="primary-btn">Shop Now</button>
						</div>
					</div>
					<!-- /banner -->

					<!-- banner -->
					<div class="banner banner-1" style="height: 300px;">
						<img style="height: 300px;" src="${pageContext.request.contextPath}/shop/img/h4.jpg" alt="">
						<div class="banner-caption">
							<h1 class="white-color"><span>Suggest</span></h1>
							<button class="primary-btn">Shop Now</button>
						</div>
					</div>
					<!-- /banner -->
				</div>
				<!-- /home slick -->
			</div>
			<!-- /home wrap -->
		</div>
		<!-- /container -->
	</div>
	<!-- /HOME -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- banner -->
				<c:forEach items="${listNew}" var="news" >
					<div class="col-md-4 col-sm-6">
						<a class="banner banner-1" href="${pageContext.request.contextPath}/product/${news.id}">
							<img src="${pageContext.request.contextPath}/upload/${news.picture}" alt="">
							<div class="banner-caption text-center">
								<h2 class="white-color">NEW COLLECTION</h2>
							</div>
						</a>
					</div>
				</c:forEach>
				<!-- /banner -->

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- section-title -->
				<div class="col-md-12">
					<div class="section-title">
						<h2 class="title">Sale Up To 50%</h2>
						<div class="pull-right">
							<div class="product-slick-dots-1 custom-dots"></div>
						</div>
					</div>
				</div>
				<!-- /section-title -->

				<!-- banner -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="banner banner-2">
						<img src="${pageContext.request.contextPath}/shop/img/h8.jpg" alt="">
						<div class="banner-caption">
							<h2 class="white-color">Sale<br>50%</h2>
							<button class="primary-btn">Shop Now</button>
						</div>
					</div>
				</div>
				<!-- /banner -->

				<!-- Product Slick -->
				<div class="col-md-9 col-sm-6 col-xs-6">
					<div class="row">
						<div id="product-slick-1" class="product-slick">
						
							<!-- Product Single -->
							<c:forEach items="${listSale}" var="item" >
							
								<div class="product product-single">
									<div class="product-thumb">
										<div class="product-label">
											<span class="sale">-50%</span>
										</div>
								
								<a href="${pageContext.request.contextPath}/product/${item.id}"><button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button></a>
										<img src="${pageContext.request.contextPath}/upload/${item.picture}" alt="">
									</div>
									<div class="product-body">
										<h3 class="product-price">${item.price_new} VND<del class="product-old-price">${item.price_old} VND</del></h3>
							
										<h2 class="product-name"><a href="#">${item.name}</a></h2>
										<div class="product-btns">
											<input type="text" value="${item.id}" hidden="hidden" id="id" name="id">
												<a onclick="order(${item.id})" href="javascript:void(0)" class="primary-btn add-to-cart">
													<i class="fa fa-shopping-cart"></i> Add to Cart
												</a>
											</div>
									</div>
								</div>
							</c:forEach>
							<!-- /Product Single -->
							

							
						</div>
					</div>
				</div>
				<!-- /Product Slick -->
			</div>
			<!-- /row -->


			<!-- row -->
			<div class="row">
				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h2 class="title">Suggest For You</h2>
					</div>
				</div>
				<!-- section title -->

				<!-- Product Single -->
					<c:forEach  items="${listSuggest}" var="item">
						
					
						<div class="col-md-3 col-sm-6 col-xs-6">
								<div class="product product-single">
										<div class="product-thumb">
											<div class="product-label">
												<!-- <span class="sale">-50%</span> -->
											</div>
									
											<a href="${pageContext.request.contextPath}/product/${item.id}"><button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button></a>
											<img src="${pageContext.request.contextPath}/upload/${item.picture}" alt="">
										</div>
										<div class="product-body">
											<h3 class="product-price">${item.price_new} VND<del class="product-old-price">${item.price_old} VND</del></h3>
								
											<h2 class="product-name"><a href="#">${item.name}</a></h2>
											<div class="product-btns">
											<input type="text" value="${item.id}" hidden="hidden" id="id" name="id">
												<a onclick="order(${item.id})" href="javascript:void(0)" class="primary-btn add-to-cart">
													<i class="fa fa-shopping-cart"></i> Add to Cart
												</a>
											</div>
										</div>
								</div>		
						</div>
				
					</c:forEach>
				<!-- /Product Single -->
			
				
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	
