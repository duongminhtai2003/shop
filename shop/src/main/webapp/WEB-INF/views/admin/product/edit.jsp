	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
 <div class="col-md-10">
				
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm Tin Tức</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  			<form method="post" enctype="multipart/form-data" >
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
													<input type="text" class="form-control" name="name" value="${proDto.name}">
												</div>		
											</div>
										</tr>
										<tr>
											<div class="col-sm-6">
												<div class="form-group">
												<form:errors path="product.price_import"/>
													<label for="name">Giá Nhập Kho (VND)</label>
													<input type="text" class="form-control" name="price_import" value="${proDto.price_import}">
												</div>		
											</div>
										</tr>
											<tr>
											<div class="col-sm-6">
											
												<div class="form-group">
													<label for="name">Giá Bán (VND)</label>
													<form:errors path="product.price_new"/> 
													<input type="text" class="form-control" name="price_new" value="${proDto.price_new}">
												</div>		
											</div>
										</tr>
										
										<tr>
											<div class="col-sm-6">
												
												<div class="form-group">
													<label for="name">Số Lượng Nhập Kho</label>
													<form:errors path="product.amount"/> 
													<input type="text" class="form-control" name="amount" value="${proDto.amount}">
												</div>		
											</div>
										</tr>
										<tr>
											<div class="col-sm-6">				
												<div class="form-group">	
													<label for="name">Mô Tả:</label>
													<form:errors path="product.preview"/> 
												<%-- 	<textarea rows="5px;" cols="100px;" name="preview">${proDto.preview}</textarea> --%>
													<input type="text" class="form-control" name="preview" value="${proDto.preview}">
 												</div>		
											</div>
										</tr>
										<tr>
	                                   		<div class="col-sm-6">
												 <div class="form-group">
	                                   			<label for="name">Thêm Hình Ảnh</label>
												<p><s:message code="add.picture"/> </p><input type="file" name="file" value="" />
												<img style="width: 150px;height: 100px;" src="${pageContext.request.contextPath}/upload/${proDto.picture}" />
												</div>
											</div>
										</tr>	
										
							
                                   		
									
									</table>
	
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
	  		</div>
		  </div><!-- /.col-md-10 -->