import java.sql.SQLException;

import entity.ProgettoFormativo;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.UtenteDao;

public class main {

	public static void main(String[] args) throws SQLException {
		
		ProgettoFormativo uno = new ProgettoFormativo(false, false, "laurearmi",1,2,3,4);
		
		ProgettoFormativoDao PFG = new ProgettoFormativoDao();
		
		ProgettoFormativo vuoto = new ProgettoFormativo();
		Utente user = new Utente();
		user.setCognome("cccc");
		user.setEmail("sdsdsd");
		user.setIndirizzo("sdasdad");
		user.setNome("sdadad");
		user.setPassword("dasdas");
		
		UtenteDao ud= new UtenteDao();
		ud.upLoadUtente(user);
		
		PFG.upLoadProject(uno);
		
		vuoto=PFG.doRetrieveByKey(6);
		PFG.UploadConvalidaDD(vuoto, true);
		
		System.out.println(vuoto.getObiettivi());
		vuoto=PFG.doRetrieveByKey(6);
		System.out.println(vuoto.getConvalidaDD());
		
		System.out.println(PFG.ChiudiConnessione());
		
	}

	
	

}
