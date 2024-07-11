package BEAN;

public class ChiTietDonHangBEAN {
	private int idChiTietDonHang;
	private int idDonHang;
	private String idThuoc;
	private int soLuong;
	public ChiTietDonHangBEAN() {
		super();
	}
	public ChiTietDonHangBEAN(int idChiTietDonHang, int idDonHang, String idThuoc, int soLuong) {
		super();
		this.idChiTietDonHang = idChiTietDonHang;
		this.idDonHang = idDonHang;
		this.idThuoc = idThuoc;
		this.soLuong = soLuong;
	}
	public int getIdChiTietDonHang() {
		return idChiTietDonHang;
	}
	public void setIdChiTietDonHang(int idChiTietDonHang) {
		this.idChiTietDonHang = idChiTietDonHang;
	}
	public int getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}
	public String getIdThuoc() {
		return idThuoc;
	}
	public void setIdThuoc(String idThuoc) {
		this.idThuoc = idThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietDonHangBEAN [idChiTietDonHang=" + idChiTietDonHang + ", idDonHang=" + idDonHang + ", idThuoc="
				+ idThuoc + ", soLuong=" + soLuong + "]";
	}

}
