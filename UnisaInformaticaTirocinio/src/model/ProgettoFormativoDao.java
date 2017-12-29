package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.ProgettoFormativo;
import gestoreStorage.DriverManagerConnectionPool;

public class ProgettoFormativoDao {

		//****VARIABILI DELLA CLASSE****\\
	
		private ProgettoFormativo progetto = new ProgettoFormativo();
		private Connection connection = null;
		private PreparedStatement preparedStatement = null;
		
		
		//****QUERY****\\		
		private final String selectFromIDSQL = "select * FROM ProgettoFormativo WHERE ProgettoFormativo.id= ?";
		
		//****COSTRUTTORE****\\
		public ProgettoFormativoDao(){
		}
				
		//****METODI DI LETTURA****\\
		
		public ProgettoFormativo doRetrieveByKey(long id)  {
			try {
				connection=DriverManagerConnectionPool.getConnection();
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
			} finally {
				try {
					DriverManagerConnectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return progetto;	
		}
		
}
