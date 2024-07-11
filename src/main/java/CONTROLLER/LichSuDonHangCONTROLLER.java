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
import BO.ThuocBO;
import BO.giohangBO;

/**
 * Servlet implementation class LichSuDonHangCONTROLLER
 */
@WebServlet("/lichsudonhang")
public class LichSuDonHangCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuDonHangCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonHangBEAN donhang = new DonHangBEAN();
		DonHangBO dhbo = new DonHangBO();
		giohangBO ghbo = new giohangBO();
		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
		ArrayList<ChiTietDonHangBEAN> dsctdh = new ArrayList<ChiTietDonHangBEAN>();
		ArrayList<DonHangBEAN> dsdonhangdamuathanhcong = new ArrayList<DonHangBEAN>();
		HttpSession session = request.getSession();
		NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
		String url = "lichsudonhang.jsp";
		String action = request.getParameter("action");
		String idDonhang = request.getParameter("iddonhang");
		System.out.println("action: "+action);
		if(nguoidung == null) {
			url = "index";
			request.setAttribute("baoloilogin", "			");
		}else {
			if(action!=null) {
				//action
				System.err.println("action: "+action);
				if(action.equals("showctdh") && idDonhang!=null) {
					try {
						donhang = dhbo.selectDH(Integer.parseInt(idDonhang));
						dsctdh = ctdhbo.selectAllByDh(donhang);
						ghbo.add(dsctdh);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("slctdh: "+ ghbo.ds.size());
					request.setAttribute("iddonhang", idDonhang);
					request.setAttribute("giohang", ghbo);
				}
			}else {
				try {
					dsdonhangdamuathanhcong = dhbo.selectAllDonHangAdminXacNhanByKhachHang(nguoidung);
					System.err.println("sldh: "+ dsdonhangdamuathanhcong.size());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("dsdonhangdamuathanhcong", dsdonhangdamuathanhcong);
			}
		}
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
