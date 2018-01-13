
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.ProgettoFormativo;
import entity.Tirocinante;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.TirocinanteDao;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;




public class main {
  @SuppressWarnings("null")
  public static void main(String[] args) throws SQLException {

    ProgettoFormativo progetto;
    ProgettoFormativoDao dao = new ProgettoFormativoDao();
    progetto= dao.doRetrieveByKey(17);
    
    System.out.println(progetto.getObiettivi());
  }

}