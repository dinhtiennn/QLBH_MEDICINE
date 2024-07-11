package BO;

import java.util.ArrayList;

import BEAN.DonHangBEAN;
import BEAN.NguoiDungBEAN;
import DAO.DonHangDAO;

public class DonHangBO {

	DonHangDAO dhdao  = new DonHangDAO();
	public ArrayList<DonHangBEAN> selectAll() throws Exception {
		return dhdao.selectAll();
	}
	public ArrayList<DonHangBEAN> selectAllDHChoXacNhan() throws Exception {
		return dhdao.selectAllDHChoXacNhan();
	}
	public ArrayList<DonHangBEAN> selectAllDHDaXacNhan() throws Exception {
		return dhdao.selectAllDHDaXacNhan();
	}
	public DonHangBEAN selectDHChuaThanhToanOfKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		return dhdao.selectDHChuaThanhToanOfKhachHang(nguoidung);
	}
	public int insert(NguoiDungBEAN nguoidung) throws Exception {
		return dhdao.insert(nguoidung);
	}
	public DonHangBEAN selectDH(int iddonhang) throws Exception {
		return dhdao.selectDH(iddonhang);
	}
	public int delete(DonHangBEAN donhang) throws Exception{
		return dhdao.delete(donhang);
	}
	public ArrayList<DonHangBEAN> selectAllDonHangDaXacNhanByKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		return dhdao.selectAllDonHangDaXacNhanByKhachHang(nguoidung);
	}
	public ArrayList<DonHangBEAN> selectAllDonHangAdminXacNhanByKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		return dhdao.selectAllDonHangAdminXacNhanByKhachHang(nguoidung);
	}
	public int updateXacNhanKhachHang(int iddonhang) throws Exception {
		return dhdao.updateXacNhanKhachHang(iddonhang);
	}
	public int updateXacNhanAdmin(int iddonhang) throws Exception {
		return dhdao.updateXacNhanAdmin(iddonhang);
	}
	public static void main(String[] args) {
		//tesst select all
		DonHangBO dhbo = new DonHangBO();
		try {
//			ArrayList<DonHangBEAN> ds = dhbo.selectAll();
//			for (DonHangBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
//			System.out.println(dhbo.selectDHChuaThanhToanOfKhachHang(new NguoiDungBEAN("7", "", "", "", "", "", "", false)));
//			System.out.println(dhbo.insert(new NguoiDungBEAN("7", "", "", "", "", "", "", false)));
//			System.out.println(dhbo.selectDH(7));
//			ArrayList<DonHangBEAN> ds = dhbo.selectAllDonHangDaXacNhanByKhachHang(new NguoiDungBEAN("2", "", "", "", "", "", "", false));
//			for (DonHangBEAN k : ds) {
//				System.out.println(k.toString());
//
//			}
//			ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
//			System.out.println(ctdhbo.deleteAllByHD(new DonHangBEAN(10, null, "", false, false)));
//			System.out.println(dhbo.delete(new DonHangBEAN(10, null, "", false, false)));
//			System.err.println(dhbo.updateXacNhanKhachHang(16));
//			System.err.println(dhbo.selectAllDonHangAdminXacNhanByKhachHang(new NguoiDungBEAN("6", "", "", "", "", "", "", false)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
