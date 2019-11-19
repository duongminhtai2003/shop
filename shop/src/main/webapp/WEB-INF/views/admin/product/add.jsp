<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm Sản Phẩm</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  			${msg}
			  			<form action="${pageContext.request.contextPath}/admin/product/add" method="post" enctype="multipart/form-data" >
				  			<div>
								<div class="row mb-10"></div>
									
									<table>
									<tr>
											<div class="col-sm-6">
										
											 <div class="form-group">
                                        		<label for="name">Danh mục Sản Phẩm</label>
                                       			 <select id="category" name="cat_id" class="form-control">    
                                       			 	<c:forEach items="${listparent}" var="item">
	                                        			<option value="${item.id}">${item.name}</option>
	                                        		</c:forEach>
                                     			  </select>
                                   			 </div>
                                   			 </div>
                                   		</tr>
										<tr>
											<div class="col-sm-6">
										 	<form:errors path="product.name"/> 
												<div class="form-group">
													<label for="name">Tên Sản Phẩm</label>
													<input type="text" class="form-control" name="name" placeholder="Nhập tên Sản Phẩm">
												</div>		
											</div>
										</tr>
										<tr>
											<div class="col-sm-6">
												<div class="form-group">
												<form:errors path="product.price_import"/>
													<label for="name">Giá Nhập Kho (VND)</label>
													<input type="text" class="form-control" name="price_import" placeholder="Giá Nhập Kho">
												</div>		
											</div>
										</tr>
											<tr>
											<div class="col-sm-6">
											
												<div class="form-group">
													<label for="name">Giá Bán (VND)</label>
													<form:errors path="product.price_new"/> 
													<input type="text" class="form-control" name="price_new" placeholder="Giá Bán">
												</div>		
											</div>
										</tr>
										
										<tr>
											<div class="col-sm-6">
												
												<div class="form-group">
													<label for="name">Số Lượng Nhập Kho</label>
													<form:errors path="product.amount"/> 
													<input type="text" class="form-control" name="amount" placeholder="Số Lượng Nhập Kho">
												</div>		
											</div>
										</tr>
										<tr>
											<div class="col-sm-6">				
												<div class="form-group">	
													<label for="name">Mô Tả:</label>
													<form:errors path="product.preview"/> 
													<input type="text" class="form-control" name="preview" placeholder="Nhập Mô Tả">
												</div>		
											</div>
										</tr>
							
                                   		<tr>
	                                   		<div class="col-sm-6">
												 <div class="form-group">
	                                   			<label for="name">Thêm Hình Ảnh</label>
												<p><s:message code="add.picture"/> </p><input type="file" name="file" value="" />
												</div>
											</div>
										</tr>	
									
									</table>
	
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
	  		</div>
		  </div><!-- /.col-md-10 -->