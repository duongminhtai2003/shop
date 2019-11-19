<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large" style="width: 1200px;height: 710px;">
  				<div class="row">
	  				<div class="panel-heading">
	  				${msg}
	  					<div class="panel-title ">Quản lý User</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                <!-- 	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div> -->
				</div>

				<div class="row">
  				<div class="panel-body" style="width: 1200px;">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Email</th>
								<th>FullName</th>
								<th>Address</th>
								<th>Password</th>
								<th>Date Create</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listUser}" var="user">
								<c:set var="urlEdit" value="${pageContext.request.contextPath}/admin/user/edit/${user.id}"/>
								<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/user/del/${user.id}"/>
							<tr class="odd gradeX">
								<td>${user.id}</td>
								<td>${user.email}</td>
								<td>${user.fullname}</td>
								<td>${user.address}</td>
								<td>${user.password}</td>
								<td>${user.date_create}</td>
								<td class="center text-center">
									<a href="${urlEdit}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="${urlDel}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
							    <c:forEach var="num" begin="1" end="${totalPage}">
								    <c:if test="${num==page}">
									     <li class="active">
									      	<a href="${pageContext.request.contextPath}/admin/user/index/${num}">${num}</a>
									      </li>  		
									</c:if>
									 <c:if test="${num!=page}">
									     <li class="">
									      	<a href="${pageContext.request.contextPath}/admin/user/index/${num}">${num}</a>
									      </li>  		
									</c:if>
							     </c:forEach>
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>