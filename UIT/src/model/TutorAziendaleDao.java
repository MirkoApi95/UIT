package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entity.TutorAziendale;
import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;


public class TutorAziendaleDao extends UtenteDao
{
	//****VARIABILI DELLA CLASSE****\\
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;


	//****QUERY****\\		
	private final String selectfromIDSql="SELECT * FROM tutoraziendale WHERE Utente_id_Utente=?";
	private final String insertDati="INSERT INTO tutoraziendale (NomeAzienda,Sede,utente_id_Utente)"+"VALUES(?,?,?)";
	private final String listaAziende="SELECT NomeAzienda FROM  tutorazendale";
	
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
			OtherUser.setNomeazienda(rs.getString("NomeAzienda"));
			OtherUser.setSede(rs.getString("Sede"));
			OtherUser.setId(id);
			return OtherUser;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//****METODO DI UPLOAD
	public boolean inserisciTA(String Azienda,String Sede,int id) {

		try {
			preparedStatement=connection.prepareStatement(insertDati);
			preparedStatement.setString(1, Azienda);
			preparedStatement.setString(2, Sede);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
	//***METODO LISTA AZIENDA
	public ArrayList<TutorAziendale> listaAziende() {
		ArrayList<TutorAziendale> lista =new ArrayList<TutorAziendale>();
		try {
			preparedStatement=connection.prepareStatement(listaAziende);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				TutorAziendale ta=new TutorAziendale();
				ta.setNome(rs.getString("NomeAzienda"));
				ta.setId(rs.getInt("utente_id_Utente"));
				lista.add(ta);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
