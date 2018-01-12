package control;

import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UtenteDao;
/**
 * Servlet implementation class Login
 * Gestisce il login dell'utente.
 * @author Francesco Mancuso Milite
 * 
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /*
   * @see HttpServlet#HttpServlet()
   */
  public Login() {
    super();
    // TODO Auto-generated constructor stub
  }

  /*
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("emailLogin");
    String password = request.getParameter("passwordLogin");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    
    Utente u;
    
    try {
      UtenteDao udao = new UtenteDao();
      u = udao.doRetrieveByMail(email);
      System.out.println(u);
      String dominio;
      if (u != null) {
        if (u.getPassword().equals(password) && u.getEmail().equals(email)) {
          
          session.setAttribute("utente", u);
          int ini = email.indexOf('@');
          dominio = email.substring(ini);
          switch (dominio) {
            case "@studenti.unisa.it": 
              request.getRequestDispatcher("/HomePageTirocinanteView.jsp").forward(
                  request, response);
              break;
            case "@docenti.unisa.it":
              request.getRequestDispatcher("/HomePageTutorUniversitarioView.jsp").forward(
                  request, response);
              break;
            case "@azienda.unisa.it":
              request.getRequestDispatcher("/HomePageTutorAziendaleView.jsp").forward(
                  request, response);
              break;
            case "@direttoredip.unisa.it":
              request.getRequestDispatcher("/HomePageDirettoreDipView.jsp").forward(
                  request, response);
              break;
            default : break;
          }

        }
        if (!u.getPassword().equals(password)) {
          out.print("Password errata");
          out.println("<script>");
          out.println("alert('Password errata !')");
          out.println("window.history.back()");
          out.println("</script>");
        }
      } else {
        out.print("Email errata o inesistente");
        out.println("<script>");
        out.println("alert('Email errata o inesistente !')");
        out.println("window.history.back()");
        out.println("</script>");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /*
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}



