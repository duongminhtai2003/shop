<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý danh mục</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/cat/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
              <!--   	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div> -->
				</div>
				${msg}
				<form:errors path="cat.*"/>
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Category Name</th>
								<th>Category Parent</th>
								<th>Date Create</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty listCat}">
									<c:forEach items="${listCat}" var="cat">
										<c:set var="urlEdit" value="${pageContext.request.contextPath}/admin/cat/edit/${cat.id}"/>
										<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/cat/del/${cat.id}"/>
										<tr class="odd gradeX">
											<td>${cat.id}</td>
											<td>${cat.name}</td>
											<td>${cat.parent_name}</td>
											<td>${cat.date_create}</td>
											<td class="center text-center">
												<a href="${urlEdit}" title="sua" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
			                                    <a href="${urlDel}" title="xoa" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<p>Không Có Danh Mục </p>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>

				
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>