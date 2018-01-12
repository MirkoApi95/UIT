
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;




public class main {
  public static void main(String[] args) throws SQLException {

    ArrayList<TutorUniversitario> lista=new ArrayList<TutorUniversitario>();
    ArrayList<TutorUniversitario> lista1=new ArrayList<TutorUniversitario>();
    lista=TutorUniversitarioDao.selectTutorNames("a");
    for(int i=0;i<lista.size();i++) {
      System.out.println("juj"+lista.size());
      System.out.println("stampo"+lista.get(i).getNome());
    }
}
}