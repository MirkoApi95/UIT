package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gestoreStorage.DriverManagerConnectionPoolUIT;

public class TutorUniversitarioDao extends UtenteDao {


	//****VARIABILI DELLA CLASSE****\\
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;


	//****QUERY****\\		

	private final String insertDati="INSERT INTO tutoruniversitario (utente_id_Utente)"+"VALUES(?)";

	//****COSTRUTTORE****\\
	public TutorUniversitarioDao() throws SQLException {
		connection=DriverManagerConnectionPoolUIT.getConnection();
	}
	//****CHIUSURA DELLA CONNESSIONE\\
	public boolean ChiudiConnessione(){
		try {
			return DriverManagerConnectionPoolUIT.releaseConnection(connection);
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}


	//****METODO DI UPLOAD
	public boolean inserisciTU(int id) {

		try {
			preparedStatement=connection.prepareStatement(insertDati);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}	
	}
}