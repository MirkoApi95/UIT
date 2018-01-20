package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.ProgettoFormativo;
import entity.Tirocinante;
import entity.Utente;
import model.ProgettoFormativoDao;
import model.TirocinanteDao;
import model.UtenteDao;

/**
 * Servlet implementation class BackHome
 */
@WebServlet("/BackHome")
public class BackHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

     
      HttpSession session = request.getSession();
      Utente u=(Utente) session.getAttribute("utente");
      String email=u.getEmail();  
        String dominio;
        if (u != null) {
            int ini = email.indexOf('@');
            dominio = email.substring(ini);
            switch (dominio) {
              case "@studenti.unisa.it": 
                request.getRequestDispatcher("/HomePageTirocinanteView.jsp").forward(
                    request, response);
                break;
              case "@docenti.unisa.it":
                request.getRequestDispatcher("/HomePageTutorUniversitarioView.jsp").forward(
                    request, response);
                break;
              case "@azienda.unisa.it":
                request.getRequestDispatcher("/HomePageTutorAziendaleView.jsp").forward(
                    request, response);
                break;
              case "@direttoredipartimento.unisa.it":
                request.getRequestDispatcher("/HomePageDirettoreDipView.jsp").forward(
                    request, response);
                break;
              default : break;
            }
        } 
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
