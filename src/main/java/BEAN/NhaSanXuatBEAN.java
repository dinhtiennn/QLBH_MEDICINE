package BEAN;

public class NhaSanXuatBEAN {
	private String idNhaSanXuat;
	private String tenNhaSanXuat;
	private String quocGia;
	public NhaSanXuatBEAN() {
		super();
	}
	public NhaSanXuatBEAN(String idNhaSanXuat, String tenNhaSanXuat, String quocGia) {
		super();
		this.idNhaSanXuat = idNhaSanXuat;
		this.tenNhaSanXuat = tenNhaSanXuat;
		this.quocGia = quocGia;
	}
	public String getIdNhaSanXuat() {
		return idNhaSanXuat;
	}
	public void setIdNhaSanXuat(String idNhaSanXuat) {
		this.idNhaSanXuat = idNhaSanXuat;
	}
	public String getTenNhaSanXuat() {
		return tenNhaSanXuat;
	}
	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	@Override
	public String toString() {
		return "NhaSanXuatBEAN [idNhaSanXuat=" + idNhaSanXuat + ", tenNhaSanXuat=" + tenNhaSanXuat + ", quocGia=" + quocGia + "]";
	}

}
