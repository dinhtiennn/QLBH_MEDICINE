package BO;

import java.util.ArrayList;

import BEAN.LoaiThuocBEAN;
import DAO.LoaiThuocDAO;


public class LoaiThuocBO {

	LoaiThuocDAO ltdao  = new LoaiThuocDAO();
	public ArrayList<LoaiThuocBEAN> selectAll() throws Exception {
		return ltdao.selectAll();
	}
	public LoaiThuocBEAN selectltbyid(String idloaithuoc) throws Exception {
		return ltdao.selectltbyid(idloaithuoc);
	}
	
	public static void main(String[] args) {
		//tesst select all
		LoaiThuocBO ltbo = new LoaiThuocBO();
		try {
//			ArrayList<LoaiThuocBEAN> ds = ltbo.selectAll();
//			for (LoaiThuocBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
			System.err.println(ltbo.selectltbyid("LT001"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
