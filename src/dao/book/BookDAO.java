package dao.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.connection.ConnectionDB;
import entity.book.Book;

public class BookDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public BookDAO() {

	}

	public BookDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public Book getBookByID(int id) {
		Book book = new Book();
		CategoryDAO categoryDAO = new CategoryDAO("sa", "123456");
		Book_SetDAO book_SetDAO = new Book_SetDAO("sa", "123456");

		String sql = "SELECT * FROM [dbo].[book] where idbook = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				book.setId(rs.getInt("idbook"));
				book.setImage(rs.getString("image"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				int idcategory = rs.getInt("idcategory");
				book.setCategory(categoryDAO.getCategoryByID(idcategory));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishYear(rs.getString("publishyear"));
				book.setDescription(rs.getString("description"));
				book.setOriginalPrice(rs.getFloat("originalprice"));
				book.setSalePrice(rs.getFloat("saleprice"));
				int idbookset = rs.getInt("idbookset");
				book.setBookset(book_SetDAO.getBooksetByID(idbookset));
				book.setQuantity(rs.getInt("quantity"));
				return book;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<Book> getBookByName(String name) {
		ArrayList<Book> listBook = new ArrayList<>();
		Book book = new Book();

		CategoryDAO categoryDAO = new CategoryDAO("sa", "123456");
		Book_SetDAO book_SetDAO = new Book_SetDAO("sa", "123456");

		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM [dbo].[book] WHERE title like '%" + name + "%'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				book.setId(rs.getInt("idbook"));
				book.setImage(rs.getString("image"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				int idcategory = rs.getInt("idcategory");
				book.setCategory(categoryDAO.getCategoryByID(idcategory));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishYear(rs.getString("publishyear"));
				book.setDescription(rs.getString("description"));
				book.setOriginalPrice(rs.getFloat("originalprice"));
				book.setSalePrice(rs.getFloat("saleprice"));
				int idbookset = rs.getInt("idbookset");
				book.setBookset(book_SetDAO.getBooksetByID(idbookset));
				book.setQuantity(rs.getInt("quantity"));

				listBook.add(book);
				book = new Book();
			}
			return listBook;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Book> getBookSale() {
		Book book = new Book();
		CategoryDAO categoryDAO = new CategoryDAO("sa", "123456");
		Book_SetDAO book_SetDAO = new Book_SetDAO("sa", "123456");
		ArrayList<Book> listBook = new ArrayList<>();

		String sql = "SELECT TOP 5 book.*, (book.originalprice - book.saleprice) as bookSale "
				+ "FROM [dbo].[book] as book " + "ORDER BY bookSale desc";
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				book.setId(rs.getInt("idbook"));
				book.setImage(rs.getString("image"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				int idcategory = rs.getInt("idcategory");
				book.setCategory(categoryDAO.getCategoryByID(idcategory));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishYear(rs.getString("publishyear"));
				book.setDescription(rs.getString("description"));
				book.setOriginalPrice(rs.getFloat("originalprice"));
				book.setSalePrice(rs.getFloat("saleprice"));
				int idbookset = rs.getInt("idbookset");
				book.setBookset(book_SetDAO.getBooksetByID(idbookset));
				book.setQuantity(rs.getInt("quantity"));
				listBook.add(book);
				book = new Book();
			}

			return listBook;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Book> getAllBook() {

		Book book = new Book();
		CategoryDAO categoryDAO = new CategoryDAO("sa", "123456");
		Book_SetDAO book_SetDAO = new Book_SetDAO("sa", "123456");
		ArrayList<Book> listBook = new ArrayList<>();

		String sql = "SELECT * FROM [dbo].[book]";
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				book.setId(rs.getInt("idbook"));
				book.setImage(rs.getString("image"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				int idcategory = rs.getInt("idcategory");
				book.setCategory(categoryDAO.getCategoryByID(idcategory));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishYear(rs.getString("publishyear"));
				book.setDescription(rs.getString("description"));
				book.setOriginalPrice(rs.getFloat("originalprice"));
				book.setSalePrice(rs.getFloat("saleprice"));
				int idbookset = rs.getInt("idbookset");
				book.setBookset(book_SetDAO.getBooksetByID(idbookset));
				book.setQuantity(rs.getInt("quantity"));
				listBook.add(book);
				book = new Book();
			}

			return listBook;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
