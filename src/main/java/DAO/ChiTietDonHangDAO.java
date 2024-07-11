package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.ChiTietDonHangBEAN;
import BEAN.DonHangBEAN;
import BEAN.ThuocBEAN;


public class ChiTietDonHangDAO {
	public ArrayList<ChiTietDonHangBEAN> selectAll() throws Exception {
		ArrayList<ChiTietDonHangBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from ChiTietDonHang";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idChiTietDonHang = rs.getInt("ID_ChiTietDonHang");
			int idDonHang = rs.getInt("ID_DonHang");
			String idThuoc= rs.getString("ID_Thuoc");
			int soLuong = rs.getInt("SoLuong");
			ds.add(new ChiTietDonHangBEAN(idChiTietDonHang, idDonHang, idThuoc, soLuong));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public int getSLByDHandThuoc(int iddonhang,String idthuoc) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		//tạo câu lệnh sql
		String sql = "SELECT SoLuong FROM V_SLThuoc WHERE ID_DonHang = ? and ID_Thuoc = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, iddonhang);
		cmd.setString(2, idthuoc);
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
	public ArrayList<ChiTietDonHangBEAN> selectAllByDh(DonHangBEAN donhang) throws Exception {
		ArrayList<ChiTietDonHangBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from ChiTietDonHang where ID_DonHang = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, donhang.getIdDonHang());
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idChiTietDonHang = rs.getInt("ID_ChiTietDonHang");
			int idDonHang = rs.getInt("ID_DonHang");
			String idThuoc= rs.getString("ID_Thuoc");
			int soLuong = rs.getInt("SoLuong");
			ds.add(new ChiTietDonHangBEAN(idChiTietDonHang, idDonHang, idThuoc, soLuong));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public int insertCTDH(DonHangBEAN donhang, ThuocBEAN thuoc, int sl) throws Exception {
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "insert into ChiTietDonHang (ID_DonHang, ID_Thuoc,SoLuong) values (?,?,?)";
			//b3: Tao cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, donhang.getIdDonHang());
			cmd.setString(2, thuoc.getIdThuoc());
			cmd.setInt(3,sl);
			//b4: thuc hien cau lenh
			kq = cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	public boolean timThuocByDH(DonHangBEAN donhang,String idThuoc) throws Exception {
		boolean kq = false;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		//tạo câu lệnh sql
		String sql = "select * from ChiTietDonHang where ID_DonHang = ? and ID_Thuoc = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, donhang.getIdDonHang());
		cmd.setString(2, idThuoc);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			kq = true;
		}
		rs.close();
		kn.cn.close();
		return kq;
	}
	public int updateSL(DonHangBEAN donhang,String idThuoc) throws Exception {
		int kq = 0;
		//B1: Ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql= "update ChiTietDonHang set SoLuong = SoLuong+1 where ID_DonHang = ? and ID_Thuoc = ?";
		//b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, donhang.getIdDonHang());
		cmd.setString(2, idThuoc);
		//b4: thuc hien cau lenh
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int SuaSoLuong(DonHangBEAN donhang,String idThuoc,int soluong) throws Exception {
		int kq = 0;
		//B1: Ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql= "update ChiTietDonHang set SoLuong = ? where ID_DonHang = ? and ID_Thuoc = ?";
		//b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, soluong);
		cmd.setInt(2, donhang.getIdDonHang());
		cmd.setString(3, idThuoc);
		//b4: thuc hien cau lenh
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int deleteByIDThuoc(DonHangBEAN donhang, String idThuoc) {
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "delete from ChiTietDonHang where ID_Thuoc = ? and ID_DonHang = ?";
			//b3: Tao cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, idThuoc);
			cmd.setInt(2, donhang.getIdDonHang());
			//b4: thuc hien cau lenh
			kq = cmd.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	public int deleteAllByHD(DonHangBEAN donhang) {
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "delete from ChiTietDonHang where ID_Donhang = ?";
			//b3: Tao cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, donhang.getIdDonHang());
			//b4: thuc hien cau lenh
			kq = cmd.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
}
