package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.KhoBean;
import BEAN.ThuocBEAN;


public class KhoDAO {
	public ArrayList<KhoBean> selectAll() throws Exception {
		ArrayList<KhoBean> ds = new ArrayList<>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		//tạo câu lệnh sql
		String sql = "select * from Kho";
		//b3 tạo câu lệnh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		//b4 thực hiện câu lệnh:
		ResultSet rs = cmd.executeQuery();
		//b5 duyệt rs để đưa vào mảng ds
		while (rs.next()) {
			String idKho = rs.getString("ID_Kho");
			String idThuoc = rs.getString("ID_Thuoc");
			int soLuong = rs.getInt("SoLuong");
			Date ngayNhapKho = rs.getDate("NgayNhapKho");
			Date ngayHetHan = rs.getDate("NgayHetHan");
			ds.add(new KhoBean(idKho, idThuoc, soLuong, ngayNhapKho, ngayHetHan));
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	public int updateSL(String idthuoc, int soluong)  throws Exception{
		int kq = 0;
					
		//B1: Ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="UPDATE Kho SET SoLuong = SoLuong+? where  ID_Thuoc = ?";
		//b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, soluong);
		cmd.setString(2, idthuoc);
		//b4: thuc hien cau lenh
		kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
}
