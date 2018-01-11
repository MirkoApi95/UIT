package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;

/**
 * Servlet implementation class MostraTutorUni
 */
@WebServlet("/MostraTutorUni")
public class MostraTutorUni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraTutorUni() {
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
	    String nome=request.getParameter("azienda");
        TutorUniversitario tuni = (TutorUniversitario)request.getSession().getAttribute("tuni");
        ArrayList<TutorUniversitario> listatu=null;
	  try {
	      listatu=TutorUniversitarioDao.selectTutorNames(nome);
	      int contatore=TutorUniversitarioDao.countTutor(nome);
	      for(int j=0;j<contatore;j++) {
	        tuni.setCognome(listatu.get(j).getCognome());
	        tuni.setNome(listatu.get(j).getNome());
	      }
	      ArrayList<TutorUniversitario> tunidef=new ArrayList<TutorUniversitario>();
	      tunidef.add(tuni);
	      request.setAttribute("lista", tunidef);
	      request.getRequestDispatcher("/ListaAziendeView.jsp").forward(request, response);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

}
