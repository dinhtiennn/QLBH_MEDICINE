package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url ="jdbc:sqlserver://RIN\\SQLEXPRESS:1433;databaseName=Database_Thuoc_ThiHK; user=sa; password=123";
		cn = DriverManager.getConnection(url);
//		System.out.println("Da ket noi co so du lieu ");
	}
	public void ketnoi(String sever, String db,String un, String pass) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url ="jdbc:sqlserver://"+sever+":1433;databaseName="+db+"; user="+un+"; password="+pass+"";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi co so du lieu ");
	}
}
