package dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.connection.ConnectionDB;

public class CartDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public CartDAO() {

	}

	public CartDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}
	
	public int getIdCartMax(){
		
		int idCart = -1;
		
		String sql = "SELECT TOP 1 [idcart] "
				+ "FROM [bookstore].[dbo].[cart] "
				+ "ORDER BY idcart DESC";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				idCart = rs.getInt(1);
				return idCart;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public void addIdCart(){
		String sql = "INSERT INTO cart(idcart) VALUES(?)";
		int idCart = getIdCartMax() + 1;
		try {
			PreparedStatement ps5 = con.prepareStatement(sql);
			ps5.setInt(1, idCart);
			ps5.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
