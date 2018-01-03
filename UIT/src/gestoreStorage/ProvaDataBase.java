package gestoreStorage;

import java.sql.SQLException;

public class ProvaDataBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DriverManagerConnectionPoolUIT con = new DriverManagerConnectionPoolUIT();
		con.getConnection();
	}

}
