package control;


import entity.TutorAziendale;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TutorAziendaleDao;

@WebServlet("/SelezioneAzienda")
public class SelezioneAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SelezioneAzienda() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
    doPost(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      /*ArrayList <TutorAziendale> listata;
      TutorAziendaleDao tad=new TutorAziendaleDao();
      listata=tad.listaAziende();*/
      ArrayList<TutorAziendale> listata=TutorAziendaleDao.selectTutornames();
      request.setAttribute("lista", listata);
      request.getRequestDispatcher("/ListaAziendeView.jsp").forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}