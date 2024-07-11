package BEAN;

public class NguoiDungBEAN {
	private String idNguoiDung;
	private String hoTen;
	private String email;
	private String soDienThoai;
	private String diaChi;
	private String tenDangNhap;
	private String matKhau;
	private boolean quyen;
	public NguoiDungBEAN() {
		super();
	}
	public NguoiDungBEAN(String idNguoiDung, String hoTen, String email, String soDienThoai, String diaChi,
			String tenDangNhap, String matKhau, boolean quyen) {
		super();
		this.idNguoiDung = idNguoiDung;
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	public String getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(String idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	@Override
	public String toString() {
		return "NguoiDungBEAN [idNguoiDung=" + idNguoiDung + ", hoTen=" + hoTen + ", email=" + email + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", quyen=" + quyen + "]";
	}

}
