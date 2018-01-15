package control;

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
import entity.Utente;
import model.UtenteDao;

/**
 * Servlet implementation class ModificaPassword
 */
@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ModificaPassword() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nuovaPassword =request.getParameter("passwordinput");
    String confermaPassword =request.getParameter("confirm_password");
    PrintWriter out = response.getWriter();
    try {
      UtenteDao udao= new UtenteDao();
      Utente u = (Utente)request.getSession().getAttribute("utente");
      boolean check = false;
      if(!nuovaPassword.equals(confermaPassword)){
        System.out.println("errore utente non inserito");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('La password di conferma è diversa dalla password inserita');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
      } else if(nuovaPassword.length()<8) {
        System.out.println("errore utente non inserito");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('La password è minore di 8 caratteri');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
      }else {   
        check=udao.modificaPassword(u, nuovaPassword);
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
            "/HomePageViewGenerale.jsp");
        dispatcher.forward(request, response);
        }
      
      if(check==false) {
        System.out.println("errore password non modificata");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('errore inserimento password');");
        out.println("location='AccountView.jsp';");
        out.println("</script>");
      udao.modificaPassword(u, nuovaPassword);
      }} catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }}
