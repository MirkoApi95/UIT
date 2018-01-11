
import java.sql.SQLException;
import java.util.List;
import entity.TutorAziendale;
import model.TutorAziendaleDao;




public class main {
  public static void main(String[] args) throws SQLException {

    List<TutorAziendale> lista;
    TutorAziendaleDao dao=new TutorAziendaleDao();
    lista=dao.selectTutornames();
   
   for(int i=0;i<lista.size();i++) {
     System.out.println(lista.get(i).getNomeazienda());
   }
  
  }
}