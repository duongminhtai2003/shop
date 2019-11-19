<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="${pageContext.request.contextPath}/admin/index">Harry-Shop</a>
	                 	
	                 </h1>
	                 
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12"></div>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <div class="dropdown">
						  <button onclick="myFunction()" class="dropbtn">My Account</button>
						  <div id="myDropdown" class="dropdown-content">
						    <a href="${pageContext.request.contextPath}/admin/setting/edit/${userlogin.id}">Setting Info</a>
						    
						    <a href="${pageContext.request.contextPath}/auth/logout">Logout</a>
						  </div>
						</div>
						
						
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>