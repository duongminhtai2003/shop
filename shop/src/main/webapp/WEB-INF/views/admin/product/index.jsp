<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large" style="width: 1200px;height: 710px;">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý Sản Phẩm</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/product/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
					
			<%-- 		<form action="${pageContext.request.contextPath}/admin/land/search" method="get">
	                	<div class="col-md-4">
	                 	 <div class="input-group form">
	                       <input type="text" class="form-control" name="name" id="name" placeholder="Search...">
	                       <span class="input-group-btn">
	                         <button class="btn btn-primary" type="submit">Search</button>
	                       </span>
	                  	 </div>
	                  	</div>
                  	</form> --%>
				</div>
				${msg}
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Import Price</th>
								<th>Price New </th>
								<th>Price Old</th>
								<th>Category</th>
								<th>Name</th>
								<th>Amount</th>
								<th>Picture</th>
								<th>Preview</th>
								<th>Date Create</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listProduct}" var="land">
							<tr class="odd gradeX">
								<td>${land.id}</td>
								<td>${land.price_import}</td>
								<td>${land.price_new}</td>
								<td>${land.price_old}</td>
								<td>${land.cat_name}</td>
								<td>${land.name}</td>
								<td>${land.amount}</td>
								<td class="center text-center">
									<c:choose>
										<c:when test="${not empty land.picture}">
											<img style="width: 150px;height: 100px;" src="${pageContext.request.contextPath}/upload/${land.picture}" />
										</c:when>
										<c:otherwise>
											Khong Co Hinh Anh
										</c:otherwise>
									</c:choose>
								</td>
								<td>${land.preview}</td>
								<td>${land.date_create}</td>
								<td class="center text-center">
									<a href="${pageContext.request.contextPath}/admin/product/edit/${land.id}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="${pageContext.request.contextPath}/admin/product/del/${land.id}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

					<!-- Pagination -->
					<c:if test="${not empty totalPage}">
						<nav class="text-center" aria-label="...">
						   <ul class="pagination">
						     
							     <c:forEach begin="1" end="${totalPage}" var="i">
							     	
							      	<li <c:if test="${page==i}"> class ='active'</c:if>><a href="${pageContext.request.contextPath}/admin/product/index/${i}">${i}</a></li>
							      </c:forEach>
						   
						   </ul>
						</nav>
					</c:if>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>