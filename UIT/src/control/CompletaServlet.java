package control;

import java.io.IOException;
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

/** Servlet implementation class CompletaServlet. */
@WebServlet("/CompletaServlet")
public class CompletaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nominativo=request.getParameter("dropdown");
    HttpSession session=request.getSession();

    String nome;
    int id;
    int index;
    index=nominativo.lastIndexOf(' ');
    nome=nominativo.substring(0, index);
    nominativo=nominativo.substring(index+1);
    id=Integer.parseInt(nominativo);
    System.out.println(nome);
    System.out.println(id);
    Utente tutorUniversitario=new Utente();
    try {
      UtenteDao daoutu= new UtenteDao();
      tutorUniversitario=daoutu.doRetrieveByKey(id);
      boolean check=(boolean)session.getAttribute("check1");
      check=true;
      session.setAttribute("check1", check);

      session.setAttribute("tutorUniversitario", tutorUniversitario);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Completato.jsp");
    dispatcher.forward(request, response);
  }
}
