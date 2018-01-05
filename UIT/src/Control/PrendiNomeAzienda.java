package Control;

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
import model.Associazionetu_taDao;
import model.TutorAziendaleDao;

/**
 * Servlet implementation class PrendiNomeAzienda
 */
@WebServlet("/PrendiNomeAzienda")
public class PrendiNomeAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PrendiNomeAzienda() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("azienda");
		TutorAziendale ta=(TutorAziendale)request.getSession().getAttribute("tutoraziendale");
		TutorAziendale tutor=null;
		try {
			Associazionetu_taDao assTu= new Associazionetu_taDao();
			TutorAziendaleDao tad = new TutorAziendaleDao();
			ta.setNome(tutor.getNome());
			ta.setCognome(tutor.getCognome());
			ArrayList<TutorUniversitario> list=assTu.listaAssociazioniTU_TA(ta);
			request.setAttribute("lista", list);
			RequestDispatcher rs=request.getRequestDispatcher("/ListaAziendaView.jsp");
			rs.forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
