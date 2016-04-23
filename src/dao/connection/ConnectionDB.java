package dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public ConnectionDB() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnect(String dbUsername, String dbPassword){
			
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user="+dbUsername+";password="+dbPassword+";database=bookstore");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=bookstore;user="+dbUsername+";password="+dbPassword+";";
			Connection conn = DriverManager.getConnection(connectionUrl);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
