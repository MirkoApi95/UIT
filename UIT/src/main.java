
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Tirocinante;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import entity.Utente;
import model.TirocinanteDao;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;




public class main {
  public static void main(String[] args) throws SQLException {

    TirocinanteDao dao=new TirocinanteDao();
    Tirocinante t = new Tirocinante();
    Utente u = new Utente();
    u.setId(6);
    t=dao.getTirocinante(u);

    System.out.println(t.getMatricola());
  }

}