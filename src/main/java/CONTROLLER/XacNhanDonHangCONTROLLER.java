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
import BO.giohangBO;

/**
 * Servlet implementation class XacNhanDonHangCONTROLLER
 */
@WebServlet("/xacnhan")
public class XacNhanDonHangCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDonHangCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "donhangchoxacnhanadmin.jsp";
		DonHangBO dhbo = new DonHangBO();
		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
		ArrayList<DonHangBEAN> dsdhchoxacnhan = new ArrayList<DonHangBEAN>();
		ArrayList<ChiTietDonHangBEAN> dsctdh = new ArrayList<ChiTietDonHangBEAN>();
		giohangBO ghbo = new giohangBO();
		HttpSession session = request.getSession();
		NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
		if(nguoidung == null) {
			url = "index";
			request.setAttribute("baoloilogin", "			");
		}else {			
			if(action != null) {
				String iddonhang = request.getParameter("iddonhang");
				if(!iddonhang.equals("null")) {
					if (action.equals("showctdh")) {					
						try {
							DonHangBEAN donhang = dhbo.selectDH(Integer.parseInt(iddonhang));
							dsctdh = ctdhbo.selectAllByDh(donhang);
							System.out.println("slctdh: "+dsctdh.size());
							ghbo.add(dsctdh);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.setAttribute("iddonhang", iddonhang);
						request.setAttribute("giohang", ghbo);
					}
					if (action.equals("xacnhan")) {
						try {
							dhbo.updateXacNhanAdmin(Integer.parseInt(iddonhang));
							dsdhchoxacnhan = dhbo.selectAllDHChoXacNhan();
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.setAttribute("dsxacnhan", dsdhchoxacnhan);
					}
				}
			}else {				
				try {
					dsdhchoxacnhan = dhbo.selectAllDHChoXacNhan();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("dsxacnhan", dsdhchoxacnhan);
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
