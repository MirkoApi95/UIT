
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;




public class main {
  public static void main(String[] args) throws SQLException {

    ArrayList<TutorUniversitario> lista;
    int h=TutorUniversitarioDao.countTutor("a");
   
   
     System.out.println(h);
  
  
  }
}