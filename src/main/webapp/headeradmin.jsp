<%@page import="BEAN.AdminBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
		         	 AdminBEAN admin = (AdminBEAN)session.getAttribute("admin");
		         	 String msgthemsanpham = (request.getAttribute("msgthemsanpham")!=null)?request.getAttribute("msgthemsanpham").toString():"";
		         %>
		      <ul  class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
			      <li>
					<a class="nav-link px-2 text-dark" href="index">Sản phẩm</a>
			      </li>
		    
		       		<li>
					<a class="nav-link px-2 text-dark" href="admin?action=themsanpham">Thêm mặt hàng</a>
			      </li>
		       
		         <li >
		          <a class="nav-link px-2 text-dark" href="admin?action=qlnv">Nhân viên</a>
		        </li>
		         <li >
		          <a class="nav-link px-2 text-dark" href="admin?action=qlkho">Kho</a>
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
					if(admin != null){%>
						<button type="button" class="btn btn-outline-secondary me-2"><%=admin.getTenAdmin()%></button>
						<a href="nguoidung?action=logout"><button type="button" class="btn btn-warning">Đăng xuất</button></a>					
							<!-- <li><a class="btn" href="nguoidung?action=logout">Đăng xuất</a></li> -->
					<%}%>
         
        </div>
		    </div>
		  </div>
	    <!-- Modal Success Register-->
		<div class="modal fade" id="staticBackdropSuccess" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-body">
		        	<div class="alert alert-success" role="alert">
		        		<span id="msgsuccess"></span>
					</div>			
				</div>
		      	<div class="modal-footer">
			      	<a href="index">		      		
		      			<button type="submit" class="btn btn-success">Trang chủ</button>
			      	</a>
		      		<a href="admin?action=themsanpham">		      		
		      			<button type="submit" class="btn btn-success">Tiếp tục</button>
			      	</a>
		      	</div>
		    </div>
		  </div>
		</div>
    </header>
	<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		  // Lấy giá trị của các thuộc tính từ request.getAttribute
		  var msgthemsanpham = "<%=msgthemsanpham%>";
		  // Kiểm tra nếu một trong hai giá trị 
		 if(msgthemsanpham.length > 0){
			// Lấy tham chiếu đến modal
			    var modalLogin = document.getElementById("staticBackdropSuccess");

			    // Khởi tạo modal bằng Bootstrap JavaScript
			    var myModal = new bootstrap.Modal(modalLogin, {
			      backdrop: 'static',
			      keyboard: false
			    });

			    // Hiển thị modal
			    myModal.show();
			    document.getElementById("msgsuccess").innerHTML = msgthemsanpham;
		  }
		});
	</script>