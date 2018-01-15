package control;

import entity.ProgettoFormativo;
import entity.Utente;
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
import model.ProgettoFormativoDao;

/** Servlet implementation class ListaProgettiFormativiServlet. */
@WebServlet("/ListaProgettiFormativiServlet")
public class ListaProgettiFormativiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Utente u = (Utente)session.getAttribute("utente");
    try {
      ProgettoFormativoDao pjdao = new ProgettoFormativoDao();
      ArrayList<ProgettoFormativo> lista = new ArrayList<>();
      int ini = u.getEmail().indexOf('@');
      String dominio = u.getEmail().substring(ini);
      if ("@direttoredipartimento.unisa.it".equals(dominio)) {
        lista = pjdao.listaProgetti();
      } else {
        lista = pjdao.listaProgettitu(u.getId());
      }
      request.setAttribute("lista", lista);
      RequestDispatcher dispatcher = 
          getServletContext().getRequestDispatcher("/ListaProgettiView.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
}
