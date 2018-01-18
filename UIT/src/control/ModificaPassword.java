package control;

import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UtenteDao;

/** Servlet implementation class ModificaPassword. */
@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    String nuovaPassword = request.getParameter("passwordinput");
    String confermaPassword = request.getParameter("confirm_password");
    PrintWriter out = response.getWriter();
    try {
      UtenteDao udao = new UtenteDao();
      Utente u = (Utente)request.getSession().getAttribute("utente");
      boolean check = false;
      if (nuovaPassword.equals(confermaPassword)==false) {
        System.out.println("errore utente non inserito");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('La password di conferma e' diversa dalla password inserita');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
      } else if (nuovaPassword.length() < 8) {
        System.out.println("errore utente non inserito");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('La password e' minore di 8 caratteri');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
      } else {   
        check = udao.modificaPassword(u, nuovaPassword);
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
            "/HomePageViewGenerale.jsp");
        dispatcher.forward(request, response);
      }

      if (!check) {
        System.out.println("errore password non modificata");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('errore inserimento password');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
        udao.modificaPassword(u, nuovaPassword);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
