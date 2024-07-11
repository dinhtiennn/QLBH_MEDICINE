package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.KhoBean;
import BEAN.LoaiThuocBEAN;
import BEAN.NguoiDungBEAN;
import BEAN.NhaSanXuatBEAN;
import BEAN.ThuocBEAN;
import BO.KhoBO;
import BO.LoaiThuocBO;
import BO.NguoiDungBO;
import BO.NhaSanXuatBO;
import BO.ThuocBO;

/**
 * Servlet implementation class AdminCONTROLLER
 */
@WebServlet("/admin")
public class AdminCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String url = "";
        String action = request.getParameter("action");
        ThuocBO tbo = new ThuocBO();
        LoaiThuocBO ltbo = new LoaiThuocBO();
        NhaSanXuatBO nsxBo = new NhaSanXuatBO();
        String idthuoc = request.getParameter("idthuoc");
        NguoiDungBO ndbo = new NguoiDungBO();
        if(action != null) {
        	if(action.equals("changerinfor")) {
        		//thay đổi thông tin của thuốc
        		if(idthuoc!= null) {
        			request.setAttribute("idthuoc", idthuoc);
        			request.setAttribute("msgchangerinformationproduct", "msgchangerinformationproduct");
        			ArrayList<NhaSanXuatBEAN> dsnsx = new ArrayList<NhaSanXuatBEAN>();
					ArrayList<LoaiThuocBEAN> dsloaithuoc = new ArrayList<LoaiThuocBEAN>();
					try {
						dsnsx = nsxBo.selectAll();
						dsloaithuoc = ltbo.selectAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			request.setAttribute("dsnsx", dsnsx);
        			request.setAttribute("dsloaithuoc", dsloaithuoc);
        			url = "index";
        			RequestDispatcher rd = request.getRequestDispatcher(url);
        			rd.forward(request, response);
        		}
        		
        	}else if(action.equals("savechange")) {
        		String tenThuoc = request.getParameter("tenthuoc");
    			String anh = request.getParameter("anh");
    			String mota = request.getParameter("mota");
    			String thanhPhan = request.getParameter("thanhphan");
    			String huongDanSuDung = request.getParameter("huongdansudung");
    			int gia = Integer.parseInt(request.getParameter("gia"));
    			String idNhaSanXuat = request.getParameter("idnhasanxuat");
    			String idLoaiThuoc = request.getParameter("idloaithuoc");
    			ThuocBEAN thuoc = new ThuocBEAN(idthuoc, tenThuoc, anh, mota, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc);
    			try {
					tbo.updateInF(thuoc);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			url = "index";
    			RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}
        	else if(action.equals("deleteproduct")) {
        		try {
					tbo.delete(idthuoc);
				} catch (Exception e) {
					e.printStackTrace();
				}
        		url = "index";
    			RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}else if(action.equals("qlnv")) {
        		ArrayList<NguoiDungBEAN> dsnv = new ArrayList<NguoiDungBEAN>();
        		try {
					//xuất ra tất cả thông tin nhân viên
					dsnv = ndbo.selectAllNhanVien();
					//chỉnh sửa thông tin nhân viên
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		url = "nhanvien.jsp";
        		request.setAttribute("dsnv", dsnv);
        		RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}else if(action.equals("qlkho")) {
        		KhoBO kbo = new KhoBO();
        		ArrayList<KhoBean> dsk = new ArrayList<KhoBean>();
        		try {
        			//xuất ra thông tin kho
					dsk = kbo.selectAll();
					//thêm thuốc
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		System.out.println(dsk.size());
        		url = "kho.jsp";
        		request.setAttribute("dskho", dsk);
        		RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}else if(action.equals("themnhanvien")) {
        		String hoTen = request.getParameter("tennguoidung");
        		String diaChi = request.getParameter("diachi");
        		String soDienThoai = request.getParameter("sodienthoai");
        		String email = request.getParameter("email");
        		String tenDangNhap = request.getParameter("username");
        		request.setAttribute("tennhanvien", hoTen);
    			request.setAttribute("diachi", diaChi);
    			request.setAttribute("sodienthoai", soDienThoai);
    			request.setAttribute("email", email);
    			request.setAttribute("username", tenDangNhap);
        		if(hoTen != null && diaChi != null && soDienThoai != null && email != null && tenDangNhap != null) {
        			try {
        				if(ndbo.checkUsername(tenDangNhap)==false){
    						NguoiDungBEAN nguoiDungBEAN = new NguoiDungBEAN("", hoTen, email, soDienThoai, diaChi, tenDangNhap, "12345", true);
    						ndbo.insert(nguoiDungBEAN);
    						request.setAttribute("msgsuccess", "Thêm nhân viên thành công!<br/>");
    					}else {
    						request.setAttribute("baoloiusername", "Tên đăng nhập đã tồn tại!<br/>");
    						request.setAttribute("baoloiregister", "		");
    					}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		ArrayList<NguoiDungBEAN> dsnv = new ArrayList<NguoiDungBEAN>();
        		try {
					//xuất ra tất cả thông tin nhân viên
					dsnv = ndbo.selectAllNhanVien();
					//chỉnh sửa thông tin nhân viên
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		url = "nhanvien.jsp";
        		request.setAttribute("dsnv", dsnv);
        		RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}else if(action.equals("themsanpham")) {
				String tenThuoc = request.getParameter("tenthuoc");
    			String anh = "image/"+request.getParameter("anh");
    			String mota = request.getParameter("mota");
    			String thanhPhan = request.getParameter("thanhphan");
    			String huongDanSuDung = request.getParameter("huongdansudung");
    			String idNhaSanXuat = request.getParameter("idnhasanxuat");
    			String idLoaiThuoc = request.getParameter("idloaithuoc");
    			ArrayList<NhaSanXuatBEAN> dsnsx = new ArrayList<NhaSanXuatBEAN>();
    			ArrayList<LoaiThuocBEAN> dsloaithuoc = new ArrayList<LoaiThuocBEAN>();
    			if(tenThuoc!=null && anh != null && mota !=null && thanhPhan != null && huongDanSuDung != null && idLoaiThuoc != null && idNhaSanXuat!=null) {
    				int gia = Integer.parseInt(request.getParameter("gia"));
    				try {
    					int maxid = tbo.getmaxid()+1;
    					idthuoc = "T"+ maxid;
						ThuocBEAN thuoc = new ThuocBEAN(idthuoc, tenThuoc, anh, mota, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc);
						tbo.insert(thuoc);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				request.setAttribute("msgthemsanpham", "Thêm mặt hàng thành công!<br/>");
    			}else {    				
    				try {
    					dsnsx = nsxBo.selectAll();
    					dsloaithuoc = ltbo.selectAll();
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			request.setAttribute("dsnsx", dsnsx);
    			request.setAttribute("dsloaithuoc", dsloaithuoc);
        		url = "themsanpham.jsp";
        		RequestDispatcher rd = request.getRequestDispatcher(url);
    			rd.forward(request, response);
        	}
        }else {
        	url = "index";
        	request.setAttribute("baoloilogin", "			");
        }
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
