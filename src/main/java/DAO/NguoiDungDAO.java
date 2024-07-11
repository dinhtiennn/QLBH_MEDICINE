package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.NguoiDungBEAN;



public class NguoiDungDAO {
	 public ArrayList<NguoiDungBEAN> selectAll() throws Exception {
			ArrayList<NguoiDungBEAN> ds = new ArrayList<>();

			KetNoi kn = new KetNoi();
			kn.ketnoi();

			//tạo câu lệnh sql
			String sql = "select * from NguoiDung";
			//b3 tạo câu lệnh
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			//b4 thực hiện câu lệnh:
			ResultSet rs = cmd.executeQuery();
			//b5 duyệt rs để đưa vào mảng ds
			while (rs.next()) {
				String idNguoiDung = rs.getString("ID_NguoiDung");
				String hoTen = rs.getString("HoTen");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String tenDangNhap = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				Boolean quyen = rs.getBoolean("Quyen");
				ds.add(new NguoiDungBEAN(idNguoiDung, hoTen, email, soDienThoai, diaChi, tenDangNhap, matKhau, quyen));
			}
			rs.close();
			KetNoi.cn.close();
			return ds;
		}
	 public ArrayList<NguoiDungBEAN> selectAllNhanVien() throws Exception {
			ArrayList<NguoiDungBEAN> ds = new ArrayList<>();

			KetNoi kn = new KetNoi();
			kn.ketnoi();

			//tạo câu lệnh sql
			String sql = "select * from NguoiDung where quyen = 'true'";
			//b3 tạo câu lệnh
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			//b4 thực hiện câu lệnh:
			ResultSet rs = cmd.executeQuery();
			//b5 duyệt rs để đưa vào mảng ds
			while (rs.next()) {
				String idNguoiDung = rs.getString("ID_NguoiDung");
				String hoTen = rs.getString("HoTen");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String tenDangNhap = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				Boolean quyen = rs.getBoolean("Quyen");
				ds.add(new NguoiDungBEAN(idNguoiDung, hoTen, email, soDienThoai, diaChi, tenDangNhap, matKhau, quyen));
			}
			rs.close();
			KetNoi.cn.close();
			return ds;
		}
	 public NguoiDungBEAN selectTenNguoiDungByID(String idnguoidung) throws Exception{
		 NguoiDungBEAN nguoidung = null;
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			
			//tạo câu lệnh sql
			String sql = "select * from NguoiDung where ID_NguoiDung = ? ";
			//b3 tạo câu lệnh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, idnguoidung);
			//b4 thực hiện câu lệnh:
			ResultSet rs = cmd.executeQuery();
			//b5 duyệt rs để đưa vào mảng ds
			while (rs.next()) {
				String idNguoiDung = rs.getString("ID_NguoiDung");
				String hoTen = rs.getString("HoTen");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String tenDangNhap = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				Boolean quyen = rs.getBoolean("Quyen");
				nguoidung = new NguoiDungBEAN(idNguoiDung, hoTen, email, soDienThoai, diaChi, tenDangNhap, matKhau, quyen);
			}
			rs.close();
			kn.cn.close();
			return nguoidung;
		}
	 public NguoiDungBEAN selectByUserNameAndPassWordNguuoiDung(String username, String password) throws Exception{
		 NguoiDungBEAN nguoidung = null;
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			
			//tạo câu lệnh sql
			String sql = "select * from NguoiDung where TenDangNhap = ? and MatKhau = ? ";
			//b3 tạo câu lệnh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, username);
			cmd.setString(2, password);
			//b4 thực hiện câu lệnh:
			ResultSet rs = cmd.executeQuery();
			//b5 duyệt rs để đưa vào mảng ds
			while (rs.next()) {
				String idNguoiDung = rs.getString("ID_NguoiDung");
				String hoTen = rs.getString("HoTen");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String tenDangNhap = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				Boolean quyen = rs.getBoolean("Quyen");
				nguoidung = new NguoiDungBEAN(idNguoiDung, hoTen, email, soDienThoai, diaChi, tenDangNhap, matKhau, quyen);
			}
			rs.close();
			kn.cn.close();
			return nguoidung;
		}
	 public boolean checkUsername(String username) throws Exception {
			boolean kq = false;
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			
			//tạo câu lệnh sql
			String sql = "select * from NguoiDung where TenDangNhap = ?";
			//b3 tạo câu lệnh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, username);
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
	 public int insert(NguoiDungBEAN nguoiDung) throws Exception {
			int kq = 0;
			try {				
				//B1: Ket noi vao csdl
				KetNoi kn= new KetNoi();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql= "insert into NguoiDung (HoTen, Email, SoDienThoai, DiaChi, TenDangNhap, MatKhau,Quyen) values (?,?,?,?,?,?,?)";
				//b3: Tao cau lenh PreparedStatement
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, nguoiDung.getHoTen());
				cmd.setString(2, nguoiDung.getEmail());
				cmd.setString(3, nguoiDung.getSoDienThoai());
				cmd.setString(4, nguoiDung.getDiaChi());
				cmd.setString(5, nguoiDung.getTenDangNhap());
				cmd.setString(6,nguoiDung.getMatKhau());
				cmd.setBoolean(7, nguoiDung.isQuyen());
				//b4: thuc hien cau lenh
				kq = cmd.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return kq;
		}
}
