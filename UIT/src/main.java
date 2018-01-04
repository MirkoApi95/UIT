import java.sql.SQLException;

import entity.ProgettoFormativo;
import entity.Tirocinante;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.TirocinanteDao;
import model.UtenteDao;

public class main {

	public static void main(String[] args) throws SQLException {
		

		TirocinanteDao dao2=new TirocinanteDao();
		
		System.out.println(dao2.setIdSql("s.apicella22@studenti.unisa.it"));
		
		
	}

	
	

}
