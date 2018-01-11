package control;

import entity.AssociazioneTuTa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfermaAzienda
 */

@WebServlet("/ConfermaAzienda")
public class ConfermaAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConfermaAzienda() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  @SuppressWarnings("unchecked")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String sid = request.getRequestedSessionId();
    ArrayList<AssociazioneTuTa> selectlist = new ArrayList<AssociazioneTuTa>();
    selectlist = (ArrayList<AssociazioneTuTa>) session.getAttribute("empty");
    if (request.getRequestedSessionId().equals(sid) == true) {
      AssociazioneTuTa oggetto = new AssociazioneTuTa();
      String azienda = request.getParameter("azienda");
      String nominativo = request.getParameter("sel");
      /*
       *Tirocinante userLogin =
       *   (Tirocinante)request.getSession().getAttribute("tirocinante");
       * int emailsession = userLogin.getId();
       */
      session.setAttribute("azienda", azienda);
      session.setAttribute("nominativo", nominativo);
      oggetto.setNomeazienda(azienda);
      oggetto.setNominativo(nominativo);
      selectlist.add(oggetto);
    }
    session.setAttribute("", selectlist);
    request.getRequestDispatcher("").forward(request, response);
  }
}