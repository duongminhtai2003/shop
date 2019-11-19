<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">VIEW BILL</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
<!-- IN ra loi chua nhap danh muc -->  
								<form method="post">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Full Name</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="fullname" disabled="disabled" value="${item.fullname}">
											</div>	
											</div>	
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Email</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="email" disabled="disabled" value="${item.email}">
											</div>		</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Phone</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="phone" disabled="disabled" value="${item.phone}">
											</div>		</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Date Order</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="date_create" disabled="disabled" value="${item.date_create}">
											</div>		</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Address</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="address" disabled="disabled" value="${item.address}">
											</div>		</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Payment</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="payment" disabled="disabled" value="${item.payment}">
											</div>		</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Status</label>
												<form:errors path="pay.*"/>
												<input type="text" class="form-control" name="status" value="${item.status}">
											</div>		</div>
									</div>
									
									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
						
								<th>Product</th>
								<th>Price</th>
								<th>Picture</th>
								<th>Amount</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty listOrder}">
									<c:forEach items="${listOrder}" var="bill">
										<tr class="odd gradeX">
											<td>${bill.product_name}</td>
											<td>${bill.price_new}</td>
											<td>
												<img style="width: 150px;height: 100px;" src="${pageContext.request.contextPath}/upload/${bill.picture}" />
											</td>
											<td>${bill.amount}</td>			
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<p>Không Có Danh Mục </p>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
								<h3>Total Money: ${item.total_money}</h3>
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Sửa" class="btn btn-success" />
										</div>
									</div>
	
								</div>
							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->