package dao.person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.connection.ConnectionDB;

public class GetIdFormDB {
	Connection con = null;
	String dbUsername = "sa";
	String dbPassword = "123456";

	public GetIdFormDB() {

	}

	public GetIdFormDB(String dbUsername, String dbPassword) {
		ConnectionDB cdb = new ConnectionDB();
		con = cdb.getConnect(dbUsername, dbPassword);
	}

	public int getValueId() throws SQLException {

		String sqlGetValueId = "SELECT MAX(idperson) FROM [dbo].[person]";
		// String sqlGetValueId = "SELECT * FROM fullname";

		Statement st = con.createStatement();
		try {
			ResultSet rs = st.executeQuery(sqlGetValueId);

			while (rs.next()) {
				int i = rs.getInt(1);
				return i+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
