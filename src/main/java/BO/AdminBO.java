package BO;

import BEAN.AdminBEAN;
import DAO.AdminDAO;

public class AdminBO {
	AdminDAO addao = new AdminDAO();
	public AdminBEAN selectByUserNameAndPassWordNguuoiDung(String username, String password) throws Exception{
		return addao.selectByUserNameAndPassWordNguuoiDung(username, password);
	}
	public static void main(String[] args) {
		AdminBO adbo = new AdminBO();
		try {
			System.out.println(adbo.selectByUserNameAndPassWordNguuoiDung("tranvanb", "123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
