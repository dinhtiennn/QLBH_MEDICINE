<%@page import="BO.giohangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
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
</head>
<body>	



	<jsp:include page="header.jsp"></jsp:include>
	
	
	
	<div class="m-5">
			<div class="row">
			    <div class="">
			    <form action="giohang" method="get">
			    <%giohangBO giohang = (giohangBO)request.getAttribute("gh");
			    String iddonhang = request.getAttribute("iddonhang")+"";
				if(giohang != null && giohang.ds.size()>0 && !iddonhang.equals("null")){
					int soLuongHang = giohang.ds.size();%>
					<span id="err-inpSL" class="required"><%=(request.getAttribute("err-inputSL")!=null)?request.getAttribute("err-inputSL").toString():"" %></span>
				    <table class="table">
						<thead>
							<tr>
								<th></th>
								<th scope="col">STT</th>
					      		<th scope="col">Tên thuốc</th>
					      		<th scope="col">Số lượng</th>
					      		<th scope="col" colspan="3">Giá</th>
					  		</tr>
				  		</thead>
				  		<tbody>	
							
								 <%for(int i = 0; i< soLuongHang; i++){%>
							  		<tr>
							      		<td>
							      			<input type="checkbox" class="form-check-input" name="checkbox-form" value="<%=giohang.ds.get(i).getIdTHuoc()%>">
							      		</td>	
								      	<th scope="row"><%=i %></th>
								      	<td><%=giohang.ds.get(i).getTenThuoc()%></td>
							      		<td><%=giohang.ds.get(i).getSoLuongMua()%></td>
							      		<td><%=giohang.ds.get(i).getGia()%>đ</td>
							      		<td>	
							      			<div class="d-flex justify-content-end"  >
							      				<div class="" style="width: 200px;">
									      			<input type="text" class="form-control h-auto" name="<%=giohang.ds.get(i).getIdTHuoc()%>">
							      				</div>
							      				<div class="" style="width: 132px; margin-left: 4px; margin-top: 4px;">
							      					<button type='submit' class="btn btn-primary form-control btn-sm my-auto h-auto" name="btn-sua" value="<%=giohang.ds.get(i).getIdTHuoc()%>">Cập nhật số lượng</button>
							      				</div>	
											</div>
							      		</td>	
								     </tr>   
							  		<%}%>
						  		</tbody>
							  	<tfoot>
								    <tr>
										<th scope="row" colspan="4">Tổng tiền</th>
								        <th scope="row"><%=giohang.getThanhTien()%>đ</th>
								    </tr>
							  	</tfoot>
							</table>
							<div class="row">
								<div class="col-2  d-flex justify-content-start">	
									<button type='submit' class="btn btn-primary btn-sm my-auto" name="XoaAll" value="XoaAll">Trả lại toàn bộ</button>								
			      				</div>
								<div class="col-3  d-flex justify-content-start">						        	
						      		<div class="col" >  
						      			<button type='submit' class="btn btn-primary btn-sm my-auto" name="btn-xoacheckbox" value="btn-xoacheckbox" >Xóa mặt hàng đã chọn</button>
									</div>
								</div> 
								<div class="col-2  d-flex justify-content-start">						        	
						      		<div class="col" >  
						      			<a href="thanhtoan?action=datmua&iddonhang=<%=iddonhang%>">
										 	<button type="button" class="btn btn-success btn-sm my-auto">Đặt mua</button>
						      			</a>
									</div>
								</div> 		
			      			</div>
						</form>
					<%}else{%>	
					<div class="container">
						<h2 class="d-flex justify-content-center">Giỏ hàng trống!</h2>
					</div>
					<%} %>	
			    </div>
			</div>
		</div>
</body>
</html>