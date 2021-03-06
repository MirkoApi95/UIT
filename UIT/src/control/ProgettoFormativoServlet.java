package control;

import entity.ProgettoFormativo;
import entity.TutorAziendale;
import entity.Utente;
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
import model.ProgettoFormativoDao;

/** Servlet implementation class ProgettoFormativoServlet. */
@WebServlet("/ProgettoFormativoServlet")
public class ProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    String obiettivi = request.getParameter("obiettivi");
    PrintWriter out = response.getWriter();
    if (obiettivi.length() >= 50) {
      HttpSession sessione = request.getSession();
      Utente utente = (Utente)sessione.getAttribute("utente");
      Utente tutorUniversitario = (Utente)sessione.getAttribute("tutorUniversitario");
      TutorAziendale tutorAziendale = (TutorAziendale)sessione.getAttribute("tutorAziendale");
      ProgettoFormativo project = new ProgettoFormativo();
      project.setConvalidaDd(false);
      project.setConvalidaTu(false);
      project.setObiettivi(obiettivi);
      project.setDirettoreDipartimento_idDirettoreDipartimento(4);
      project.setTirocinante_Utente_idUtente(utente.getId());
      project.setTutorUniversitario_Utente_idUtente(tutorUniversitario.getId());
      project.setTutorAziendale_Utente_idUtente(tutorAziendale.getId());
      try {
        ProgettoFormativoDao pdao = new ProgettoFormativoDao();
        pdao.upLoadProject(project);
        boolean check = (boolean)sessione.getAttribute("check2");
        check = true;
        sessione.setAttribute("check2", check);
        System.out.println("fatto.");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
            "/HomePageTirocinanteView.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
    if(obiettivi.length()>=50) {
    System.out.println(obiettivi);	
    HttpSession sessione= request.getSession();
    Utente utente=(Utente)sessione.getAttribute("utente");
    Utente tutorUniversitario=(Utente)sessione.getAttribute("tutorUniversitario");
    TutorAziendale tutorAziendale=(TutorAziendale)sessione.getAttribute("tutorAziendale");
    ProgettoFormativo project = new ProgettoFormativo();
    project.setConvalidaDd(false);
    project.setConvalidaTu(false);
    project.setObiettivi(obiettivi);
    project.setDirettoreDipartimento_idDirettoreDipartimento(13);
    project.setTirocinante_Utente_idUtente(utente.getId());
    project.setTutorUniversitario_Utente_idUtente(tutorUniversitario.getId());
    System.out.println("L'id �:"+tutorAziendale.getId());
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
    }else
      System.out.println("pratica non completata");
    }
    out.println("<script type=\"text/javascript\">");
    out.println("alert('hai inserito meno di 50 caratteri nella sezione obiettivi');");
    out.println("location='CompilaProgettoFormativoView.jsp';");
    out.println("</script>");
  }
}
