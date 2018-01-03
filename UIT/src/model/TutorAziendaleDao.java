package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ProgettoFormativo;
import entity.TutorAziendale;
import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;

public class TutorAziendaleDao extends UtenteDao
{
	//****VARIABILI DELLA CLASSE****\\
	private TutorAziendale tutorAziendale = new TutorAziendale();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	//****QUERY****\\		
	private final String selectfromIDSql="SELECT * FROM tutoraziendale WHERE Utente_id_Utente=?";
	//****COSTRUTTORE****\\
	public TutorAziendaleDao() throws SQLException{
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

	//****METODI DI DOWNLOAD****\\
	public TutorAziendale doRetrieveByKey(int id) 
	{
		Utente user;
		user=super.doRetrieveByKey(id);
		TutorAziendale OtherUser=(TutorAziendale) user;
		try {
			preparedStatement=connection.prepareStatement(selectfromIDSql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			OtherUser.setNomeazienda(rs.getString("NomeAzeinda"));
			OtherUser.setSede(rs.getString("Sede"));
			return OtherUser;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
