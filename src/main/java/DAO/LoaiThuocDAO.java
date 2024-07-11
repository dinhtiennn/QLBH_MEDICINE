package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.LoaiThuocBEAN;

public class LoaiThuocDAO {
	public ArrayList<LoaiThuocBEAN> selectAll() throws Exception {
		ArrayList<LoaiThuocBEAN> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from LoaiThuoc";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			String tenLoaiThuoc = rs.getString("TenLoaiThuoc");
			ds.add(new LoaiThuocBEAN(idLoaiThuoc, tenLoaiThuoc));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public LoaiThuocBEAN selectltbyid(String idloaithuoc) throws Exception {
		LoaiThuocBEAN lt = null;

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from LoaiThuoc where ID_LoaiThuoc = ?";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, idloaithuoc);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idLoaiThuoc = rs.getString("ID_LoaiThuoc");
			String tenLoaiThuoc = rs.getString("TenLoaiThuoc");
			lt = new LoaiThuocBEAN(idLoaiThuoc, tenLoaiThuoc);
		}
		rs.close();
		KetNoi.cn.close();
		return lt;
	}
}
