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
import entity.Utente;
import model.ProgettoFormativoDao;

/**
 * Servlet implementation class ConvalidaPraticaServlet
 */
@WebServlet("/ConvalidaPraticaServlet")
public class ConvalidaPraticaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvalidaPraticaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		ProgettoFormativo project=(ProgettoFormativo) session.getAttribute("pratica");
		Utente utente =(Utente) session.getAttribute("utente");
		try {
      ProgettoFormativoDao pdao= new ProgettoFormativoDao();
      int ini = utente.getEmail().indexOf('@');
      String dominio = utente.getEmail().substring(ini);
      if(dominio.equals("@docenti.unisa.it")) {
        pdao.UploadConvalidaTD(project, true);
      }else {
        pdao.UploadConvalidaDD(project, true);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePageViewGenerale.jsp");
    dispatcher.forward(request, response);
		
	}

}
