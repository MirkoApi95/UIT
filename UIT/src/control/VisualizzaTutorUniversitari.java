<<<<<<< HEAD
package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;

/**
 * Servlet implementation class MostraTutorUni
 */
@WebServlet("/VisualizzaTutorUniversitari")
public class VisualizzaTutorUniversitari extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaTutorUniversitari() {
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
	    String nomeazienda=(String) request.getParameter("dropdown");
        ArrayList<TutorUniversitario> listatu=null;
        HttpSession session=request.getSession();
        session.setAttribute("tutoraziendale", nomeazienda);
	  try {
	      listatu=TutorUniversitarioDao.selectTutorNames(nomeazienda);
	      request.setAttribute("listatutoruni", listatu);
	      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaTutorUniversitarioView.jsp");
	      dispatcher.forward(request, response);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

}
=======
package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/VisualizzaTutorUniversitari")
public class VisualizzaTutorUniversitari extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaTutorUniversitari() {
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
	    String nome=(String) request.getParameter("dropdown");
        ArrayList<TutorUniversitario> listatu=null;
	  try {
	      listatu=TutorUniversitarioDao.selectTutorNames(nome);
	      request.setAttribute("listatutoruni", listatu);
	      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaTutorUniversitarioView.jsp");
	      dispatcher.forward(request, response);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

}
>>>>>>> 81f9a2aee820f40be163432c7a606f806630195d
