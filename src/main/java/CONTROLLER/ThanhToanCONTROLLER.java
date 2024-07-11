package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.ChiTietDonHangBEAN;
import BEAN.DonHangBEAN;
import BEAN.NguoiDungBEAN;
import BO.ChiTietDonHangBO;
import BO.DonHangBO;
import BO.KhoBO;
import BO.giohangBO;

/**
 * Servlet implementation class ThanhToanCONTROLLER
 */
@WebServlet("/thanhtoan")
public class ThanhToanCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String iddonhang= request.getParameter("iddonhang");
		DonHangBEAN donhang = new DonHangBEAN();
		DonHangBO dhbo= new DonHangBO();
		HttpSession session = request.getSession();
		NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
		giohangBO ghbo = new giohangBO();
		ArrayList<ChiTietDonHangBEAN> dsctdh = new ArrayList<ChiTietDonHangBEAN>();
		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
		String url = "";
		System.out.println("iddonhang: "+iddonhang);
		System.out.println("action: "+action);
		if (nguoidung!=null) {
			if(action!=null) {
				if (action.equals("datmua") && !iddonhang.equals("null")) {
					//chuyển qua thanhtoan
					try {
						donhang = dhbo.selectDH(Integer.parseInt(iddonhang));
						if (donhang!=null) {					
							dsctdh = ctdhbo.selectAllByDh(donhang);
							ghbo.add(dsctdh);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					url = "thanhtoandonhang.jsp";
					request.setAttribute("giohang", ghbo);
					request.setAttribute("iddonhang", donhang.getIdDonHang());
				}
				if(action.equals("thanhtoan") && !iddonhang.equals("null")) {
					try {
						KhoBO kbo = new KhoBO();
						//đổi trạng thái xác nhận của khách hàng
						donhang = dhbo.selectDH(Integer.parseInt(iddonhang));
						if (donhang!=null) {					
							dhbo.updateXacNhanKhachHang(Integer.parseInt(iddonhang));
						}
						//update sl trong kho
						ArrayList<ChiTietDonHangBEAN> dsctdhb = ctdhbo.selectAllByDh(donhang);
						for (ChiTietDonHangBEAN s : dsctdhb) {
							kbo.updateSL(s.getIdThuoc(), -s.getSoLuong());
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					url="index";
				}
			}
		}else {
			request.setAttribute("baoloilogin", "			");
			url = "index";
		}
		System.out.println("size: "+ghbo.ds.size());
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
