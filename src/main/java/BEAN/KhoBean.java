package BEAN;

import java.sql.Date;

public class KhoBean {
	private String idKho;
	private String idThuoc;
	private int soLuong;
	private Date ngayNhapKho;
	private Date ngayHetHan;
	public KhoBean() {
		super();
	}
	public KhoBean(String idKho, String idThuoc, int soLuong, Date ngayNhapKho, Date ngayHetHan) {
		super();
		this.idKho = idKho;
		this.idThuoc = idThuoc;
		this.soLuong = soLuong;
		this.ngayNhapKho = ngayNhapKho;
		this.ngayHetHan = ngayHetHan;
	}
	public String getIdKho() {
		return idKho;
	}
	public void setIdKho(String idKho) {
		this.idKho = idKho;
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
	public Date getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(Date ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	@Override
	public String toString() {
		return "KhoBean [idKho=" + idKho + ", idThuoc=" + idThuoc + ", soLuong=" + soLuong + ", ngayNhapKho="
				+ ngayNhapKho + ", ngayHetHan=" + ngayHetHan + "]";
	}

}
