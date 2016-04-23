package dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.connection.ConnectionDB;
import entity.person.Address;
import entity.person.FullName;

public class AddressDAO {
	Connection con = null;

	public AddressDAO() {

	}

	public AddressDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public void addAddress(Address ad) {
		String sqlAddress = "INSERT INTO address(idaddress, num, ward, distric, city) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps1 = con.prepareStatement(sqlAddress);
			ps1.setInt(1, ad.getId());
			ps1.setString(2, ad.getNum());
			ps1.setString(3, ad.getWard());
			ps1.setString(4, ad.getDistric());
			ps1.setString(5, ad.getCity());
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Address getAddressById(int id) {
		Address address = new Address();
		String sql = "SELECT * FROM address WHERE idaddress = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				address.setId(rs.getInt(1));
				address.setNum(rs.getString(2));
				address.setWard(rs.getString(3));
				address.setDistric(rs.getString(4));
				address.setCity(rs.getString(5));
				return address;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void editAddress(Address address){
		String sql = "UPDATE address SET num = ?, ward = ?, distric = ?, city = ? WHERE idaddress = " + address.getId();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1	, address.getNum());
			stm.setString(2	, address.getWard());
			stm.setString(3	, address.getDistric());
			stm.setString(4	, address.getCity());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
