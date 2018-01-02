import java.sql.SQLException;

import entity.ProgettoFormativo;
import model.ProgettoFormativoDao;

public class main {

	public static void main(String[] args) throws SQLException {
		
		ProgettoFormativo uno = new ProgettoFormativo("0003", "0001", "0000", "0004", false, false, "laurearmi");
		ProgettoFormativo due = new ProgettoFormativo("0003", "0001", "0000", "0004", false, false, "laurearmi");
		ProgettoFormativo tre = new ProgettoFormativo("0003", "0001", "0000", "0004", false, false, "non laurearmi");
		ProgettoFormativo quattro = new ProgettoFormativo("0003", "0001", "0000", "0004", false, false, "laurearmi");
		ProgettoFormativoDao PFG = new ProgettoFormativoDao();
		ProgettoFormativo vuoto = new ProgettoFormativo();
		
		PFG.upLoadProject(uno);
		PFG.upLoadProject(due);
		PFG.upLoadProject(tre);
		PFG.upLoadProject(quattro);
		
		vuoto=PFG.doRetrieveByKey(2);
		System.out.println(vuoto.getObiettivi());
		System.out.println(PFG.ChiudiConnessione());
	}

	
	

}
