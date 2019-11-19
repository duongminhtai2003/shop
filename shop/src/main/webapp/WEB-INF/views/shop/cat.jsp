<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
   <div id="aside" class="col-md-3">
   </div>
    <div id="home">
    	<!-- MAIN -->
				<div id="main" class="col-md-9">
					<!-- store top filter -->
					
					<!-- /store top filter -->

					<!-- STORE -->
					<div id="store">
						<!-- row -->
						<div class="row">
						<c:forEach items="${listproduct}" var="item">
							<!-- Product Single -->
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="product product-single">
									<div class="product-thumb">
									
										<a href="${pageContext.request.contextPath}/product/${item.id}"><button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button></a>
										<img src="${pageContext.request.contextPath}/upload/${item.picture}" alt="">
									</div>
									<div class="product-body">
										<h3 class="product-price">${item.price_new} VND <del class="product-old-price">${item.price_old} VND</del></h3>
									
										<h2 class="product-name"><a href="#">${item.name}</a></h2>
										<div class="product-btns">
											<a onclick="order(${item.id})" href="javascript:void(0)" class="primary-btn add-to-cart">
													<i class="fa fa-shopping-cart"></i> Add to Cart
												</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /Product Single -->
						</c:forEach>

						
						</div>
						<!-- /row -->
					</div>
					<!-- /STORE -->

				
					<!-- /store bottom filter -->
				</div>
				<!-- /MAIN -->
				</div>
				</div>
				</div>
				</div>