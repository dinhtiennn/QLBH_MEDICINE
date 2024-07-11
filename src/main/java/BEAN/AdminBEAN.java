package BEAN;

public class AdminBEAN {
	private String idAmin;
	private String tenAdmin;
	private String tenDangNhap;
	private String matKhau;
	public AdminBEAN() {
		super();
	}
	public AdminBEAN(String idAmin, String tenAdmin, String tenDangNhap, String matKhau) {
		super();
		this.idAmin = idAmin;
		this.tenAdmin = tenAdmin;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public String getIdAmin() {
		return idAmin;
	}
	public void setIdAmin(String idAmin) {
		this.idAmin = idAmin;
	}
	public String getTenAdmin() {
		return tenAdmin;
	}
	public void setTenAdmin(String tenAdmin) {
		this.tenAdmin = tenAdmin;
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
	@Override
	public String toString() {
		return "AdminBEAN [idAmin=" + idAmin + ", tenAdmin=" + tenAdmin + ", tenDangNhap=" + tenDangNhap + ", matKhau="
				+ matKhau + "]";
	}
	
}
