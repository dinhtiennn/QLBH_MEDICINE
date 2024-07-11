package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.ChiTietDonHangBEAN;
import BEAN.DonHangBEAN;
import BEAN.GioHangBEAN;
import BEAN.NguoiDungBEAN;
import BEAN.ThuocBEAN;
import BO.ChiTietDonHangBO;
import BO.DonHangBO;
import BO.KhoBO;
import BO.ThuocBO;
import BO.giohangBO;

/**
 * Servlet implementation class GioHangCONTROLLER
 */
@WebServlet("/giohang")
public class GioHangCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDungBEAN nguoidung= (NguoiDungBEAN)session.getAttribute("nguoidung");
		String url = "giohang.jsp"; 
		String idThuoc = request.getParameter("idthuoc");
		String sua_IDthuoc = request.getParameter("btn-sua");
		String btn_xoacheckbox = request.getParameter("btn-xoacheckbox");
		String btn_XoaAll = request.getParameter("XoaAll");
		String datMua = request.getParameter("datmua");
		DonHangBO dhbo = new DonHangBO();
		ThuocBO tbo = new ThuocBO();
		DonHangBEAN donhang = new DonHangBEAN();
		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
		ArrayList<ChiTietDonHangBEAN> dsctdh = new ArrayList<ChiTietDonHangBEAN>();
		giohangBO ghbo = new giohangBO();
		KhoBO kbo = new KhoBO();
		if (nguoidung==null) {
			request.setAttribute("baoloilogin", "			");
			url = "index";
		} else {
			//them vao gio
			if(idThuoc!=null) {
				url = "index";
				try {
					ThuocBEAN thuoc = tbo.getThuoc(idThuoc);
					donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
					if (donhang == null) {
						//them don hang moi
						dhbo.insert(nguoidung);
						//tim don hang
						donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
						//them chitietdonhang vao don hang
						ctdhbo.insertCTDH(donhang, thuoc, 1);
//						//sua so luong trong kho -1
//						kbo.updateSL(idThuoc,-1);
						request.setAttribute("msgaddproduct", "Thêm vào giỏ hàng thành công!");
					}else {
//						System.out.println("idthuoc: "+ idThuoc);
						//them chitietdonhang vao don hang
						if(ctdhbo.timThuocByDH(donhang,idThuoc)==true) {
							ctdhbo.updateSL(donhang,idThuoc);
//							//sua so luong trong kho -1
//							kbo.updateSL(idThuoc,-1);
						}else {							
							ctdhbo.insertCTDH(donhang, thuoc, 1);
//							//sua so luong trong kho -1
//							kbo.updateSL(idThuoc,-1);
						}
						request.setAttribute("msgaddproduct", "Thêm vào giỏ hàng thành công!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//sua so luong
			if(sua_IDthuoc!=null) {
				String soLuong = request.getParameter(sua_IDthuoc);
				try {
					Pattern soluong_Pattern =  Pattern.compile("^[1-9]\\d*$");
					Matcher soluong_Matcher = soluong_Pattern.matcher(soLuong);
					if(!soluong_Matcher.matches()) {
						request.setAttribute("err-inputSL", "số lượng nhập vào không đúng!<br/>");
					}
					ThuocBEAN thuoc = tbo.getThuoc(sua_IDthuoc);
					donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
					int soLuongcu =ctdhbo.getSLByDHandThuoc(donhang.getIdDonHang(),thuoc.getIdThuoc());
					int soluongmoi = Integer.parseInt(soLuong);
					ctdhbo.SuaSoLuong(donhang,sua_IDthuoc,Integer.parseInt(soLuong));
//					//updateSl cu
//					kbo.updateSL(thuoc.getIdThuoc(),soLuongcu);
//					//updateSL moi
//					kbo.updateSL(thuoc.getIdThuoc(),-soluongmoi);
					url = "giohang.jsp";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(btn_xoacheckbox != null){
				try {
					String[] ds_checkbox = request.getParameterValues("checkbox-form");
					donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
					for (String string : ds_checkbox) {
						ctdhbo.deleteByIDThuoc(donhang, string);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			if(btn_XoaAll != null){			
				try {
					donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
					ctdhbo.deleteAllByHD(donhang);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			try {
				donhang = dhbo.selectDHChuaThanhToanOfKhachHang(nguoidung);
				if (donhang!=null) {					
					dsctdh = ctdhbo.selectAllByDh(donhang);
					ghbo.add(dsctdh);
					request.setAttribute("iddonhang", donhang.getIdDonHang());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("gh", ghbo);
		}
		request.setAttribute("servletName", request.getServletPath());
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
