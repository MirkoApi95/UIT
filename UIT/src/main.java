import java.sql.SQLException;




public class main {
  public static void main(String[] args) throws SQLException {
    String email = "s.apicella@studenti.unisa.it";
    String dominio;

    int ini = email.indexOf('@');

    dominio = email.substring(ini);

    System.out.println(dominio);
  }
}