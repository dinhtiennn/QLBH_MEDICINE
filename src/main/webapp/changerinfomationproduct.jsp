<%@page import="BEAN.ThuocBEAN"%>
<%@page import="BEAN.LoaiThuocBEAN"%>
<%@page import="BEAN.NhaSanXuatBEAN"%>
<%@page import="BO.NhaSanXuatBO"%>
<%@page import="BO.LoaiThuocBO"%>
<%@page import="BO.ThuocBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

<!-- Modal -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Thay đổi thông tin sản phẩm</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
  <%
  ArrayList<NhaSanXuatBEAN> dsnsx = (ArrayList<NhaSanXuatBEAN>)request.getAttribute("dsnsx");
  ArrayList<LoaiThuocBEAN> dslt = (ArrayList<LoaiThuocBEAN>)request.getAttribute("dslt");
  String idthuoc = (request.getAttribute("idthuoc")!=null)?(String)request.getAttribute("idthuoc"):null; 
  String msgchangerinformationproduct = (request.getAttribute("msgchangerinformationproduct")!=null)?(String)request.getAttribute("msgchangerinformationproduct"):null; 
  ThuocBO tbo = new ThuocBO();
  LoaiThuocBO ltbo = new LoaiThuocBO();
  NhaSanXuatBO nsxbo = new NhaSanXuatBO();
  ThuocBEAN thuoc = tbo.getThuoc(idthuoc);
  %>
      	<form action="admin?action=changerinfor">
      					<div class="mb-3 row">
						    <label class="col col-form-label">ID Thuốc:</label>
						    <div class="col">
						      <input type="text" readonly class="form-control-plaintext" id="idthuoc" value="<%=idthuoc%>" name="idthuoc">
						    </div>
					    </div>
        				<div class="mb-3">
						    <label class="form-label"><span class="required">*</span>Nhập tên thuốc:</label> 
						    <input type="text" class="form-control" name="tenthuoc" value="<%=thuoc.getTenThuoc() %>" required="required" >
						</div>
						<div class="mb-3">
						    <label class="form-label"><span class="required">*</span>Ảnh:</label>
						    <input type="text" class="form-control" name="anh" value="<%=thuoc.getAnh()%>" required="required">
						</div>
						<div class="mb-3">
						<span class="required" id="errSDT"></span>
						    <label class="form-label"><span class="required">*</span>Mô tả:</label>
						    <input type="text" class="form-control" name="mota" value="<%=thuoc.getMoTa()%>" required="required">
						</div>
						<div class="mb-3">
						    <label class="form-label"><span class="required">*</span>Thành phần:</label>
						    <input type="text" class="form-control" name="thanhphan" value="<%=thuoc.getThanhPhan()%>" required="required">
						</div>
						<div class="mb-3">
						    <label class="form-label"><span class="required">*</span>Hướng dẫn sử dụng:</label>
						    <input type="text" class="form-control"  name="huongdansudung" value="<%=thuoc.getHuongDanSuDung()%>" required="required">
						</div>
						<div class="mb-3">
						    <label class="form-label"><span class="required">*</span>Giá:</label>
						    <input type="text" class="form-control"  name="gia" value="<%=thuoc.getGia()%>" required="required">
						</div>
						<div class="mb-3">
							<label class="form-label"><span class="required">*</span>Nhà sản xuất:</label>
							<select class="form-select" aria-label="Default select example" name="idnhasanxuat" required="required">
							  <option selected value="<%=thuoc.getIdNhaSanXuat()%>"><%=nsxbo.selectbyid(thuoc.getIdNhaSanXuat()).getTenNhaSanXuat() %></option>
							  <%for(NhaSanXuatBEAN nsx : dsnsx){%>
							  	<option value="<%=nsx.getIdNhaSanXuat()%>"><%=nsx.getTenNhaSanXuat() %></option>
							  <%}%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label"><span class="required">*</span>Loại thuốc:</label>	
							<select class="form-select" aria-label="Default select example" name="idloaithuoc" required="required">
							 <option selected value="<%=thuoc.getIdLoaiThuoc()%>"><%=(ltbo.selectltbyid(thuoc.getIdLoaiThuoc())).getTenLoaiThuoc()%></option>
							  <%for(LoaiThuocBEAN lt : dslt){%>
									<option value="<%=lt.getIdLoaiThuoc()%>"><%=lt.getTenLoaiThuoc()%></option>
							  <%}%>
								  
							</select>
						</div>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        				<button type="submit" class="btn btn-primary" name="action" value="savechange">Save changes</button>
      				</form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  // Lấy tham chiếu đến modal
    var modalLogin = document.getElementById("exampleModal1");

    // Khởi tạo modal bằng Bootstrap JavaScript
    var myModal = new bootstrap.Modal(modalLogin, {
      backdrop: 'static',
      keyboard: false
    });

    // Hiển thị modal
    myModal.show();
</script>