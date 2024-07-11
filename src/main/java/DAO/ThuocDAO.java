package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.NguoiDungBEAN;
import BEAN.ThuocBEAN;


public class ThuocDAO {
	public ArrayList<ThuocBEAN> selectAll() throws Exception {
		ArrayList<ThuocBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from Thuoc";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idThuoc = rs.getString("ID_Thuoc");
			String tenThuoc = rs.getString("TenThuoc");
			String anh = rs.getString("Anh");
			String moTa = rs.getString("MoTa");
			String thanhPhan = rs.getString("ThanhPhan");
			String huongDanSuDung = rs.getString("HuongDanSuDung");
			int gia = rs.getInt("Gia");
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			ds.add(new ThuocBEAN(idThuoc, tenThuoc, anh, moTa, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public ThuocBEAN getThuoc(String idthuoc) throws Exception {// số trang và số lượng sách
		ThuocBEAN thuoc = new ThuocBEAN();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = "select * from Thuoc where ID_Thuoc = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, idthuoc);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idThuoc = rs.getString("ID_Thuoc");
			String tenThuoc = rs.getString("TenThuoc");
			String anh = rs.getString("Anh");
			String moTa = rs.getString("MoTa");
			String thanhPhan = rs.getString("ThanhPhan");
			String huongDanSuDung = rs.getString("HuongDanSuDung");
			int gia = rs.getInt("Gia");
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			thuoc = new ThuocBEAN(idThuoc, tenThuoc, anh, moTa, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc);
		}
		rs.close();
		kn.cn.close();
		return thuoc;
	}
	public int getDataOfThuoc() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = " select count(*) from Thuoc ";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
	}
	public ArrayList<ThuocBEAN> getArrThuocOnPage(int page, int dataOfSach) throws Exception {// số trang và số lượng sách
		ArrayList<ThuocBEAN> ds = new ArrayList<ThuocBEAN>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = "select * from Thuoc order by ID_Thuoc offset ? rows fetch next ? rows only";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, page);
		cmd.setInt(2, dataOfSach);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idThuoc = rs.getString("ID_Thuoc");
			String tenThuoc = rs.getString("TenThuoc");
			String anh = rs.getString("Anh");
			String moTa = rs.getString("MoTa");
			String thanhPhan = rs.getString("ThanhPhan");
			String huongDanSuDung = rs.getString("HuongDanSuDung");
			int gia = rs.getInt("Gia");
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			ds.add(new ThuocBEAN(idThuoc, tenThuoc, anh, moTa, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<ThuocBEAN> getArrThuocByMaloai(String ml, int line, int dataSachOnPage) throws Exception {// số trang và số lượng sách
		ArrayList<ThuocBEAN> ds = new ArrayList<ThuocBEAN>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		
		String sql = "SELECT * FROM Thuoc WHERE ID_LoaiThuoc = ? ORDER BY ID_Thuoc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, ml);
		cmd.setInt(2, line);
		cmd.setInt(3, dataSachOnPage);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idThuoc = rs.getString("ID_Thuoc");
			String tenThuoc = rs.getString("TenThuoc");
			String anh = rs.getString("Anh");
			String moTa = rs.getString("MoTa");
			String thanhPhan = rs.getString("ThanhPhan");
			String huongDanSuDung = rs.getString("HuongDanSuDung");
			int gia = rs.getInt("Gia");
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			ds.add(new ThuocBEAN(idThuoc, tenThuoc, anh, moTa, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int getDataOfThuocByMaLoai(String maLoai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = " select count(*) from Thuoc WHERE ID_LoaiThuoc = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
	}
	public int getmaxid() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = "SELECT MAX(CAST(SUBSTRING(ID_Thuoc, 2, LEN(ID_Thuoc)) AS INT)) AS MaxCode FROM Thuoc";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
	}
	public ArrayList<ThuocBEAN> getArrThuocByKey(String key, int line, int dataSachOnPage) throws Exception {// số trang và số lượng sách
		ArrayList<ThuocBEAN> ds = new ArrayList<ThuocBEAN>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		//Latin1_General_CI_AI là một ngôn ngữ (collation) cho phép tìm kiếm không phân biệt hoa thường và không phân biệt dấu.
		String sql = "select * from V_Thuoc WHERE TenThuoc COLLATE Latin1_General_CI_AI LIKE ? or TenLoaiThuoc COLLATE Latin1_General_CI_AI LIKE ? ORDER BY ID_Thuoc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, "%"+key+"%");
		cmd.setString(2, "%"+key+"%");
		cmd.setInt(3, line);
		cmd.setInt(4, dataSachOnPage);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idThuoc = rs.getString("ID_Thuoc");
			String tenThuoc = rs.getString("TenThuoc");
			String anh = rs.getString("Anh");
			String moTa = rs.getString("MoTa");
			String thanhPhan = rs.getString("ThanhPhan");
			String huongDanSuDung = rs.getString("HuongDanSuDung");
			int gia = rs.getInt("Gia");
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			ds.add(new ThuocBEAN(idThuoc, tenThuoc, anh, moTa, thanhPhan, huongDanSuDung, gia, idNhaSanXuat, idLoaiThuoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int getDataOfThuocByKey(String key) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//tạo câu lệnh sql
		String sql = "select count(*) from V_Thuoc WHERE TenThuoc COLLATE Latin1_General_CI_AI LIKE ? or TenLoaiThuoc COLLATE Latin1_General_CI_AI LIKE ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, "%"+key+"%");
		cmd.setString(2, "%"+key+"%");
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
	}
	public int updateInF(ThuocBEAN thuoc)  throws Exception{
		int kq = 0;
					
		//B1: Ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="UPDATE Thuoc SET TenThuoc = ?, Anh = ?, MoTa = ?, ThanhPhan = ?,  HuongDanSuDung = ?, Gia = ?, ID_NhaSanXuat = ?, ID_LoaiThuoc = ? where  ID_Thuoc = ?";
		//b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, thuoc.getTenThuoc());
		cmd.setString(2, thuoc.getAnh());
		cmd.setString(3, thuoc.getMoTa());
		cmd.setString(4, thuoc.getThanhPhan());
		cmd.setString(5, thuoc.getHuongDanSuDung());
		cmd.setInt(6, thuoc.getGia());
		cmd.setString(7, thuoc.getIdNhaSanXuat());
		cmd.setString(8, thuoc.getIdLoaiThuoc());
		cmd.setString(9, thuoc.getIdThuoc());
		//b4: thuc hien cau lenh
		kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public int delete(String idthuoc)  throws Exception{
		int kq = 0;		
		//B1: Ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="delete from Thuoc where ID_Thuoc = ?";
		//b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, idthuoc);
		//b4: thuc hien cau lenh
		kq = cmd.executeUpdate();

		return kq;
	}
	public int insert(ThuocBEAN thuoc) throws Exception {
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "insert into Thuoc(ID_Thuoc, TenThuoc, Anh, MoTa, ThanhPhan, HuongDanSuDung,Gia, ID_NhaSanXuat, ID_LoaiThuoc) values (?,?,?,?,?,?,?,?,?)";
			//b3: Tao cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, thuoc.getIdThuoc());
			cmd.setString(2, thuoc.getTenThuoc());
			cmd.setString(3, thuoc.getAnh());
			cmd.setString(4, thuoc.getMoTa());
			cmd.setString(5, thuoc.getThanhPhan());
			cmd.setString(6, thuoc.getHuongDanSuDung());
			cmd.setInt(7, thuoc.getGia());
			cmd.setString(8, thuoc.getIdNhaSanXuat());
			cmd.setString(9, thuoc.getIdLoaiThuoc());
			//b4: thuc hien cau lenh
			kq = cmd.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
}
