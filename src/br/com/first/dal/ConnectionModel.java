package br.com.first.dal;
import java.sql.*;
public class ConnectionModel {
	private static Connection connect;
	public static Connection connector() {
		if (connect == null) {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/bancoJavaMW";
			String user = "root";
			String password = "12345";
			try {
				Class.forName(driver);
				connect = DriverManager.getConnection(url,user,password);
				return connect;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		} else {
			return connect;
		}
	}
}