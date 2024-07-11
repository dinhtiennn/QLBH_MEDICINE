
<%@page import="BEAN.NguoiDungBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<header class="p-3 text-bg-light">
    <div class="">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			  <a href="index">
	       		<img style="width: 100px" alt="" src="logo/logo.jpg">
	       	</a>
		         <% 	
		         	NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
		         %>
		      <ul  class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
			      <li>
					<a class="nav-link px-2 text-dark" href="index">Sản phẩm</a>
			      </li>
		    
		       
		       
		         <li >
		          <a class="nav-link px-2 text-dark" href="xacnhan">Đơn hàng chờ xác nhận</a>
		        </li>
		         <li >
		          <a class="nav-link px-2 text-dark" href="donhang">Lịch sử đơn hàng</a>
		        </li>
		      </ul>  
		       <form action="index" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 d-flex justify-content-center" role="search">
		          <div class="row">
		      					<div class="col">
									<input type="text" class="form-control form-control-dark text-bg-light" placeholder="Search..." aria-label="Search" name="txtkey">
		      					</div>
		      					<div class="col">
									<button class="btn btn-primary" type="submit" class="btn btn-outline-success">Tìm kiếm</button>
		      					</div>
		      				</div>
		        </form>
		   <div class="text-end d-flex justify-content-center">
	        <%
					if(nguoidung != null){%>
						<button type="button" class="btn btn-outline-secondary me-2"><%=nguoidung.getHoTen()%></button>
						<a href="nguoidung?action=logout"><button type="button" class="btn btn-warning">Đăng xuất</button></a>					
							<!-- <li><a class="btn" href="nguoidung?action=logout">Đăng xuất</a></li> -->
					<%}%>
         
        </div>
		    </div>
		  </div>
	 </div>
    </header>