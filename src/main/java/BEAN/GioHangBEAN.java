package BEAN;

public class GioHangBEAN {
	private String idTHuoc;
	private String tenThuoc;
	private Long soLuongMua;
	private Long gia;
	private Long thanhTien;
	public GioHangBEAN() {
		super();
	}
	public GioHangBEAN(String idTHuoc, String tenThuoc, Long soLuongMua, Long gia) {
		super();
		this.idTHuoc = idTHuoc;
		this.tenThuoc = tenThuoc;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhTien = gia*soLuongMua;
	}
	public String getIdTHuoc() {
		return idTHuoc;
	}
	public void setIdTHuoc(String idTHuoc) {
		this.idTHuoc = idTHuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public Long getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(Long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "GioHangBEAN [idTHuoc=" + idTHuoc + ", tenThuoc=" + tenThuoc + ", soLuongMua=" + soLuongMua + ", gia="
				+ gia + ", thanhTien=" + thanhTien + "]";
	}
	
}
