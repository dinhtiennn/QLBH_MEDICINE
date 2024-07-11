package BEAN;

public class ThuocBEAN {
	private String idThuoc;
	private String tenThuoc;
	private String anh;
	private String moTa;
	private String thanhPhan;
	private String huongDanSuDung;
	private int gia;
	private String idNhaSanXuat;
	private String idLoaiThuoc;
	public ThuocBEAN() {
		super();
	}
	public ThuocBEAN(String idThuoc, String tenThuoc, String anh, String moTa, String thanhPhan, String huongDanSuDung,
			int gia, String idNhaSanXuat, String idLoaiThuoc) {
		super();
		this.idThuoc = idThuoc;
		this.tenThuoc = tenThuoc;
		this.anh = anh;
		this.moTa = moTa;
		this.thanhPhan = thanhPhan;
		this.huongDanSuDung = huongDanSuDung;
		this.gia = gia;
		this.idNhaSanXuat = idNhaSanXuat;
		this.idLoaiThuoc = idLoaiThuoc;
	}
	public String getIdThuoc() {
		return idThuoc;
	}
	public void setIdThuoc(String idThuoc) {
		this.idThuoc = idThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getThanhPhan() {
		return thanhPhan;
	}
	public void setThanhPhan(String thanhPhan) {
		this.thanhPhan = thanhPhan;
	}
	public String getHuongDanSuDung() {
		return huongDanSuDung;
	}
	public void setHuongDanSuDung(String huongDanSuDung) {
		this.huongDanSuDung = huongDanSuDung;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getIdNhaSanXuat() {
		return idNhaSanXuat;
	}
	public void setIdNhaSanXuat(String idNhaSanXuat) {
		this.idNhaSanXuat = idNhaSanXuat;
	}
	public String getIdLoaiThuoc() {
		return idLoaiThuoc;
	}
	public void setIdLoaiThuoc(String idLoaiThuoc) {
		this.idLoaiThuoc = idLoaiThuoc;
	}
	@Override
	public String toString() {
		return "ThuocBEAN [idThuoc=" + idThuoc + ", tenThuoc=" + tenThuoc + ", anh=" + anh + ", moTa=" + moTa
				+ ", thanhPhan=" + thanhPhan + ", huongDanSuDung=" + huongDanSuDung + ", gia=" + gia + ", idNhaSanXuat="
				+ idNhaSanXuat + ", idLoaiThuoc=" + idLoaiThuoc + "]";
	}


}
