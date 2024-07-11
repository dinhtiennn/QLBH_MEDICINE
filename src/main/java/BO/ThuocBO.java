package BO;

import java.util.ArrayList;

import BEAN.ThuocBEAN;
import DAO.ThuocDAO;


public class ThuocBO {

	ThuocDAO tdao  = new ThuocDAO();
	public ArrayList<ThuocBEAN> selectAll() throws Exception {
		return tdao.selectAll();
	}
	public int getDataOfThuoc() throws Exception {
		return tdao.getDataOfThuoc();//
	}
	public ArrayList<ThuocBEAN> getArrThuocOnPage(int page, int dataOfSach) throws Exception {
		return tdao.getArrThuocOnPage(page, dataOfSach);//
	}
	public ArrayList<ThuocBEAN> getArrThuocByMaloai(String ml, int line, int dataSachOnPage) throws Exception {
		return tdao.getArrThuocByMaloai(ml, line, dataSachOnPage);
	}
	public int getDataOfThuocByMaLoai(String maLoai) throws Exception {
		return tdao.getDataOfThuocByMaLoai(maLoai);//
	}
	public ArrayList<ThuocBEAN> getArrThuocByKey(String key, int line, int dataSachOnPage) throws Exception {
		return tdao.getArrThuocByKey(key, line, dataSachOnPage);//
	}
	public int getDataOfThuocByKey(String key) throws Exception {
		return tdao.getDataOfThuocByKey(key);//
	}
	public ThuocBEAN getThuoc(String idthuoc) throws Exception {
		return tdao.getThuoc(idthuoc);//
	}
	public int updateInF(ThuocBEAN thuoc)  throws Exception{
		return tdao.updateInF(thuoc);
	}
	public int delete(String idthuoc)  throws Exception{
		return tdao.delete(idthuoc);
	}
	public int getmaxid() throws Exception {
		return tdao.getmaxid();
	}
	public int insert(ThuocBEAN thuoc) throws Exception {
		return tdao.insert(thuoc);
	}
	public static void main(String[] args) {
		ThuocBO tbo = new ThuocBO();
		try {
			//tesst select all
//			ArrayList<ThuocBEAN> ds = tbo.selectAll();
//			for (ThuocBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
			//test getdataofthuoc
//			System.out.println(tbo.getDataOfThuoc());
			//test getdataofthuoc by maloai
//			System.out.println(tbo.getDataOfThuocByMaLoai("LT001"));
			//test getdataofthuoc by key
//			System.out.println(tbo.getDataOfThuocByMaLoai("LT003"));
			//test getarrofthuoc
//			ArrayList<ThuocBEAN> ds = tbo.getArrThuocOnPage(0, 3);
//			for (ThuocBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
			//test getarrofthuoc by key
//			ArrayList<ThuocBEAN> ds = tbo.getArrThuocByKey("p", 0, 5);
//			for (ThuocBEAN k : ds) {
//				System.out.println(k.toString());
//			}
			//test getThuoc
//			System.out.println(tbo.getThuoc("T021"));
//			System.out.println(tbo.updateInF(new ThuocBEAN("T021", "a", "a", "a", "A", "A", 3, "NSX001", "LT001")));
//			System.out.println(tbo.insert(new ThuocBEAN("T022", "b", "b", "b", "b", "b", 3, "NSX001", "LT001")));
//			System.out.println(tbo.getmaxid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
