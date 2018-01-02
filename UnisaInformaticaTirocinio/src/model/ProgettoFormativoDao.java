package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.ProgettoFormativo;
import gestoreStorage.DriverManagerConnectionPoolUIT;

public class ProgettoFormativoDao {

	//****VARIABILI DELLA CLASSE****\\

	private ProgettoFormativo progetto = new ProgettoFormativo();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	//****QUERY****\\		
	private final String selectFromIDSQL = "select * FROM ProgettoFormativo WHERE ProgettoFormativo.ID_ProgettoFormativo= ?";
	private final String insertProgetto = "INSERT INTO ProgettoFormativo(TutorAziendale_Utente_idUtente,"+
			"TutorUniversitario_Utente_idUtente,Tirocinante_Utente_idUtente,"+
			"ID_ProgettoFormativo,"+"DirettoreDipartimento_idDirettoreDipartimento,"+"ConvalidaDD,"+
			"ConvalidaTU,"+"Obiettivi)"+
			"VALUES (?,?,?,?,?,?,?,?)";
	private final String editConvalidaDD = "UPDATE ProgettoFormativo SET ConvalidaDD = ?, WHERE id = ?";
	private final String editConvalidaTU = "UPDATE ProgettoFormativo SET ConvalidaTU = ?, WHERE id = ?";
	
	//****COSTRUTTORE****\\
	public ProgettoFormativoDao() throws SQLException{
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
	public ProgettoFormativo doRetrieveByKey(int id)  {
		try {
			preparedStatement=connection.prepareStatement(selectFromIDSQL);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				progetto.setTirocinante_Utente_idUtente(rs.getString("TutorAziendale_Utente_idUtente"));
				progetto.setTutorUniversitario_Utente_idUtente(rs.getString("TutorUniversitario_Utente_idUtente"));
				progetto.setTirocinante_Utente_idUtente(rs.getString("Tirocinante_Utente_idUtente"));
				progetto.setId_progetto(rs.getInt("ID_ProgettoFormativo"));
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
			preparedStatement.setInt(1, Object.getId_progetto());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				if(Object.getId_progetto()==rs.getInt("ID_ProgettoFormativo"))return false;
					}
			preparedStatement=connection.prepareStatement(insertProgetto);
			preparedStatement.setString(1, Object.getTutorAziendale_Utente_idUtente());
			preparedStatement.setString(2, Object.getTutorUniversitario_Utente_idUtente());
			preparedStatement.setString(3, Object.getTirocinante_Utente_idUtente());
			preparedStatement.setInt(4, Object.getId_progetto());
			preparedStatement.setString(5, Object.getDirettoreDipartimento_idDirettoreDipartimento());
			preparedStatement.setBoolean(6, Object.getConvalidaDD());
			preparedStatement.setBoolean(7, Object.getConvalidaTU());
			preparedStatement.setString(8, Object.getObiettivi());
			int n = preparedStatement.executeUpdate();
			connection.commit();
			if (n != 0)return true;
			else return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}					
	}
	
	//****MEDOTO DI UPLOAD CONVALIDA DD****\\
	public boolean UploadConvalidaDD(ProgettoFormativo Object,boolean conv){
		if (Object==null)return false;
		Object.setConvalidaDD(conv);
		try {
			preparedStatement=connection.prepareStatement(editConvalidaDD);
			preparedStatement.setBoolean(5, Object.getConvalidaDD());
			preparedStatement.setLong(0, Object.getId_progetto());
			int n = preparedStatement.executeUpdate();
			if(n!=0)return true;
			else return false;
		}catch( SQLException e) {
			e.printStackTrace();
		}return false;
	}
	//****MEDOTO DI UPLOAD CONVALIDA TU****\\
		public boolean UploadConvalidaTD(ProgettoFormativo Object,boolean conv){
			if (Object==null)return false;
			Object.setConvalidaDD(conv);
			try {
				preparedStatement=connection.prepareStatement(editConvalidaTU);
				preparedStatement.setBoolean(5, Object.getConvalidaDD());
				preparedStatement.setLong(0, Object.getId_progetto());
				int n = preparedStatement.executeUpdate();
				if(n!=0)return true;
				else return false;
			}catch( SQLException e) {
				e.printStackTrace();
			}return false;
		}


}





