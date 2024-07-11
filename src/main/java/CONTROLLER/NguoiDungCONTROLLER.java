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

import BEAN.AdminBEAN;
import BEAN.DonHangBEAN;
import BEAN.NguoiDungBEAN;
import BO.AdminBO;
import BO.DonHangBO;
import BO.NguoiDungBO;
import DAO.DonHangDAO;

/**
 * Servlet implementation class NguoiDungCONTROLLER
 */
@WebServlet("/nguoidung")
public class NguoiDungCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungCONTROLLER() {
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
		String action = request.getParameter("action");
		if(action != null) {
			System.out.println(action);
			if(action.equals("login")) {
				login(request, response);
			}else if(action.equals("logout")) {
				logout(request, response);
			}else if(action.equals("register")){
				register(request, response);
			}else if(action.equals("registerbylink")){
				registerbylink(request, response);
			}else if(action.equals("loginbylink")){
				loginbylink(request, response);
			}else if(action.equals("index")){
				index(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tenNguoiDung = request.getParameter("tennguoidung");
			String diaChi = request.getParameter("diachi");
			String soDienThoai = request.getParameter("sodienthoai");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			
			
			request.setAttribute("tennguoidung", tenNguoiDung);
			request.setAttribute("diachi", diaChi);
			request.setAttribute("sodienthoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("username", username);
			


			String url = request.getParameter("servletName");
			NguoiDungBO ndbo = new NguoiDungBO();
			
			if(tenNguoiDung != null && diaChi != null && soDienThoai  != null && email  != null && username != null && password != null && repassword != null ) {					
				Boolean err_Check = true;
				try {
					//BẮT LỖI
					
					//Kiểm tra số điện thoại
					Pattern soDienThoai_Pattern =  Pattern.compile("[0]\\d{9}");
					Matcher soDienThoai_Matcher = soDienThoai_Pattern.matcher(soDienThoai);
					if(!soDienThoai_Matcher.matches()) {
						err_Check = false;
						request.setAttribute("err_soDienThoai", "Số điện thoại bao gồm 10 chữ số và bắt đầu bằng số 0 !<br/>");
					}
					//Kiểm tra email
					Pattern email_Pattern =  Pattern.compile("\\w+@\\w+(\\.\\w+)+");
					Matcher email_Matcher = email_Pattern.matcher(email);
					if(!email_Matcher.matches()) {
						err_Check = false;
						request.setAttribute("err_email", "Cấu trúc email sai định dạng!<br/>");
					}
					if(username.replaceAll(" ", "").length() == username.length()) {
						if(ndbo.checkUsername(username) == true) {
							err_Check = false;
							request.setAttribute("baoloiusername", "Tên đăng nhập đã tồn tại, vui lòng sử dụng tên đăng nhập khác!<br/>");
						}
					}else {
						err_Check = false;
						request.setAttribute("baoloiusername", "Tên đăng nhập không được chứa khoảng trắng!<br/>");
					}
					
					if(password.equals(repassword)) {
						if(password.replaceAll(" ", "").length()<password.length()) {
							err_Check = false;
							request.setAttribute("baoloipassword", "Mật khẩu không được chứa khoảng trắng!<br/>");
						}else if(password.length()<8) {
							err_Check = false;
							request.setAttribute("baoloipassword", "Mật khẩu có độ dài lớn hơn 8 ký tự!<br/>");
						}
					} else {
						err_Check = false;
						request.setAttribute("baoloipassword", "Mật khẩu không khớp!<br/>");
					}
					
					//RESPONSE
					if(ndbo.checkUsername(username)==false && err_Check == true){
						NguoiDungBEAN nguoiDungBEAN = new NguoiDungBEAN("", tenNguoiDung, email, soDienThoai, diaChi, username, password, false);
						ndbo.insert(nguoiDungBEAN);
						request.setAttribute("msgsuccess", "Đăng ký tài khoản thành công!<br/>");
					}else {
						request.setAttribute("baoloiregister", "		");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(url);
				System.out.println(repassword);
			}
//			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//			rd.forward(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url = request.getParameter("servletName");
		System.out.println(url);
		
		
		try {
			NguoiDungBO ndbo = new NguoiDungBO();
			NguoiDungBEAN nguoidung = null;
			AdminBO adbo = new AdminBO();
			AdminBEAN admin = new AdminBEAN();
			if(username != null && password != null){
				if(adbo.selectByUserNameAndPassWordNguuoiDung(username, password)!=null) {
					admin = adbo.selectByUserNameAndPassWordNguuoiDung(username, password);
					session.setAttribute("admin", admin);
					url = "index";
				}else {					
					if(ndbo.selectByUserNameAndPassWordNguuoiDung(username, password) != null ){
						nguoidung = ndbo.selectByUserNameAndPassWordNguuoiDung(username, password);
						if(nguoidung!=null) {
							request.setAttribute("nguoidung", "nguoidung");
						}
						
						session.setAttribute("nguoidung", nguoidung);// setNguoiDUng
					}else {
						request.setAttribute("baoloilogin", "Sai tên đăng nhập hoặc mật khẩu!");
						request.setAttribute("username", username);
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    session.invalidate();
	    response.sendRedirect("index");
	    return; // <--- Here.
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect("index");
	    return; // <--- Here.
	}
	private void registerbylink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("servletName");
		request.setAttribute("baoloiregister","		");
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	private void loginbylink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("servletName");
		request.setAttribute("baoloilogin","		");
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
