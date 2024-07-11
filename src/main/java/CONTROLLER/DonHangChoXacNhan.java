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
 * Servlet implementation class DonHangChoXacNhan
 */
@WebServlet("/donhangchoxacnhan")
public class DonHangChoXacNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHangChoXacNhan() {
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
		ArrayList<DonHangBEAN> dsdhchoxacnhan = new ArrayList<DonHangBEAN>();
		HttpSession session = request.getSession();
		NguoiDungBEAN nguoidung = (NguoiDungBEAN)session.getAttribute("nguoidung");
		String url = "donhangchoxacnhan.jsp";
		String action = request.getParameter("action");
		String idDonhang = request.getParameter("iddonhang");
		System.out.println("action: "+action);
		if(nguoidung == null) {
			url = "index";
			request.setAttribute("baoloilogin", "			");
		}else {
			if(action!=null) {
				//kiem tra iddonhang
				if(idDonhang!=null) {
					System.out.println("iddonhang: "+idDonhang);
					try {
						donhang = dhbo.selectDH(Integer.parseInt(idDonhang));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//action
				if(action.equals("showctdh")) {
					try {
						dsctdh = ctdhbo.selectAllByDh(donhang);
						System.out.println("slctdh: "+dsctdh.size());
						ghbo.add(dsctdh);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("iddonhang", idDonhang);
					request.setAttribute("giohang", ghbo);
				}
				//action
				if(action.equals("deletedh")) {
					KhoBO kbo = new KhoBO();
					try {
						//update sl trong kho
						ArrayList<ChiTietDonHangBEAN> dsctdhb = ctdhbo.selectAllByDh(donhang);
						for (ChiTietDonHangBEAN s : dsctdhb) {
							kbo.updateSL(s.getIdThuoc(),s.getSoLuong());
						}
						//delete ctdh
						ctdhbo.deleteAllByHD(donhang);
						//delete dh
						dhbo.delete(donhang);
						//update sl kho
						dsdhchoxacnhan = dhbo.selectAllDonHangDaXacNhanByKhachHang(nguoidung);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("dsdonhangchoxacnhan", dsdhchoxacnhan);
				}
			}else {
				try {
					dsdhchoxacnhan = dhbo.selectAllDonHangDaXacNhanByKhachHang(nguoidung);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("dsdonhangchoxacnhan", dsdhchoxacnhan);
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
