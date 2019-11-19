<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">BILL</div>
		  			</div>
				</div>
				<hr>	
			
				${msg}
				<form:errors path="cat.*"/>
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Họ Tên</th>
								<th>Phone</th>
								<th>Address</th>
								<th>Payment</th>
								<th>Status</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty listBill}">
									<c:forEach items="${listBill}" var="bill">
										<c:set var="urlEdit" value="${pageContext.request.contextPath}/admin/bill/edit/${bill.id}"/>
										<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/bill/del/${bill.id}"/>
										<tr class="odd gradeX">
											<td>${bill.id}</td>
											<td>${bill.fullname}</td>
											<td>${bill.phone}</td>
											<td>${bill.address}</td>
											<td>${bill.payment}</td>
											<td>${bill.status}</td>
											<td class="center text-center">
												<a href="${urlEdit}" title="sua" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span>VIEW</a>
			                                    <a href="${urlDel}" title="xoa" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> DELETE</a>
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