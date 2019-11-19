<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý Liên Hệ</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
                	<div class="col-md-4">
                 <!-- 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div> -->
                  	</div>
				</div>
				${msg}
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Email</th>
								<th>Subject</th>
								<th>Content</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listLand}" var="land">
							<tr class="odd gradeX">
								<td>${land.id}</td>
								<td>${land.fullname}</td>
								<td>${land.email}</td>
								<td class="center">${land.subject}</td>
								<td class="center text-center">
									${land.content}
								</td>
								<td class="center text-center">
								
                                    <a href="${pageContext.request.contextPath}/admin/del/contact/${land.id}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

					<!-- Pagination -->
			<%-- 		<c:if test="${not empty totalPage}">
						<nav class="text-center" aria-label="...">
						   <ul class="pagination">
						      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							     <c:forEach begin="1" end="${totalPage}" var="i"> 
							     	
							      	<li <c:if test="${page==i}"> class ='active'</c:if>><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i}</a></li>
							      </c:forEach>
						      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
						   </ul>
						</nav>
					</c:if> --%>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>