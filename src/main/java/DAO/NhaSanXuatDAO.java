package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.NhaSanXuatBEAN;

public class NhaSanXuatDAO {
	public ArrayList<NhaSanXuatBEAN> selectAll() throws Exception {
		ArrayList<NhaSanXuatBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from NhaSanXuat";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String tenNhaSanXuat = rs.getString("TenNhaSanXuat");
			String quocGia = rs.getString("QuocGia");
			ds.add(new NhaSanXuatBEAN(idNhaSanXuat, tenNhaSanXuat, quocGia));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public NhaSanXuatBEAN selectbyid(String idnsx) throws Exception {
		NhaSanXuatBEAN nsx = null;

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from NhaSanXuat where ID_NhaSanXuat = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, idnsx);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idNhaSanXuat = rs.getString("ID_NhaSanXuat");
			String tenNhaSanXuat = rs.getString("TenNhaSanXuat");
			String quocGia = rs.getString("QuocGia");
			 nsx = new NhaSanXuatBEAN(idNhaSanXuat, tenNhaSanXuat, quocGia);
		}
		rs.close();
		KetNoi.cn.close();
		return nsx;
	}
}
