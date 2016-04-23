package dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.connection.ConnectionDB;

public class Book_OrderDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public Book_OrderDAO() {

	}

	public Book_OrderDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}
	
	public void addBookOrder(int idBook, int idCart, int quantity){
		String sql = "INSERT INTO book_order(idbook, quantity, idcart) VALUES(?,?,?)";

		try {
			PreparedStatement ps5 = con.prepareStatement(sql);
			ps5.setInt(1, idBook);
			ps5.setInt(2, idCart);
			ps5.setInt(3, quantity);

			ps5.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
