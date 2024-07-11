package BO;

import java.util.ArrayList;

import BEAN.KhoBean;
import DAO.KhoDAO;


public class KhoBO {


	KhoDAO kdao  = new KhoDAO();
	public ArrayList<KhoBean> selectAll() throws Exception {
		return kdao.selectAll();
	}
	public int updateSL(String idthuoc, int soluong)  throws Exception{
		return kdao.updateSL(idthuoc, soluong);
	}
	public static void main(String[] args) {
		//tesst select all
		KhoBO kbo = new KhoBO();
		try {
//			ArrayList<KhoBean> ds = kbo.selectAll();
//			for (KhoBean k : ds) {
//				System.out.println(k.toString());
//
//			}
			System.err.println(kbo.updateSL("T001", -10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
