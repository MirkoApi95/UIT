package control;

import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TirocinanteDao;
import model.TutorUniversitarioDao;
import model.UtenteDao;

/**
 *Classe servlet di registrazione.
 *
 * @author Francesco Mancuso Milite
 *
 * @version 1.0
 */

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}


  /**
   *Classe servlet di registrazione.
   *Metodo doPost @req richiesta @resp risposta
   *
   * @author Francesco Mancuso Milite
   *
   * @version 1.0
   */
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Utente user = new Utente();
    user.setEmail(req.getParameter("emailId"));
    user.setPassword(req.getParameter("passwordinput"));


    try {

      PrintWriter out = resp.getWriter();
      UtenteDao userDao = new UtenteDao();
      boolean checkCfu=userDao.testCfu(user.getEmail());
      boolean check = false;
      if(checkCfu==true) {
        if((user.getPassword().equals(req.getParameter("confirm_password"))==false)){
          System.out.println("errore utente non inserito");
          out.println("<script type=\"text/javascript\">");
          out.println("alert('La password di conferma è diversa dalla password inserita');");
          out.println("location='RegistrazioneView.jsp';");
          out.println("</script>");
        } else check=userDao.upLoadUtente(user);
        if(check==false) {
          System.out.println("errore utente non inserito");
          out.println("<script type=\"text/javascript\">");
          out.println("alert('email già esistente o non presente nel database universitario');");
          out.println("location='RegistrazioneView.jsp';");
          out.println("</script>");
        } else {
          System.out.println("Utente inserito!");
          user = userDao.doRetrieveByMail(user.getEmail());
          String dominio;
          int ini = user.getEmail().indexOf('@');
          dominio = user.getEmail().substring(ini);
          TirocinanteDao t = new TirocinanteDao();
          TutorUniversitarioDao tu = new TutorUniversitarioDao();
          switch (dominio) {
            case "@studenti.unisa.it":
              t.setIdSql(user.getEmail());
              break;
            case "@docenti.unisa.it":
              tu.inserisciTU(user.getId());
              break;
            default : break;
            
          }RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
              "/HomePageViewGenerale.jsp");
          dispatcher.forward(req, resp);
        }
      } else {
        System.out.println("errore utente non inserito");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('non hai i cfu necessari');");
        out.println("location='RegistrazioneView.jsp';");
        out.println("</script>");
      }
    }catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

