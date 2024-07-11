package BO;

import java.util.ArrayList;

import BEAN.NhaSanXuatBEAN;
import DAO.NhaSanXuatDAO;



public class NhaSanXuatBO {

	NhaSanXuatDAO nsxdao  = new NhaSanXuatDAO();
	public ArrayList<NhaSanXuatBEAN> selectAll() throws Exception {
		return nsxdao.selectAll();
	}
	public NhaSanXuatBEAN selectbyid(String idnsx) throws Exception {
		return nsxdao.selectbyid(idnsx);
	}
	public static void main(String[] args) {
		//tesst select all
		NhaSanXuatBO ltbo = new NhaSanXuatBO();
		try {
//			ArrayList<NhaSanXuatBEAN> ds = ltbo.selectAll();
//			for (NhaSanXuatBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
			System.err.println(ltbo.selectbyid("NSX002"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
