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
import entity.ProgettoFormativo;
import entity.TutorAziendale;
import entity.Utente;
import model.ProgettoFormativoDao;

/**
 * Servlet implementation class ProgettoFormativoServlet
 */
@WebServlet("/ProgettoFormativoServlet")
public class ProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ProgettoFormativoServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //TODO Auto-generated method stub
    doPost(request,response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String obiettivi=request.getParameter("obiettivi");
    System.out.println(obiettivi);	
    HttpSession sessione= request.getSession();
    Utente utente=(Utente)sessione.getAttribute("utente");
    Utente tutorUniversitario=(Utente)sessione.getAttribute("tutorUniversitario");
    TutorAziendale tutorAziendale=(TutorAziendale)sessione.getAttribute("tutorAziendale");
    ProgettoFormativo project = new ProgettoFormativo();
    project.setConvalidaDd(false);
    project.setConvalidaTu(false);
    project.setObiettivi(obiettivi);
    project.setDirettoreDipartimento_idDirettoreDipartimento(4);
    project.setTirocinante_Utente_idUtente(utente.getId());
    project.setTutorUniversitario_Utente_idUtente(tutorUniversitario.getId());
    System.out.println("L'id è:"+tutorAziendale.getId());
    project.setTutorAziendale_Utente_idUtente(tutorAziendale.getId());
    try {
      ProgettoFormativoDao pdao = new ProgettoFormativoDao();
      pdao.upLoadProject(project);
      boolean check=(boolean)sessione.getAttribute("check2");
      check=true;
      sessione.setAttribute("check2", check);
      System.out.println("fatto.");
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
          "/HomePageTirocinanteView.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
