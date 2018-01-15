package control;

import entity.TutorAziendale;
import entity.TutorUniversitario;
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
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;

/** Servlet implementation class MostraTutorUni. */
@WebServlet("/VisualizzaTutorUniversitari")
public class VisualizzaTutorUniversitari extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    String nomeId = request.getParameter("dropdown");
    ArrayList<TutorUniversitario> listatu = null;
    try {
      HttpSession session = request.getSession();
      String nome;
      int id;
      int index;
      index = nomeId.indexOf(' ');
      nome = nomeId.substring(0, index);
      nomeId = nomeId.substring(index + 1);
      id = Integer.parseInt(nomeId);
      TutorAziendale ta = new TutorAziendale();
      TutorAziendaleDao daota = new TutorAziendaleDao();
      ta = daota.doRetrieveByKeyTA(id);
      listatu = TutorUniversitarioDao.selectTutorNames(nome);
      request.setAttribute("listatutoruni", listatu);
      session.setAttribute("tutorAziendale", ta);
      RequestDispatcher dispatcher = getServletContext()
          .getRequestDispatcher("/ListaTutorUniversitarioView.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
