<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa danh mục</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
<!-- IN ra loi chua nhap danh muc -->  
								<form method="post">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Tên Danh Mục</label>
												<form:errors path="pay.*"/>  ${msg}
												<input type="text" class="form-control" name="payment" value="${pay.payment}">
											</div>		
									</div>

									<hr>
	
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