<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý Tin</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/land/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
					
					<form action="${pageContext.request.contextPath}/admin/land/search" method="get">
	                	<div class="col-md-4">
	                 	 <div class="input-group form">
	                       <input type="text" class="form-control" name="name" id="name" placeholder="Search...">
	                       <span class="input-group-btn">
	                         <button class="btn btn-primary" type="submit">Search</button>
	                       </span>
	                  	 </div>
	                  	</div>
                  	</form>
				</div>
				${msg}
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Danh mục</th>
								<th>Lượt đọc</th>
								<th>Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listLand}" var="land">
							<tr class="odd gradeX">
								<td>${land.id}</td>
								<td>${land.landName}</td>
								<td>${land.catName}</td>
								<td class="center">${land.countViews}</td>
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
								<td class="center text-center">
									<a href="${pageContext.request.contextPath}/admin/land/edit/${land.id}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="${pageContext.request.contextPath}/admin/land/del/${land.id}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>