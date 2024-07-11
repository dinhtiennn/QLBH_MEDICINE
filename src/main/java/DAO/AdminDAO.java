package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.AdminBEAN;


public class AdminDAO {
	public AdminBEAN selectByUserNameAndPassWordNguuoiDung(String username, String password) throws Exception{
		 AdminBEAN admin = null;
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			
			//tạo câu lệnh sql
			String sql = "select * from Admin where TenDangNhap = ? and MatKhau = ? ";
			//b3 tạo câu lệnh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, username);
			cmd.setString(2, password);
			//b4 thực hiện câu lệnh:
			ResultSet rs = cmd.executeQuery();
			//b5 duyệt rs để đưa vào mảng ds
			while (rs.next()) {
				String idAmin = rs.getString("ID_Admin");
				String tenAdmin = rs.getString("TenAdmin");
				String tenDangNhap = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				admin = new AdminBEAN(idAmin, tenAdmin, tenDangNhap, matKhau);
			}
			rs.close();
			kn.cn.close();
			return admin;
		}
}
