package BEAN;

import java.sql.Date;

public class DonHangBEAN {
	private int idDonHang;
	private Date ngayDat;
	private String idNguoiDung;
	private boolean xacNhanKhachHang;
	private boolean xacNhanAdmin;
	public DonHangBEAN() {
		super();
	}
	public DonHangBEAN(int idDonHang, Date ngayDat, String idNguoiDung, boolean xacNhanKhachHang,
			boolean xacNhanAdmin) {
		super();
		this.idDonHang = idDonHang;
		this.ngayDat = ngayDat;
		this.idNguoiDung = idNguoiDung;
		this.xacNhanKhachHang = xacNhanKhachHang;
		this.xacNhanAdmin = xacNhanAdmin;
	}
	public int getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(String idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public boolean isXacNhanKhachHang() {
		return xacNhanKhachHang;
	}
	public void setXacNhanKhachHang(boolean xacNhanKhachHang) {
		this.xacNhanKhachHang = xacNhanKhachHang;
	}
	public boolean isXacNhanAdmin() {
		return xacNhanAdmin;
	}
	public void setXacNhanAdmin(boolean xacNhanAdmin) {
		this.xacNhanAdmin = xacNhanAdmin;
	}
	@Override
	public String toString() {
		return "DonHangBEAN [idDonHang=" + idDonHang + ", ngayDat=" + ngayDat + ", idNguoiDung=" + idNguoiDung
				+ ", xacNhanKhachHang=" + xacNhanKhachHang + ", xacNhanAdmin=" + xacNhanAdmin + "]";
	}

}
