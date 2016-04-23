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

public class FullNameDAO {
	Connection con = null;

	public FullNameDAO() {

	}

	public FullNameDAO(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public void addFullName(FullName fn) {
		String sqlFullName = "INSERT INTO fullname(idfullname, fname, mname, lname) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps1 = con.prepareStatement(sqlFullName);
			ps1.setInt(1, fn.getId());
			ps1.setString(2, fn.getfName());
			ps1.setString(3, fn.getmName());
			ps1.setString(4, fn.getlName());
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FullName getFullnameById(int id) {
		FullName full_Name = new FullName();
		String sql = "SELECT * FROM fullname WHERE idfullname = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				full_Name.setId(rs.getInt(1));
				full_Name.setfName(rs.getString(2));
				full_Name.setmName(rs.getString(3));
				full_Name.setlName(rs.getString(4));
				return full_Name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void editFullName(FullName fullName){
		String sql = "UPDATE fullname SET fname = ?, mname = ?, lname = ? WHERE idfullname = " + fullName.getId();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1	, fullName.getfName());
			stm.setString(2	, fullName.getmName());
			stm.setString(3	, fullName.getlName());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
