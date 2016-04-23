package dao.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.connection.ConnectionDB;
import entity.book.Book_Set;
import entity.book.Category;

public class Book_SetDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public Book_SetDAO() {

	}

	public Book_SetDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public Book_Set getBooksetByID(int id) {

		Book_Set book_Set = new Book_Set();

		String sql = "SELECT * FROM [dbo].[bookset] WHERE idbookset = " + id;
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				book_Set.setId(rs.getInt("idbookset"));
				book_Set.setDescription(rs.getString("description"));
				return book_Set;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
