package control;

import entity.TutorAziendale;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TutorAziendaleDao;

/** Servlet implementation class VisualizzaAzienda. */
@WebServlet("/VisualizzaAzienda")
public class VisualizzaAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    try {
      ArrayList<TutorAziendale> arrayaziende = new ArrayList<>();
      arrayaziende = TutorAziendaleDao.selectTutornames();
      request.setAttribute("arrayaziende", arrayaziende);
      RequestDispatcher dispatcher = getServletContext()
          .getRequestDispatcher("/ListaAziendeView.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
