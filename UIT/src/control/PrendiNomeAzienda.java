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
import model.AssociazioneTuTaDao;

/** Servlet implementation class PrendiNomeAzienda. */
@WebServlet("/PrendiNomeAzienda")
public class PrendiNomeAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    TutorAziendale tutor = new TutorAziendale();
    tutor.setNomeazienda(request.getParameter("azienda"));
    TutorAziendale ta = (TutorAziendale)request.getSession().getAttribute("tutoraziendale");

    try {
      AssociazioneTuTaDao assTu = new AssociazioneTuTaDao();
      ta.setId(1);
      ta.setNome(tutor.getNome());
      ta.setCognome(tutor.getCognome());
      ArrayList<TutorUniversitario> list = assTu.listaAssociazioniTU_TA(ta);
      request.setAttribute("array", list);
      RequestDispatcher rs = request.getRequestDispatcher("/ListaAziendaView.jsp");
      rs.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}