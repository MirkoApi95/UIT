package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;


public class TirocinanteDao extends UtenteDao {
	//****QUERY****\\		
		private final String selectFromIDSQL = "select * FROM Tirocinante WHERE Tirocinante.ID_ProgettoFormativo= ?";
	
	//****VARIABILI DELLA CLASSE****\\

	private Connection connectionUIT = null;
	private Connection connectionUNISA = null;
	private PreparedStatement preparedStatement = null;
	
	//****COSTRUTTORE E CREAZIONE CONNESSIONE****\\
	public TirocinanteDao() throws SQLException {
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
		public int prendiId(String Email) {
			final String selectID="select utente.id_Utente from utente where utente.Email=?";
		}
}
