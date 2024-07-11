package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.LoaiThuocBEAN;
import BEAN.NhaSanXuatBEAN;
import BEAN.ThuocBEAN;
import BO.LoaiThuocBO;
import BO.ThuocBO;


/**
 * Servlet implementation class indexCONTROLLER
 */
@WebServlet("/index")
public class indexCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		String url = "index.jsp";
		String msg = (request.getAttribute("msg")!=null)?(String)request.getAttribute("msg"):"";
		String idthuoc = (request.getAttribute("idthuoc")!=null)?(String)request.getAttribute("idthuoc"):"";
		String msgchangerinformationproduct = (request.getAttribute("msgchangerinformationproduct")!=null)?(String)request.getAttribute("msgchangerinformationproduct"):"";
		ArrayList<NhaSanXuatBEAN> dsnsx = (ArrayList<NhaSanXuatBEAN>)request.getAttribute("dsnsx");
		ArrayList<LoaiThuocBEAN> dslt = (ArrayList<LoaiThuocBEAN>)request.getAttribute("dsloaithuoc");
		try {
			LoaiThuocBO ltbo = new LoaiThuocBO();
			ThuocBO tbo = new ThuocBO();
			request.setAttribute("dsloai", ltbo.selectAll());
			ArrayList<ThuocBEAN> dsThuoc = tbo.selectAll();
			String maloai = request.getParameter("maloai");
			String key_String = request.getParameter("txtkey");
			
			int page = (request.getParameter("page")==null) ? 1 : Integer.parseInt(request.getParameter("page"));
			int dataThuocOnPage = 8;
			int line = page*8-8;
			int endPage = tbo.getDataOfThuoc()/8;
			if(tbo.getDataOfThuoc()%8 != 0) {
				endPage += 1;
			}
			dsThuoc = tbo.getArrThuocOnPage(line, dataThuocOnPage);
			if(maloai != null){
				endPage = tbo.getDataOfThuocByMaLoai(maloai)/8;
				if(tbo.getDataOfThuocByMaLoai(maloai)%8 != 0) {
					endPage += 1;
				}
				dsThuoc = tbo.getArrThuocByMaloai(maloai,line,dataThuocOnPage);
				request.setAttribute("maloai", maloai);
			}
			if(key_String != null){
				endPage = tbo.getDataOfThuocByKey(key_String)/8;
				if(tbo.getDataOfThuocByKey(key_String)%8 != 0) {
					endPage += 1;
				}
								
				dsThuoc = tbo.getArrThuocByKey(key_String,line,dataThuocOnPage);
				request.setAttribute("txtkey", key_String);
				if(endPage==0) {
					System.out.println("Từ khóa tìm kiếm không tồn tại!");
					request.setAttribute("errkey", "Từ khóa tìm kiếm không tồn tại!");
				}
				
			}
//			System.out.println("so luong Thuoc: "+tbo.getDataOfThuoc());
//			System.out.println("so luong thuoc trong trang: "+dsThuoc.size());
//			System.out.println("so luong trang: "+endPage);
			request.setAttribute("endpage", endPage);
			request.setAttribute("dsthuoc", dsThuoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("dslt", dslt);
		request.setAttribute("dsnsx", dsnsx);
		request.setAttribute("idthuoc", idthuoc);
		request.setAttribute("msgchangerinformationproduct", msgchangerinformationproduct);
		request.setAttribute("msg", msg);
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
