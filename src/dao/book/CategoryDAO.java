package dao.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.connection.ConnectionDB;
import entity.book.Category;

public class CategoryDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public CategoryDAO() {

	}

	public CategoryDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public Category getCategoryByID(int id) {

		Category category = new Category();

		String sql = "SELECT * FROM [dbo].[category] WHERE idcategory = " + id;
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				category.setId(rs.getInt("idcategory"));
				category.setType(rs.getString("type"));
				category.setArea(rs.getString("area"));
				category.setDescription(rs.getString("description"));
				return category;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
