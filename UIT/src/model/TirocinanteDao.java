package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;


public class TirocinanteDao extends UtenteDao {
	//****QUERY****\\		
		private final String selectID="select utente.id_Utente from utente where utente.Email=?";
		private final String inserimentoID="INSERT INTO tirocinante(AnnoIscrizione,CFU,utente_id_utente,matricola)"+"VALUES(?,?,?,?)";
		private final String selectDatiUnisa="SELECT AnnoIscrizione,CFU,matricola FROM university WHERE Email=?";
		//****VARIABILI DELLA CLASSE****\\

	private Connection connectionUIT;
	private Connection connectionUNISA;
	private PreparedStatement preparedStatement;
	
	//****COSTRUTTORE E CREAZIONE CONNESSIONE****\\
	public TirocinanteDao() throws SQLException {
		connectionUIT=DriverManagerConnectionPoolUIT.getConnection();
		connectionUNISA=DriverManagerConnectionPoolUnisa.getConnection();
	}
	//****CHIUSURA DELLA CONNESSIONE\\
		public boolean ChiudiConnessione(){
			try {
				return DriverManagerConnectionPoolUIT.releaseConnection(connectionUIT)&&
						DriverManagerConnectionPoolUnisa.releaseConnection(connectionUNISA);
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		//****METODI DI DOWNLOAD****\\
		public boolean setIdSql(String Email) {
			try {
				preparedStatement=connectionUIT.prepareStatement(selectID);
				preparedStatement.setString(1, Email);
				ResultSet rs=preparedStatement.executeQuery();
				rs.next();
				int id=rs.getInt(1);
				
				
				preparedStatement=connectionUNISA.prepareStatement(selectDatiUnisa);
				preparedStatement.setString(1, Email);
				ResultSet rs1=preparedStatement.executeQuery();
				rs1.next();
				Date data;
				data = rs1.getDate(1);
				int cfu=rs1.getInt(2);
				int matricola=rs1.getInt(3);
				
				preparedStatement=connectionUIT.prepareStatement(inserimentoID);

				preparedStatement.setDate(1, data);
				preparedStatement.setInt(2, cfu);
				preparedStatement.setInt(3,id);
				preparedStatement.setInt(4,matricola);
				preparedStatement.executeUpdate();
				connectionUIT.commit();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
}
