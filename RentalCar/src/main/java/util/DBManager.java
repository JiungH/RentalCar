package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		final String url = "jdbc:mysql://localhost:3306/rental_car";
		final String user = "root";
		final String password = "@Aa153120";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("데이터베이스 연동성공");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("데이터베이스 연동실패");
		}
		return conn;
	}
}

