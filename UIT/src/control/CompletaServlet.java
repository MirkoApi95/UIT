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
import entity.TutorUniversitario;
import entity.Utente;
import model.TutorUniversitarioDao;
import model.UtenteDao;

/**
 * Servlet implementation class CompletaServlet
 */
@WebServlet("/CompletaServlet")
public class CompletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletaServlet() {
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
	    String nominativo=(String) request.getParameter("dropdown");
	    HttpSession session=request.getSession();
	    

	        String nome;
	        int id=0;
	        int index = 0;
	        index=nominativo.lastIndexOf(' ');
	        nome=nominativo.substring(0, index);
	        nominativo=nominativo.substring(index+1);
	        id=Integer.parseInt(nominativo);
	        System.out.println(nome);
	        System.out.println(id);
	        Utente tutorUniversitario=new Utente();
	        try {
            UtenteDao daoutu= new UtenteDao();
            tutorUniversitario=daoutu.doRetrieveByKey(id);
            session.setAttribute("tutorUni", tutorUniversitario);
          } catch (SQLException e) {
            e.printStackTrace();
          }
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Completato.jsp");
        dispatcher.forward(request, response);
	}

}
