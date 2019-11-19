<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
    
 <div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
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
       
					<div class="col-md-12">
						<div class="order-summary clearfix">
							<div class="section-title">
								<h3 class="title">Order Review</h3>
							</div>
							<form action="${pageContext.request.contextPath}/confirm/cart" method="post">
								<table class="shopping-cart-table table">
									<thead>
										<tr>
											<th>Product</th>
											<th></th>
											<th class="text-center">Price</th>
											<th class="text-center">Quantity</th>
										<!-- 	<th class="text-center">Total</th> -->
											<th class="text-right"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cart}" var="cart">
											<tr>
												<td class="thumb"><img src="${pageContext.request.contextPath}/upload/${cart.picture}" alt=""></td>
												<td class="details">
													<a href="#">${cart.product_name}</a>
													<ul>
														<li><span>From: HarryShop</span></li>
														<li><span>Handmade</span></li>
													</ul>
												</td>
												<td class="price text-center"><strong>${cart.price_new}</strong><br><del class="font-weak"><small>${cart.price_import}</small></del></td>
												<td class="qty text-center"><input class="input" type="text" value="${cart.amount}" name="amount"></td>
		<!-- 										<td class="total text-center"><strong class="primary-color">$32.50</strong></td> -->
												<td class="text-right"><a href="${pageContext.request.contextPath}/del/order/${cart.product_name}" class="main-btn icon-btn"><i class="fa fa-close"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
									
					<!-- 				<tfoot>
										<tr>
											<th class="empty" colspan="3"></th>
											<th>SUBTOTAL</th>
											<th colspan="2" class="sub-total">$97.50</th>
										</tr>
										<tr>
											<th class="empty" colspan="3"></th>
											<th>SHIPING</th>
											<td colspan="2">Free Shipping</td>
										</tr>
										<tr>
											<th class="empty" colspan="3"></th>
											<th>TOTAL</th>
											<th colspan="2" class="total">$97.50</th>
										</tr>
									</tfoot> -->
									<tfoot>
										<tr>
											<th class="empty" colspan="3"></th>
											<th>GIFT CODE</th>
											<td colspan="2">
												<input type="text" name="giftcode">
											</td>
										</tr>
									</tfoot>
									
									</table>
									<div class="pull-right">
										<button class="primary-btn">Confirm Cart</button>
									</div>
							</form>
						</div>

					</div>