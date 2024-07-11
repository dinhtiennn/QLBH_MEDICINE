
<%@page import="BEAN.NguoiDungBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<style>
	.required{
		color: red;
	}
</style>
<header class="p-3 text-bg-light">
    <div class="">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
       
       	<a href="index">
       		<img style="width: 100px" alt="" src="logo/logo.jpg">
       	</a>
          
      

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="index" class="nav-link px-2 text-dark">Trang chủ</a></li>
          <li><a href="giohang" class="nav-link px-2 text-dark">Giỏ hàng <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
				  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2"/>
				</svg>
		  </a></li>
          <li><a href="donhangchoxacnhan" class="nav-link px-2 text-dark">Đơn hàng chờ xác nhận</a></li>
          <li><a href="lichsudonhang" class="nav-link px-2 text-dark">Lịch sử đơn hàng</a></li>
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
	        <% NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
					if(nguoidung == null){%>
					<button type="button" class="btn btn-outline-secondary me-2" data-bs-toggle="modal" data-bs-target="#staticBackdropLogin">Đăng nhập</button>
					<button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#staticBackdropRegister">Đăng ký</button>
					<%}else{%>
					<button type="button" class="btn btn-outline-secondary me-2"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
						  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
						</svg> <%=nguoidung.getHoTen()%></button>
					<a href="nguoidung?action=logout"><button type="button" class="btn btn-warning">Đăng xuất <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg></button></a>					
						<!-- <li><a class="btn" href="nguoidung?action=logout">Đăng xuất</a></li> -->
					<%}
				%>
         
        </div>
      </div>
    </div>
  	<%	
		String baoLoiRegister = (request.getAttribute("baoloiregister")!=null)?request.getAttribute("baoloiregister").toString():"";
		String baoLoiUsername = (request.getAttribute("baoloiusername")!=null)?request.getAttribute("baoloiusername").toString():"";
		String baoLoiPassword = (request.getAttribute("baoloipassword")!=null)?request.getAttribute("baoloipassword").toString():"";
	  	String baoLoiLogin = (request.getAttribute("baoloilogin")!=null)?request.getAttribute("baoloilogin").toString():"";
		String msgSuccess = (request.getAttribute("msgsuccess")!=null)?request.getAttribute("msgsuccess").toString():"";
		String baoLoiEmail = (request.getAttribute("err_email")!=null)?request.getAttribute("err_email").toString():"";
		String baoLoiSoDienThoai = (request.getAttribute("err_soDienThoai")!=null)?request.getAttribute("err_soDienThoai").toString():"";
		
		String msgSuccessAdproduct = (request.getAttribute("msgaddproduct")!=null)?request.getAttribute("msgaddproduct").toString():"";
		
		String tenNguoiDung = (request.getAttribute("tennguoidung")== null)?"":request.getAttribute("tennguoidung").toString();
		String diaChi = (request.getAttribute("diachi")== null)?"":request.getAttribute("diachi").toString();
		String soDienThoai = (request.getAttribute("sodienthoai")== null)?"":request.getAttribute("sodienthoai").toString();
		String email = (request.getAttribute("email")== null)?"":request.getAttribute("email").toString();
		String tenDangNhap = (request.getAttribute("username")== null)?"":request.getAttribute("username").toString();
	%>
	<!-- Modal Register -->
	<div class="modal fade" id="staticBackdropRegister" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-scrollable">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="staticBackdropLabel">Đăng ký</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<form action="nguoidung" method="post">
	      			<input type="hidden" name="servletName" value="<%=(String)request.getAttribute("servletName")%>">
	      			<h5>Thông tin khách hàng</h5>
	      			<hr>
		        		<div class="mb-3">
						    <label for="hovaten" class="form-label"><span class="required">*</span>Nhập họ và tên:</label> 
						    <input type="text" class="form-control" id="hovaten" name="tennguoidung" value="<%=tenNguoiDung%>" required="required" >
						</div>
						<div class="mb-3">
						    <label for="diachikhachhang" class="form-label"><span class="required">*</span>Địa chỉ khách hàng:</label>
						    <input type="text" class="form-control" id="diachikhachhang" name="diachi" value="<%=diaChi%>" required="required">
						</div>
						<div class="mb-3">
						<span class="required" id="errSDT"></span>
						    <label for="sodienthoai" class="form-label"><span class="required">*</span>Số điện thoại:</label>
						    <input type="tel" class="form-control" id="sodienthoai" name="sodienthoai" value="<%=soDienThoai%>" required="required">
						</div>
						<div class="mb-3">
							<span class="required" id="errEmail"></span>
						    <label for="email" class="form-label"><span class="required">*</span>Nhập email:</label>
						    <input type="email" class="form-control" id="email" name="email" value="<%=email%>" required="required">
						</div>
					<h5>Tài khoản</h5>
					<hr>
						<div class="mb-3">
							<span class="required" id="errUsernameRegister"></span>
						  	<label for="usename-register" class="form-label"><span class="required">*</span>Nhập tên đăng nhập:</label>
						  	<input type="text" class="form-control" id="usename-register" name="username" value="<%=tenDangNhap%>" required="required">
						</div>
						<span class="required" id="errPasswordRegister"></span>
						<div class="mb-3">
						  	<label for="password-register" class="form-label"><span class="required">*</span>Nhập mật khẩu:</label>
						  	<input type="password" class="form-control" id="password-register" name="password" required="required" onkeyup="kiemTraMatKhau()">
						</div>
						<div class="mb-3">
							<label for="repassword-register" class="form-label"><span class="required">*</span>Nhập lại mật khẩu:<span id="msg" class="required"></span></label>
						    <input type="password" class="form-control" id="repassword-register" name="repassword" required="required" onkeyup="kiemTraMatKhau()">
						</div>
						<div class="mb-3">
							<label for="agreeDK" class="form-label">
								<span class="required">*</span>
								Đồng ý với các <a href="#" class="text-dark-emphasis">điều khoản:</a>
							</label>
						    <input type="checkbox" class="form-check-input" id="agreeDK" name="agreeDK" onchange="checkDieuKhoan()">
							<br>
						</div>
					    <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
					        <button type="submit" id="submit" disabled class="btn btn-primary " name="action" value="register">Đăng kí</button>
					    </div>
				</form>
				<form action="nguoidung" method="post">
					<input type="hidden" name="servletName" value="<%=(String)request.getAttribute("servletName")%>">
					<button type="submit" class="btn" name="action" value="loginbylink">Đăng nhập</button>
   				</form>
			</div>
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
		      	<a href="nguoidung?action=index">		      		
	      			<button type="submit" class="btn btn-success" name="action" value="index">Trang chủ</button>
		      	</a>
	      		<form action="nguoidung" method="post">
	      			<input type="hidden" name="servletName" value="<%=(String)request.getAttribute("servletName")%>">
	      			<button type="submit" class="btn btn-success" name="action" value="loginbylink">Đăng nhập</button>
	      		</form>
	      	</div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Success Addproduct-->
		<div class="modal fade" id="staticBackdropAddproduct" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-body">
		        	<div class="alert alert-success" role="alert">
		        		<span id="msgsuccessaddproduct"></span>
					</div>			
				</div>
		      	<div class="modal-footer">
			      	<a href="index">		      		
		      			<button type="button" class="btn btn-success">Tiếp tục mua</button>
			      	</a>
			      	<a href="giohang">		      		
		      			<button type="button" class="btn btn-success">Đi đến giỏ hàng</button>
			      	</a>
		      	</div>
		    </div>
		  </div>
		</div>
		
	<!-- Modal -->
	<div class="modal fade" id="staticBackdropLogin" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  	<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<h1 class="modal-title fs-5" id="staticBackdropLabel">Đăng nhập</h1>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
		      	<div class="modal-body">
					<div class="row">
				      	<div class="col">
					        <form action="nguoidung" method="post">
				        		<input type="hidden" name="servletName" value="<%=(String)request.getAttribute("servletName")%>">
				        		<span class="required" id="msg-err-login"></span>
								  <div class="mb-3">
								    <label for="exampleInputEmail1" class="form-label">Tên đăng nhập</label>
								    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" required="required" value="<%=tenDangNhap%>">
								  </div>
								  <div class="mb-3">
								    <label for="exampleInputPassword1" class="form-label">Password</label>
								    <input type="password" class="form-control" id="exampleInputPassword1" name="password" required="required">
								  </div>
							  	  <%-- <%if(session.getAttribute("countlogin")!=null){
								  	 	if((int)session.getAttribute("countlogin")>=(int)3){%>
									  	<div class="mb-3">
									  		<jsp:include page="capcha.jsp"></jsp:include>
										</div>
								  <%}}%>   --%>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <button type="submit" class="btn btn-primary" name="action" value="login">Đăng nhập</button>
							      </div>
							</form>
				      	</div>
			      	</div>
		      		<form action="nguoidung" method="post">
   						<input type="hidden" name="servletName" value="<%=(String)request.getAttribute("servletName")%>">
   						<button type="submit" class="btn" name="action" value="registerbylink">Đăng ký</button>
   					</form>	 
			   	</div>
			</div>
		</div>
	</div>
	</header>
	<script >
	function checkDieuKhoan(){
		dieuKhoan = document.getElementById("agreeDK");
		if(dieuKhoan.checked == true){
			document.getElementById("submit").removeAttribute("disabled");
		}else if(dieuKhoan.checked == false){
			document.getElementById("submit").disabled = "disabled";
		}
	}
	function kiemTraMatKhau(){
		matKhau = document.getElementById("password-register").value;
		matKhauNhapLai = document.getElementById("repassword-register").value;
		if(matKhau!=matKhauNhapLai){
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		}else{
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	document.addEventListener("DOMContentLoaded", function() {
		  // Lấy giá trị của các thuộc tính từ request.getAttribute
		  var baoLoiUsername = "<%=baoLoiUsername%>";
		  var baoLoiPassword = "<%=baoLoiPassword%>";
		  var msgSuccess = "<%=msgSuccess%>";
		  var baoLoiRegister = "<%=baoLoiRegister%>";
		  var baoLoiLogin = "<%=baoLoiLogin%>";
		  var baoLoiEmail = "<%=baoLoiEmail%>";
		  var baoLoiSDT = "<%=baoLoiSoDienThoai%>";
		  var msgSuccessAdproduct = "<%=msgSuccessAdproduct%>";
		  // Kiểm tra nếu một trong hai giá trị 
		  if (baoLoiRegister.length > 0) {
		    // Lấy tham chiếu đến modal
		    var modalRegister = document.getElementById("staticBackdropRegister");
		    // Khởi tạo modal bằng Bootstrap JavaScript
		    var myModal = new bootstrap.Modal(modalRegister, {
		      backdrop: 'static',
		      keyboard: false
		    });

		    // Hiển thị modal
		    myModal.show();
		    
		    document.getElementById("errUsernameRegister").innerHTML = baoLoiUsername;  	
		    document.getElementById("errPasswordRegister").innerHTML = baoLoiPassword;
		    document.getElementById("errEmail").innerHTML = baoLoiEmail;
		    document.getElementById("errSDT").innerHTML = baoLoiSDT;
		  
		  }else if(msgSuccessAdproduct.length > 0){
				// Lấy tham chiếu đến modal
			    var modalLogin = document.getElementById("staticBackdropAddproduct");

			    // Khởi tạo modal bằng Bootstrap JavaScript
			    var myModal = new bootstrap.Modal(modalLogin, {
			      backdrop: 'static',
			      keyboard: false
			    });

			    // Hiển thị modal
			    myModal.show();
			    document.getElementById("msgsuccessaddproduct").innerHTML = msgSuccessAdproduct;
		  }else if(msgSuccess.length > 0){
			// Lấy tham chiếu đến modal
			    var modalLogin = document.getElementById("staticBackdropSuccess");

			    // Khởi tạo modal bằng Bootstrap JavaScript
			    var myModal = new bootstrap.Modal(modalLogin, {
			      backdrop: 'static',
			      keyboard: false
			    });

			    // Hiển thị modal
			    myModal.show();
			    document.getElementById("msgsuccess").innerHTML = msgSuccess;
		  }else if(baoLoiLogin.length > 0){
			  // Lấy tham chiếu đến modal
			    var modalLogin = document.getElementById("staticBackdropLogin");

			    // Khởi tạo modal bằng Bootstrap JavaScript
			    var myModal = new bootstrap.Modal(modalLogin, {
			      backdrop: 'static',
			      keyboard: false
			    });

			    // Hiển thị modal
			    myModal.show();
			    document.getElementById("msg-err-login").innerHTML = baoLoiLogin;
		  }
		});
</script>
