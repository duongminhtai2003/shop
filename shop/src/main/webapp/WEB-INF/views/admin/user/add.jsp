<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm User</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
<!-- IN ra loi chua nhap danh muc --> <%-- <form:errors path="user.*"/>   --%> 
								${msg}
								<form method="post">
									<div class="row">
										<div class="col-sm-6">
											<form:errors path="user.email"/>
											<div class="form-group">
												<label for="name">Email</label>
												<input type="text" class="form-control" name="email" placeholder="Nhập Email" value="${user.email}">
											</div>		
										</div>
										<div class="col-sm-6">
										<form:errors path="user.password"/>
											<div class="form-group">
												<label for="name">Password</label>
												<input type="password" class="form-control" name="password" placeholder="Nhập Password"value="${user.password}">
											</div>		
										</div>
										<div class="col-sm-6">
										<form:errors path="user.fullname"/>
											<div class="form-group">
												<label for="name">FullName</label>
												<input type="text" class="form-control" name="fullname" placeholder="Full Name"value="${user.fullname}">
											</div>		
										</div>
										<div class="col-sm-6">
										<form:errors path="user.address"/>
											<div class="form-group">
												<label for="name">Address</label>
												<input type="text" class="form-control" name="address" placeholder="Address"value="${user.address}">
											</div>		
										</div>
											<div class="col-sm-6">
										<form:errors path="user.phone"/>
											<div class="form-group">
												<label for="name">Phone</label>
												<input type="text" class="form-control" name="phone" placeholder="phone"value="${user.phone}">
											</div>		
										</div>
										
											<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Active</label>
												<input type="checkbox" value="1" name="active">
											</div>		
										</div>
										
												<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Role</label>
												<select name="roleid">
													<option value="1">admin</option>
													<option value="2">mod</option>
													<option value="3">user</option>
												</select>
											</div>		
										</div>
									</div>
	
									<hr>
	
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Thêm" class="btn btn-success" />
										</div>
									</div>
	
								</div>
							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->