package dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.bank.Kcoin_BankDAO;
import dao.connection.ConnectionDB;
import entity.bank.Kcoin_Bank;
import entity.person.Address;
import entity.person.Customer;
import entity.person.Customer_Member;

public class Customer_MemberDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public Customer_MemberDAO() {

	}

	public Customer_MemberDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public void register(Customer_Member cm) {
		String sqlCustomer_mumber = "INSERT INTO customer_member(idperson, username, password, idbank) VALUES(?,?,?,?)";
		// String sqlCustomer_mumber = "INSERT INTO
		// customer_member(idperson,username, password) VALUES(?,?,?)";
		CustomerDAO cdao = new CustomerDAO(dbUsername, dbPassword);
		Customer c = (Customer) cm;
		cdao.addCustomer(c);
		// Kcoin_Bank kb = cm.getKcoinBank();
		// Kcoin_BankDAO kbdao = new Kcoin_BankDAO(dbUsername, dbPassword);
		// kbdao.addKcoinBank(kb);

		try {
			PreparedStatement ps5 = con.prepareStatement(sqlCustomer_mumber);
			ps5.setInt(1, cm.getId());
			ps5.setString(2, cm.getUsername());
			ps5.setString(3, cm.getPassword());
			ps5.setInt(4, 1);

			ps5.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Customer_Member getCustomerMemberByUsername(String username){
		Customer_Member customer_Member = new Customer_Member();
		Customer customer = new Customer();
		CustomerDAO  customerDAO = new CustomerDAO("sa", "123456");
		
		
		
		
		String sql = "SELECT * FROM customer_member WHERE username = '" + username + "'";
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				customer_Member.setId(rs.getInt(1));
				customer_Member.setUsername(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		customer = customerDAO.getCustomerById(customer_Member.getId());
		customer_Member.setAddress(customer.getAddress());
		customer_Member.setFull_name(customer.getFull_name());
		customer_Member.setPhoneNum(customer.getPhoneNum());
		customer_Member.setEmail(customer.getEmail());
		return customer_Member;
	}

	public boolean exitUsername(String username) {
		String sql = "SELECT * FROM customer_member WHERE username = '" + username + "'";
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

	public boolean exitAccount(String username, String password) {
		String sql = "SELECT * FROM customer_member WHERE username = '" + username + "' AND " + " password = '"
				+ password + "'";
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

}
