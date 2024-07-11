package BO;

import java.util.ArrayList;

import BEAN.ChiTietDonHangBEAN;
import BEAN.DonHangBEAN;
import BEAN.ThuocBEAN;
import DAO.ChiTietDonHangDAO;


public class ChiTietDonHangBO {

	ChiTietDonHangDAO ctdhdao  = new ChiTietDonHangDAO();
	public ArrayList<ChiTietDonHangBEAN> selectAll() throws Exception {
		return ctdhdao.selectAll();
	}
	public ArrayList<ChiTietDonHangBEAN> selectAllByDh(DonHangBEAN donhang) throws Exception {
		return ctdhdao.selectAllByDh(donhang);
	}
	public int insertCTDH(DonHangBEAN donhang,ThuocBEAN thuoc,int sl) throws Exception {
		return ctdhdao.insertCTDH(donhang, thuoc, sl);
	}
	public boolean timThuocByDH(DonHangBEAN donhang,String idthuoc) throws Exception {
		return ctdhdao.timThuocByDH(donhang,idthuoc);
	}
	public int updateSL(DonHangBEAN donhang,String idthuoc) throws Exception {
		return ctdhdao.updateSL(donhang, idthuoc);
	}
	public int SuaSoLuong(DonHangBEAN donhang,String idThuoc,int soluong) throws Exception {
		return ctdhdao.SuaSoLuong(donhang, idThuoc, soluong);
	}
	public int deleteByIDThuoc(DonHangBEAN donhang, String idThuoc) throws Exception {
		return ctdhdao.deleteByIDThuoc(donhang, idThuoc);
	}
	public int deleteAllByHD(DonHangBEAN donhang) throws Exception {
		return ctdhdao.deleteAllByHD(donhang);
	}
	public int getSLByDHandThuoc(int iddonhang,String idthuoc) throws Exception {
		return ctdhdao.getSLByDHandThuoc(iddonhang, idthuoc);
	}
	public static void main(String[] args) {
		//tesst select all
		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
		try {
//			ArrayList<ChiTietDonHangBEAN> ds = ctdhbo.selectAll();
//			for (ChiTietDonHangBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
//			ctdhbo.insertCTDH(new DonHangBEAN(7, null, "", false, false), new ThuocBEAN("T002", "", "", "", "", "", 0, "", ""), 5);
//			ArrayList<ChiTietDonHangBEAN> ds = ctdhbo.selectAllByDh(new DonHangBEAN(7, null, "", false, false));
//			for (ChiTietDonHangBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
//			System.err.println(ctdhbo.timThuocByDH(new DonHangBEAN(7, null, "", false, false),"T001"));
//			ctdhbo.updateSL(new DonHangBEAN(7, null, "", false, false),"T001");
//			ctdhbo.SuaSoLuong(new DonHangBEAN(7, null, "", false, false),"T001",10);
//			System.err.println(ctdhbo.deleteByIDThuoc(new DonHangBEAN(7, null, "", false, false),"T003"));
//			System.err.println(ctdhbo.deleteAllByHD(new DonHangBEAN(7, null, "", false, false)));
			System.err.println(ctdhbo.getSLByDHandThuoc(34, "T001"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
