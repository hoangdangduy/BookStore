package dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.connection.ConnectionDB;
import entity.person.Address;
import entity.person.Customer;
import entity.person.FullName;
import entity.person.Person;

public class CustomerDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public CustomerDAO() {

	}

	public CustomerDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public void addCustomer(Customer c) {
		String sqlCustomer = "INSERT INTO customer(idperson, phonenum, email) VALUES(?,?,?)";
		PersonDAO pdao = new PersonDAO(dbUsername, dbPassword);
		Person p = (Person) c;
		pdao.addPerson(p);

		try {
			PreparedStatement ps4 = con.prepareStatement(sqlCustomer);
			ps4.setInt(1, c.getId());
			ps4.setString(2, c.getPhoneNum());
			ps4.setString(3, c.getEmail());
			ps4.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		Person person = new Person();
		PersonDAO personDAO = new PersonDAO("sa", "123456");

		person = personDAO.getPersonById(id);
//		customer = (Customer) person;
		customer.setAddress(person.getAddress());
		customer.setFull_name(person.getFull_name());

		String sql = "SELECT * FROM customer WHERE idperson = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setPhoneNum(rs.getString(2));
				customer.setEmail(rs.getString(3));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean exitMail(String mail) {
		String sql = "SELECT * FROM customer WHERE email = '" + mail + "'";
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void editCustomer(Customer customer){
		String sql = "UPDATE customer SET phonenum = ?, email = ? WHERE idperson = " + customer.getId();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1	, customer.getPhoneNum());
			stm.setString(2	, customer.getEmail());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
