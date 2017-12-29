package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.ProgettoFormativo;
import gestoreStorage.DriverManagerConnectionPool;

public class ProgettoFormativoDao {

		//****VARIABILI DELLA CLASSE****\\
	
		private ProgettoFormativo progetto = new ProgettoFormativo();
		private Connection connection = null;
		private PreparedStatement preparedStatement = null;
		
		//****QUERY****\\		
		private final String selectFromIDSQL = "select * FROM ProgettoFormativo WHERE ProgettoFormativo.id= ?";
		private final String insertProgetto = "INSERT INTO ProgettoFormativo(id_progetto,tutorAziendale_Utente_idUtente,"+
																			"tutorUniversitario_Utente_idUtente,tirocinante_Utente_idUtente,"+
																			"direttoreDipartimento_idDirettoreDipartimento,ConvalidaDD,"+
																			"ConvalidaTU,obiettivi)"+
																			"VALUES (?,?,?,?,?,?,?,?)";
		
		//****COSTRUTTORE****\\
		public ProgettoFormativoDao() throws SQLException{
			connection=DriverManagerConnectionPool.getConnection();
		}
		//****CHIUSURA DELLA CONNESSIONE\\
		public boolean ChiudiConnessione(){
			try {
				return DriverManagerConnectionPool.releaseConnection(connection);
				}catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
				
		//****METODI DI DOWNLOAD****\\
		public ProgettoFormativo doRetrieveByKey(long id)  {
			try {
				preparedStatement=connection.prepareStatement(selectFromIDSQL);
				preparedStatement.setLong(1, id);
				ResultSet rs=preparedStatement.executeQuery();
				while (rs.next()) {
					progetto.setId_progetto(rs.getLong("id"));
					progetto.setTirocinante_Utente_idUtente(rs.getString("tutorAziendale_Utente_idUtente"));
					progetto.setTutorUniversitario_Utente_idUtente(rs.getString("setTutorUniversitario_Utente_idUtente"));
					progetto.setTirocinante_Utente_idUtente(rs.getString("tirocinante_Utente_idUtente"));
					progetto.setDirettoreDipartimento_idDirettoreDipartimento(rs.getString("DirettoreDipartimento_idDirettoreDipartimento"));
					progetto.setConvalidaDD(rs.getBoolean("ConvalidaDD"));
					progetto.setConvalidaTU(rs.getBoolean("ConvalidaTU"));
					progetto.setObiettivi(rs.getString("Obiettivi"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return progetto;	
		}
		
		//****METODi DI UPLOAD****\\
		public boolean upLoadProject(ProgettoFormativo Object) throws SQLException {
			try {
				preparedStatement=connection.prepareStatement(selectFromIDSQL);
				preparedStatement.setLong(0, Object.getId_progetto());
				ResultSet rs=preparedStatement.executeQuery();
				if(rs.getLong(0)!=0)return false;				
				preparedStatement=connection.prepareStatement(insertProgetto);
				preparedStatement.setLong(0, Object.getId_progetto());
				preparedStatement.setString(1, Object.getTutorAziendale_Utente_idUtente());
				preparedStatement.setString(2, Object.getTutorUniversitario_Utente_idUtente());
				preparedStatement.setString(3, Object.getTirocinante_Utente_idUtente());
				preparedStatement.setString(4, Object.getDirettoreDipartimento_idDirettoreDipartimento());
				preparedStatement.setBoolean(5, Object.getConvalidaDD());
				preparedStatement.setBoolean(6, Object.getConvalidaTU());
				preparedStatement.setString(7, Object.getObiettivi());
				int n = preparedStatement.executeUpdate();
				if (n != 0)return true;
		        else return false;
			}catch (SQLException e) {
				e.printStackTrace();
			}return false;						
		}
		//BISOGNA CREARE UN METODO DI EDIT MA IL METODO CANCELLA IL RECORD ATTUALE E FA LA INSERT DI QUELLO MODIFICATO O 
		//DEVE INDIVIDUARE IL CAMBIAMENTO E MODIFICARE SOLO QUEL CAMPO ???
		
}
