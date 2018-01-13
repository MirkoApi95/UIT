package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.ProgettoFormativo;
import entity.Utente;
import model.ProgettoFormativoDao;

/**
 * Servlet implementation class ListaProgettiFormativiServlet
 */
@WebServlet("/ListaProgettiFormativiServlet")
public class ListaProgettiFormativiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ListaProgettiFormativiServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Utente u=(Utente) session.getAttribute("utente");
    try {
      ProgettoFormativoDao pjdao = new ProgettoFormativoDao();
      ArrayList<ProgettoFormativo> lista= new ArrayList<ProgettoFormativo>();
      int ini = u.getEmail().indexOf('@');
      String dominio = u.getEmail().substring(ini);
      if(dominio.equals("@direttoredipartimento.unisa.it")) {
        lista=pjdao.listaProgetti();
      }else {
        lista=pjdao.listaProgettitu(u.getId());
      }
      request.setAttribute("lista", lista);
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaProgettiView.jsp");
      dispatcher.forward(request, response);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

}
