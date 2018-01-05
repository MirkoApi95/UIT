package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Associazionetu_ta;

/**
 * Servlet implementation class ConfermaAzienda
 */
@WebServlet("/ConfermaAzienda")
public class ConfermaAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ConfermaAzienda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String sid=request.getRequestedSessionId();
		ArrayList<Associazionetu_ta> selectlist=new ArrayList<Associazionetu_ta>();
		if(request.getRequestedSessionId().equals(sid)==true) {
			Associazionetu_ta oggetto=new Associazionetu_ta();
			String azienda=request.getParameter("azienda");
			String nominativo=request.getParameter("sel");
			session.setAttribute("azienda", azienda);
			session.setAttribute("nominativo", nominativo);
			oggetto.setNomeazienda(azienda);
			oggetto.setNominativo(nominativo);
			selectlist.add(oggetto);
		}
	}
}