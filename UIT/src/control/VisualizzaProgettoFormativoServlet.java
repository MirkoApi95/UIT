package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.ProgettoFormativo;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;
import model.UtenteDao;


@WebServlet("/VisualizzaProgettoFormativoServlet")
public class VisualizzaProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public VisualizzaProgettoFormativoServlet() {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    ProgettoFormativoDao daopf;
    try {
      daopf = new ProgettoFormativoDao();
      Utente u=(Utente) session.getAttribute("utente");
      UtenteDao daou= new UtenteDao();
      ProgettoFormativo project=(ProgettoFormativo) daopf.doRetrieveByKeyUtente(u.getId());
      TutorAziendale ta;
      Utente tu;
      TutorAziendaleDao daota=new TutorAziendaleDao();
      ta=daota.doRetrieveByKey(project.getTutorAziendale_Utente_idUtente());
      
      tu=(Utente)daou.doRetrieveByKey(project.getTutorUniversitario_Utente_idUtente());
      
      System.out.println("ta=" + ta.getNomeazienda());
      
      request.setAttribute("progetto", project);
      request.setAttribute("tutorUniversitario", tu);
      request.setAttribute("tutorAziendale", ta);
      
      
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    
    
    request.getRequestDispatcher("/ProgettoFormativoView.jsp").forward(request, response);
  }
    
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
}
}
