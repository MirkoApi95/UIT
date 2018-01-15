package control;

import entity.ProgettoFormativo;
import entity.Tirocinante;
import entity.TutorAziendale;
import entity.Utente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProgettoFormativoDao;
import model.TirocinanteDao;
import model.TutorAziendaleDao;
import model.UtenteDao;


/** Servlet implementation class VisualizzaProgettoFormativoTuDdServlet. */
@WebServlet("/VisualizzaProgettoFormativoTuDdServlet")
public class VisualizzaProgettoFormativoTuDdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    TutorAziendale ta = null;
    String id = request.getParameter("idProgetto");
    HttpSession session = request.getSession();
    Utente utentetirocinante = null;
    Utente utenteTutorUniversitario = null;
    Tirocinante tirocinante = null;
    ProgettoFormativo progetto = null;
    try {
      UtenteDao udao = new UtenteDao();
      ProgettoFormativoDao pjdao = new ProgettoFormativoDao();
      int idprogetto = Integer.parseInt(id);
      progetto = pjdao.doRetrieveByKey(idprogetto);
      utenteTutorUniversitario = udao.doRetrieveByKey(progetto
          .getTutorUniversitario_Utente_idUtente());
      TutorAziendaleDao daota = new TutorAziendaleDao();
      udao = new  UtenteDao();
      TirocinanteDao tdao = new TirocinanteDao();

      utentetirocinante = udao.doRetrieveByKey(progetto.getTirocinante_Utente_idUtente());
      tirocinante = tdao.getTirocinante(utentetirocinante);
      ta = daota.doRetrieveByKeyTA(progetto.getTutorAziendale_Utente_idUtente());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    request.setAttribute("datiUtenteTu", utenteTutorUniversitario);
    request.setAttribute("datiTirocinante", tirocinante);
    request.setAttribute("datiAzienda", ta);
    request.setAttribute("datiUtenteTirocinante", utentetirocinante);
    request.setAttribute("progetto", progetto);
    session.setAttribute("pratica", progetto);
    request.getRequestDispatcher("/ProgettoFormativoViewTuTa.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
