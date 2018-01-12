
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;




public class main {
  public static void main(String[] args) throws SQLException {

    String nome = null;
    int id;
    int index = 0;
    String nomeId ="opera ciao 13342";

    index=nomeId.lastIndexOf(' ');
    nome=nomeId.substring(0, index);
    nomeId=nomeId.substring(index+1);
    id=Integer.parseInt(nomeId);
    System.out.println(id);
    
  }

}