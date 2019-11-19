<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <div class="col-md-2">
  	<div class="sidebar content-box" style="display: block;">
              <!-- Nav-bar -->
		<ul class="nav">
		    <!-- Main menu -->
		    <li class="current"><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/cat/index"><i class="glyphicon glyphicon-list"></i> Danh mục</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-book"></i> Post</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/user/index"><i class="glyphicon glyphicon-plus"></i> User</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/contact"><i class="glyphicon glyphicon-book"></i>Contact</a></li>
		   <!--  <li class="submenu">
		         <a href="#">
		            <i class="glyphicon glyphicon-list"></i> Pages
		            <span class="caret pull-right"></span>
		         </a>
		         Sub menu
		         <ul>
		            <li><a href="login.html">Login</a></li>
		            <li><a href="javascript:void(0)">Signup</a></li>
		        </ul>
		    </li> -->
		</ul>
		<!-- /.nav-bar -->
           </div>
  </div> --%>

   <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./"><img style="height:80px;width: 80px; " src="${pageContext.request.contextPath}/shop/img/logoh.jpg" alt=""></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                  	<br><br>
                    <li class="active">
                       <a href="${pageContext.request.contextPath}/admin/index"> <i class="menu-icon fa fa-fort-awesome"></i>Home</a>
                    </li>
                    <li class="active">
                       <a href="${pageContext.request.contextPath}/admin/cat/index" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Category</a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/product/index" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Product</a></a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/user/index" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>User</a>
                    </li>
                     <li class="active">
 						<a href="${pageContext.request.contextPath}/admin/pay/index" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Payments</a>                    
 					</li>
                     <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/bill/index" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-area-chart"></i>Bill</a>
                    </li>
                     <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Gift Code</a>
                    </li>



               
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->
    </div>
  