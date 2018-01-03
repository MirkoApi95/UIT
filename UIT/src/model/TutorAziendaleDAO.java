package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;

public class TutorAziendaleDao {
	
	
	//****VARIABILI DELLA CLASSE****\\


		private Connection connectionUIT = null;
		private Connection connectionUNISA = null;
		private PreparedStatement preparedStatement = null;
		
		//****COSTRUTTORE E CREAZIONE CONNESSIONE****\\
		public TutorAziendaleDao() throws SQLException {
			connectionUIT=DriverManagerConnectionPoolUIT.getConnection();
			connectionUNISA=DriverManagerConnectionPoolUnisa.getConnection();
		}
		//****CHIUSURA DELLA CONNESSIONE\\
			public boolean ChiudiConnessione(){
				try {
					return DriverManagerConnectionPoolUIT.releaseConnection(connectionUIT)&&
						   DriverManagerConnectionPoolUIT.releaseConnection(connectionUNISA);
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				return false;
			}
			//****METODI DI DOWNLOAD****\\
			

	
	
	

}
