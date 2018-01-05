package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.TutorAziendale;
import entity.TutorUniversitario;
import gestoreStorage.DriverManagerConnectionPoolUIT;

public class Associazionetu_taDao {

	//****VARIABILI DELLA CLASSE****\

		private Connection connection = null;
		private PreparedStatement preparedStatement = null;
	
		//****QUERY****\\		
		private final String listaIDAssociati = "SELECT tutoruniversitario_utente_id_Utente FROM"+
											  "associazionetu_ta WHERE tutorAziendale1_utente_id_Utente=?";
		
		private final String listaTUAssociati ="SELECT Nome FROM Utente"
		
		//****COSTRUTTORE****\\
		public Associazionetu_taDao() throws SQLException{
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
		
		
		//****LISTA ASSOCIAZIONI
		public ArrayList<TutorUniversitario> listaAssociazioniTU_TA(TutorAziendale TA){
			
			ArrayList<String>lista =new ArrayList<String>();
			try {
				preparedStatement=connection.prepareStatement(listaAssociazioniTU_TA);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					lista.add(rs.getString(1));
				}
				return lista;
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
}
