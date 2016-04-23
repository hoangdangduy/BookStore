package dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.connection.ConnectionDB;
import entity.person.Address;
import entity.person.FullName;
import entity.person.Person;

public class PersonDAO {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public PersonDAO() {

	}

	public PersonDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public void addPerson(Person p) {
		String sqlPerson = "INSERT INTO person(idperson, idfullname, idaddress, part) VALUES(?,?,?,?)";
		FullName fn = p.getFull_name();
		Address ad = p.getAddress();
		FullNameDAO fndao = new FullNameDAO(dbUsername, dbPassword);
		fndao.addFullName(fn);
		AddressDAO adddao = new AddressDAO(dbUsername, dbPassword);
		adddao.addAddress(ad);

		try {
			PreparedStatement ps3 = con.prepareStatement(sqlPerson);
			ps3.setInt(1, p.getId());
			ps3.setInt(2, fn.getId());
			ps3.setInt(3, ad.getId());
			ps3.setString(4, p.getPath());
			ps3.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Person getPersonById(int id) {
		Address address = new Address();
		FullName full_Name = new FullName();
		Person person = new Person();
		AddressDAO addressDAO = new AddressDAO("sa", "123456");
		FullNameDAO full_NameDAO = new FullNameDAO("sa", "123456");

		int idFullname;
		int idAddress;

		String sql = "SELECT * FROM person WHERE idperson = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				person.setId(rs.getInt(1));
				idFullname = (rs.getInt(2));
				idAddress = (rs.getInt(3));
				person.setPath(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		address = addressDAO.getAddressById(id);
		full_Name = full_NameDAO.getFullnameById(id);
		person.setAddress(address);
		person.setFull_name(full_Name);

		return person;
	}

}
