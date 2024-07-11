package BO;

import java.util.ArrayList;

import BEAN.ChiTietDonHangBEAN;
import BEAN.DonHangBEAN;
import BEAN.GioHangBEAN;
import BEAN.NguoiDungBEAN;


public class giohangBO {
	public ArrayList<GioHangBEAN> ds = new ArrayList<GioHangBEAN>(); 
	ThuocBO tbo = new ThuocBO();

	//Viết hàm thêm: thêm vào giỏ dsctdh
	public void add(ArrayList<ChiTietDonHangBEAN> dsctdh) throws Exception{
		for (ChiTietDonHangBEAN chiTietDonHangBEAN : dsctdh) {
			GioHangBEAN ghb =new GioHangBEAN(chiTietDonHangBEAN.getIdThuoc(), tbo.getThuoc(chiTietDonHangBEAN.getIdThuoc()).getTenThuoc(), (long)chiTietDonHangBEAN.getSoLuong(), (long)tbo.getThuoc(chiTietDonHangBEAN.getIdThuoc()).getGia());
			ds.add(ghb);
		}
	}
	public long getThanhTien() throws Exception{
		long result = 0;
		for (GioHangBEAN ghb : ds) {
			result += ghb.getThanhTien();
		}
		return result;
	}
//	public static void main(String[] args) {
//		ArrayList<ChiTietDonHangBEAN> dsctdh = new ArrayList<ChiTietDonHangBEAN>();
//		DonHangBEAN donhang = new DonHangBEAN();
//		giohangBO ghbo = new giohangBO();
//		DonHangBO dhbo = new DonHangBO();
//		ChiTietDonHangBO ctdhbo = new ChiTietDonHangBO();
//		GioHangBEAN ghb = new GioHangBEAN();
//		try {
//			donhang = dhbo.selectDHChuaThanhToanOfKhachHang(new NguoiDungBEAN("7", "", "", "", "", "", "", false));
//			dsctdh = ctdhbo.selectAllByDh(donhang);
//			ghbo.add(dsctdh);
//			for (GioHangBEAN gh : ghbo.ds) {
//				System.out.println(gh.toString());
//			}
//			System.out.println(ghbo.getThanhTien());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
