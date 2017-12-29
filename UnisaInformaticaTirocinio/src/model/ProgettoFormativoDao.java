package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.ProgettoFormativo;
import gestoreStorage.DriverManagerConnectionPool;

public class ProgettoFormativoDao {

		//****VARIABILI DELLA CLASSE****\\
	
		private ProgettoFormativo progetto = new ProgettoFormativo();
		private ArrayList<ProgettoFormativo> listaProgetti = new ArrayList <ProgettoFormativo>();
		private Connection connection = null;
		private PreparedStatement preparedStatement = null;
		private final String selectFromIDSQL = "select * FROM ProgettoFormativo WHERE ProgettoFormativo.id= ?";
		
		//****METODI DI LETTURA****\\
		
		public ArrayList<ProgettoFormativo> listaTuttiProgetti() { //BIOGNA DARE LA POSSIBILITA DI ACCEDERE DIRETTAMENTE AGLI OGGETTI DI TIPO PROGETTO DALL'ESTERNO????
			//query per selezionare tutti i progetti
			//
			return listaProgetti;
		}
		
		@SuppressWarnings("finally")//xkè?
		public boolean VerificaStatoDD(int id) {
			try {
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(selectFromIDSQL);
				preparedStatement.setInt(1, id);
				ResultSet rs=preparedStatement.executeQuery();
				progetto=(ProgettoFormativo) rs;
				return progetto.getConvalidaDD();
				}
			finally {
				return false;
			}
		}
		
		@SuppressWarnings("finally")
		public boolean VerificaStatoTU(int id) {
			try {
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(selectFromIDSQL);
				preparedStatement.setInt(1, id);
				ResultSet rs=preparedStatement.executeQuery();
				progetto=(ProgettoFormativo) rs;
				return progetto.getConvalidaTU();
				}
			finally {
				return false;
			}
		}
		
		
}
