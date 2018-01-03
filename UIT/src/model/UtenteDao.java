package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;

public class UtenteDao 
{
	//****VARIABILI DELLA CLASSE****\
	private Utente utente = new Utente();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	//****QUERY****\\		
	private final String selectFromIDSQL = "select * FROM Utente WHERE Utente.id_Utente= ?";
	private final String insertUtente = "INSERT INTO Utente("+
			"Nome,"+
			"Cognome,"+
			"Indirizzo,"+
			"Email,"+
			"Password,"+
			"VALUES(?,?,?,?,?)";
	private final String editaddress="UPDATE Utente SET Indirizzo=? WHERE Utente.id_Utente=?";
	private final String editpassword="UPDATE Utente SET Password=? WHERE Utente.id_Utente=?";
	private final String checkUtente="SELECT * FROM University WHERE Email=?";

	//****COSTRUTTORE****\\
	public UtenteDao() throws SQLException{
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
	public Utente doRetrieveByKey(int id)  {
		try {
			preparedStatement=connection.prepareStatement(selectFromIDSQL);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				utente.setNome(rs.getString("Nome"));
				utente.setCognome(rs.getString("Cognome"));
				utente.setIndirizzo(rs.getString("Indririzzo"));
				utente.setEmail(rs.getString("Email"));
				utente.setPassword(rs.getString("Password"));
				utente.setId(rs.getInt("id_Utente"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return utente;	
	}
	//****METODi DI UPLOAD****\\
	public boolean upLoadUtente(Utente Object) throws SQLException 
	{
		Connection conUnisa=null;
		try {
			conUnisa=DriverManagerConnectionPoolUnisa.getConnection();
			preparedStatement=conUnisa.prepareStatement(checkUtente);
			ResultSet rs=preparedStatement.executeQuery();
			DriverManagerConnectionPoolUnisa.releaseConnection(conUnisa);
			if(rs==null) 
			{
				return false;
			}
			preparedStatement=connection.prepareStatement(insertUtente);
			preparedStatement.setString(1, Object.getNome());
			preparedStatement.setString(2, Object.getCognome());
			preparedStatement.setString(3, Object.getIndirizzo());
			preparedStatement.setString(4, Object.getEmail());
			preparedStatement.setString(5, Object.getPassword());
			int n = preparedStatement.executeUpdate();
			connection.commit();
			if (n != 0)return true;
			else return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}					
	}
	
	public boolean ModificaIndirizzo(Utente Object,String indirizzo)
	{
		if (Object==null)return false;
		try {
			preparedStatement=connection.prepareStatement(editaddress);
			preparedStatement.setString(1, indirizzo);
			preparedStatement.setInt(2, Object.getId());
			int n = preparedStatement.executeUpdate();
			connection.commit();
			if(n!=0)return true;
			else return false;
		}catch( SQLException e) {
			e.printStackTrace();
		}return false;
	}
	
	public boolean ModificaPassword(Utente Object,String password)
	{
		if (Object==null)return false;
		try {
			preparedStatement=connection.prepareStatement(editpassword);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, Object.getId());
			int n = preparedStatement.executeUpdate();
			connection.commit();
			if(n!=0)return true;
			else return false;
		}catch( SQLException e) {
			e.printStackTrace();
		}return false;
	}
}
