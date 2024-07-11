package BO;

import java.util.ArrayList;

import BEAN.NguoiDungBEAN;
import DAO.NguoiDungDAO;

public class NguoiDungBO {


	NguoiDungDAO nddao  = new NguoiDungDAO();
	public ArrayList<NguoiDungBEAN> selectAll() throws Exception {
		return nddao.selectAll();
	}
	public ArrayList<NguoiDungBEAN> selectAllNhanVien() throws Exception {
		return nddao.selectAllNhanVien();
	}
	public boolean checkUsername(String username) throws Exception{
		return nddao.checkUsername(username);
	}
	public int insert(NguoiDungBEAN nguoidung) throws Exception{
		return nddao.insert(nguoidung);
	}
	public NguoiDungBEAN selectByUserNameAndPassWordNguuoiDung(String username, String password) throws Exception{
		return nddao.selectByUserNameAndPassWordNguuoiDung(username, password);
	}
	public NguoiDungBEAN selectTenNguoiDungByID(String idnguoidung) throws Exception{
		return nddao.selectTenNguoiDungByID(idnguoidung);
	}
	public static void main(String[] args) {
		NguoiDungBO ndbo = new NguoiDungBO();
		try {
			//tesst select all
//			ArrayList<NguoiDungBEAN> ds = ndbo.selectAll();
//			for (NguoiDungBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
			//test checkusername
			
			//test insert
//			System.out.println(ndbo.insert(new NguoiDungBEAN("", "Nguyen Van A", "nguyenvanaaa@gmail.com", "0123234456", "Da Nang", "nguyenvanaaa", "123", false)));
			//test selectByU_P
//			System.out.println(ndbo.selectByUserNameAndPassWord("dinhtien", "123"));
//			ArrayList<NguoiDungBEAN> ds = ndbo.selectAllNhanVien();
//			for (NguoiDungBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
//			System.out.println(ndbo.selectTenNguoiDungByID("6"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
