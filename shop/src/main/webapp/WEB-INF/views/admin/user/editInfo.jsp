<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Edit Info</div>
			  			</div>
			  			
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
							${msg}
								<form method="post">
									<div class="row">
										<div class="col-sm-6">
										<form:errors path="user.username"/>
											<div class="form-group">
												<label for="name">UserName</label>
												<input type="text" class="form-control" name="username" value="${item.username}" placeholder="Nhập UserName">
											</div>		
										</div>
										<div class="col-sm-6">
				
											<div class="form-group">
											<form:errors path="user.username"/>
												<label for="name">Password</label>
												<input type="password" class="form-control" name="password" value="${item.password}"  placeholder="Nhập Password">
											</div>		
										</div>
										<div class="col-sm-6">
										<form:errors path="user.fullname"/>
											<div class="form-group">
												<label for="name">FullName</label>
												<input type="text" class="form-control" name="fullname" value="${item.fullname}" placeholder="Full Name">
											</div>		
										</div>
										<div class="col-sm-6">
											<form:errors path="user.remember_token"/>
											<div class="form-group">
												<label for="name">Email</label>
												<input type="text" class="form-control" name="remember_token" value="${item.remember_token}" placeholder="Email">
											</div>		
										</div>
										
												<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Enable</label>
												<input disabled="disabled" type="checkbox" <c:if test="${item.enable==1}"> checked="checked"</c:if> value="1" name="enable">
											</div>		
										</div>
										
												<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Role</label>
												<select disabled="disabled" name="roleid">
												
													<option <c:if test="${item.roleid==1}"> selected="selected"</c:if> value="1" >admin</option>
													<option <c:if test="${item.roleid==2}"> selected="selected"</c:if> value="2">user</option>
												</select>
											</div>		
										</div>
									</div>
	
									<hr>
	
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Thêm" class="btn btn-success" />
											<input type="reset" value="Nhập lại" class="btn btn-default" />
										</div>
									</div>

							</form>	
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->