<%@page import="BEAN.DonHangBEAN"%>
<%@page import="BO.NguoiDungBO"%>
<%@page import="BO.giohangBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		 <table class="table">
			<%
			ArrayList<DonHangBEAN> dsdonhang = (ArrayList<DonHangBEAN>)request.getAttribute("dsdonhangchoxacnhan");
			giohangBO dsctdh = (giohangBO)request.getAttribute("giohang");
			if(dsdonhang != null && dsdonhang.size()>0){%>
			<thead>
				<tr>
		      		<th scope="col">Mã đơn hàng</th>
		      		<th scope="col">Ngày mua hàng</th>
		  		</tr>
	  		</thead>
	  		<tbody>	
				<%//Hiển thị 
					
					int soLuongHoaDon = dsdonhang.size();
					for(int i = 0; i< soLuongHoaDon; i++){
						%>
				  		<tr>
					      	<td><%=dsdonhang.get(i).getIdDonHang()%></td>
				      		<td><%=dsdonhang.get(i).getNgayDat()%></td>	
			      			<td><a href="donhangchoxacnhan?action=showctdh&iddonhang=<%=dsdonhang.get(i).getIdDonHang()%>"><button type="button" class="btn btn-success btn-sm">Chi tiết đơn hàng</button></a></td>
					     </tr>   
					<%}%>
	  		</tbody>
			<%}else if(dsctdh!=null){
			String iddonhang = request.getAttribute("iddonhang")+"";%>
						<thead>
							<tr>
								<th scope="col">STT</th>
					      		<th scope="col">Tên thuốc</th>
					      		<th scope="col">Số lượng mua</th>
					      		<th scope="col">Giá</th>
					      		<th scope="col">Thành tiền</th>
					  		</tr>
				  		</thead>
			<tbody>	
			<%
			int soLuongHang = dsctdh.ds.size();
			for(int i = 0; i< soLuongHang; i++){%>
		  		<tr>
			      	<th scope="row"><%=i %></th>
			      	<td><%=dsctdh.ds.get(i).getTenThuoc()%></td>
		      		<td><%=dsctdh.ds.get(i).getGia()%></td>
		      		<td><%=dsctdh.ds.get(i).getSoLuongMua()%></td>
		      		<td><%=dsctdh.ds.get(i).getThanhTien()%>đ</td>
				</tr>
		     <% }%>
	     	</tbody>
  			<tfoot>
			    <tr>
					<th scope="row" colspan="4">Tổng tiền</th>
			        <th scope="row"><%=dsctdh.getThanhTien()%>đ</th>
			    </tr>
				
	      		<td>
	      			<a href="donhangchoxacnhan">									      		
	      				<button type="button" class="btn btn-success form-control btn-sm my-auto h-auto">Quay lại</button>		  		
	      			</a>
	      		</td>
	      		<td>
	      			<a href="donhangchoxacnhan?action=deletedh&iddonhang=<%=iddonhang%>">									      		
	      				<button type="button" class="btn btn-success form-control btn-sm my-auto h-auto">Hủy đơn hàng</button>		  		
	      			</a>
	      		</td>
	     	</tfoot>
	     	<%}else{%>	
				<div class="container">
					<h2 class="d-flex justify-content-center">Không có đơn hàng chờ xác nhận!</h2>
				</div>
			<%} %>	
		</table> 
	</div>
</body>
</html>