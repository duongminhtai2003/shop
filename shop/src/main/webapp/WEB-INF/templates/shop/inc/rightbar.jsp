
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>

	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav">
					<span class="category-header">Categories <i class="fa fa-list"></i></span>
					<ul class="category-list" >
					<c:forEach items="${listparent}" var="parent">
						<li class="dropdown side-dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">${parent.name}<i class="fa fa-angle-right"></i></a>	
							<div class="custom-menu" style="width: 500px;">
								<div class="row">
									<div class="col-md-4">
										<c:forEach items="${listcat}" var="cat">
											<ul class="list-links">
												<c:if test="${parent.id==cat.parent_id}">
													<li>
													
														<a href="${pageContext.request.contextPath}/cat/${cat.id}"><h3 class="list-links-title">${cat.name}</h3></a>	
													<li>
												</c:if>
											</ul>
										</c:forEach>
										<hr class="hidden-md hidden-lg">
									</div>
									
								</div>
								<div class="row hidden-sm hidden-xs">
									<div class="col-md-12">
										<hr>
										<a class="banner banner-1" href="#">
											<img style="width: 400px; height: 200px;" src="${pageContext.request.contextPath}/shop/img/h${parent.id}.jpg" alt="">
										</a>
									</div>
								</div>
							</div>
							
							
						</li>	
					</c:forEach>		
					</ul>
				</div>
				<!-- /category nav -->

				<!-- menu nav -->
					 <div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li><a href="#">Home</a></li>
						<li><a href="#">Sales</a></li>
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Pages <i class="fa fa-caret-down"></i></a>
							<ul class="custom-menu">
								<li><a href="index.html">Home</a></li>
								<li><a href="products.html">Products</a></li>
								<li><a href="product-page.html">FanPage</a></li>
								<li><a href="checkout.html">Film</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>