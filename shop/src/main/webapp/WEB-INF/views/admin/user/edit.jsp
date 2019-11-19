<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  			
	  				<div class="col-md-12 panel-info" style="width: 1200px;">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Edit User</div>
			  			</div>
			  			
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
							<h3 style="color: red">${msg}</h3>	
								<form method="post">
									<div class="row">
										<div class="col-sm-6">
										<form:errors path="user.email"/>
											<div class="form-group">
												<label for="name">Email: </label>
												<input type="text" class="form-control" name="email" value="${item.email}">
											</div>		
										</div>
										<div class="col-sm-6">
				
											<div class="form-group">
											<form:errors path="user.password"/>
												<label for="name">Password</label>
												<input type="password" class="form-control" name="password" value="${item.password}" >
											</div>		
										</div>
										
										<div class="col-sm-6">
											<form:errors path="user.fullname"/>
											<div class="form-group">
												<label for="name">FullName</label>
												<input type="text" class="form-control" name="fullname" value="${item.fullname}">
											</div>		
										</div>
										<div class="col-sm-6">
										<form:errors path="user.address"/>
											<div class="form-group">
												<label for="name">Address</label>
												<input type="text" class="form-control" name="address" value="${item.address}" >
											</div>		
										</div>
										<div class="col-sm-6">
											<form:errors path="user.phone"/>
											<div class="form-group">
												<label for="name">Phone</label>
												<input type="text" class="form-control" name="phone" value="${item.phone}">
											</div>		
										</div>
										
												<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Active</label>
												<input type="checkbox" <c:if test="${item.active==1}"> checked="checked"</c:if> value="1" name="active">
											</div>		
										</div>
										
												<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Role</label>
												<select name="roleid">		
													<option <c:if test="${item.roleid==1}"> selected="selected"</c:if> value="1">admin</option>
													<option <c:if test="${item.roleid==2}"> selected="selected"</c:if> value="2">mod</option>
													<option <c:if test="${item.roleid==3}"> selected="selected"</c:if> value="3">user</option>
												</select>
											</div>		
										</div>
									</div>
	
									<hr>
	
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Sửa" class="btn btn-success" />
										</div>
									</div>

							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->