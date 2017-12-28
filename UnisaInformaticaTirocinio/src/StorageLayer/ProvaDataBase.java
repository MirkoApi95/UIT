package StorageLayer;

import java.sql.SQLException;

public class ProvaDataBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DriverManagerConnectionPool con = new DriverManagerConnectionPool();
		
		con.getConnection();
	}

}
