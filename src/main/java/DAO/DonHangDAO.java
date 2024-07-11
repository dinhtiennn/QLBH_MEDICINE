package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.DonHangBEAN;
import BEAN.NguoiDungBEAN;
import BEAN.ThuocBEAN;
public class DonHangDAO {
	public ArrayList<DonHangBEAN> selectAll() throws Exception {
		ArrayList<DonHangBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from DonHang";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			ds.add(new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public ArrayList<DonHangBEAN> selectAllDonHangAdminXacNhanByKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		ArrayList<DonHangBEAN> ds = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from DonHang where ID_NguoiDung = ? and XacNhanKhachHang = 'true' and XacNhanAdmin = 'true'";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, nguoidung.getIdNguoiDung());
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			ds.add(new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public ArrayList<DonHangBEAN> selectAllDHChoXacNhan() throws Exception {
		ArrayList<DonHangBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from DonHang where XacNhanKhachHang = 'true' and XacNhanAdmin = 'false'";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			ds.add(new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public ArrayList<DonHangBEAN> selectAllDHDaXacNhan() throws Exception {
		ArrayList<DonHangBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from DonHang where XacNhanKhachHang = 'true' and XacNhanAdmin = 'true'";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			ds.add(new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public ArrayList<DonHangBEAN> selectAllDonHangDaXacNhanByKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		ArrayList<DonHangBEAN> ds = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from DonHang where ID_NguoiDung = ? and XacNhanKhachHang = 'true' and XacNhanAdmin = 'false'";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, nguoidung.getIdNguoiDung());
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			ds.add(new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public DonHangBEAN selectDH(int iddonhang) throws Exception {
		DonHangBEAN donhang = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		//tạo câu lệnh sql
		String sql = "SELECT * FROM DonHang WHERE ID_DonHang = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, iddonhang);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			donhang = new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin);
		}
		rs.close();
		kn.cn.close();
		return donhang;
	}
	
	public DonHangBEAN selectDHChuaThanhToanOfKhachHang(NguoiDungBEAN nguoidung) throws Exception {
		DonHangBEAN donhang = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		//tạo câu lệnh sql
		String sql = "SELECT top 1 ID_DonHang, NgayDat,ID_NguoiDung,XacNhanKhachHang,XacNhanAdmin FROM DonHang WHERE ID_NguoiDung = ? and XacNhanKhachHang  = 'false' and XacNhanAdmin = 'false' ORDER BY ID_DonHang, NgayDat,ID_NguoiDung,XacNhanKhachHang,XacNhanAdmin DESC";
		//b3 tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, Integer.parseInt(nguoidung.getIdNguoiDung()));
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			int idDonHang = rs.getInt("ID_DonHang");
			Date ngayDat = rs.getDate("NgayDat");
			String idNguoiDung= rs.getString("ID_NguoiDung");
			Boolean xacNhanKhachHang = rs.getBoolean("XacNhanKhachHang");
			Boolean xacNhanAdmin = rs.getBoolean("XacNhanAdmin");
			donhang = new DonHangBEAN(idDonHang, ngayDat, idNguoiDung, xacNhanKhachHang, xacNhanAdmin);
		}
		rs.close();
		kn.cn.close();
		return donhang;
	}
	public int insert(NguoiDungBEAN nguoidung) throws Exception {
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "insert into DonHang (NgayDat,ID_NguoiDung, XacNhanKhachHang, XacNhanAdmin) values (GETDATE(),?,?,?)";
			//b3: Tao cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, nguoidung.getIdNguoiDung());
			cmd.setBoolean(2, false);
			cmd.setBoolean(3, false);
			//b4: thuc hien cau lenh
			kq = cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	public int delete(DonHangBEAN donhang) throws Exception{
		int kq = 0;
		try {				
			//B1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql= "delete from DonHang where ID_DonHang = ?";
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
	public int updateXacNhanKhachHang(int iddonhang) throws Exception {
		KetNoi kn= new KetNoi();
		kn.ketnoi();
        String sql= "update DonHang set XacNhanKhachHang = 'true' where ID_DonHang=?";
        PreparedStatement cmd= kn.cn.prepareStatement(sql);
        cmd.setInt(1, iddonhang);
        int kq= cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        return kq;
    }
	public int updateXacNhanAdmin(int iddonhang) throws Exception {
		KetNoi kn= new KetNoi();
		kn.ketnoi();
        String sql= "update DonHang set XacNhanAdmin = 'true' where ID_DonHang=?";
        PreparedStatement cmd= kn.cn.prepareStatement(sql);
        cmd.setInt(1, iddonhang);
        int kq= cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        return kq;
    }
}
