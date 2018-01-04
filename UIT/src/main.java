import java.sql.SQLException;

import entity.ProgettoFormativo;
import entity.Tirocinante;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.TirocinanteDao;
import model.TutorAziendaleDao;
import model.UtenteDao;

public class main {

	public static void main(String[] args) throws SQLException {
		

		TutorAziendaleDao dao2=new TutorAziendaleDao();
		
		System.out.println(dao2.inserisciTA("Oracle", "napoli", 2));
		
		
	}

	
	

}
