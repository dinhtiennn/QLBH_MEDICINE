package BEAN;

public class LoaiThuocBEAN {
	private String idLoaiThuoc;
	private String tenLoaiThuoc;
	public LoaiThuocBEAN() {
		super();
	}
	public LoaiThuocBEAN(String idLoaiThuoc, String tenLoaiThuoc) {
		super();
		this.idLoaiThuoc = idLoaiThuoc;
		this.tenLoaiThuoc = tenLoaiThuoc;
	}
	public String getIdLoaiThuoc() {
		return idLoaiThuoc;
	}
	public void setIdLoaiThuoc(String idLoaiThuoc) {
		this.idLoaiThuoc = idLoaiThuoc;
	}
	public String getTenLoaiThuoc() {
		return tenLoaiThuoc;
	}
	public void setTenLoaiThuoc(String tenLoaiThuoc) {
		this.tenLoaiThuoc = tenLoaiThuoc;
	}
	@Override
	public String toString() {
		return "LoaiThuocBEAN [idLoaiThuoc=" + idLoaiThuoc + ", tenLoaiThuoc=" + tenLoaiThuoc + "]";
	}

}
