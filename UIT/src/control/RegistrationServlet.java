package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Utente;
import model.TirocinanteDao;
import model.TutorUniversitarioDao;
import model.UtenteDao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utente user= new Utente();
		user.setNome(req.getParameter("Name"));
		user.setCognome(req.getParameter("surname"));
		user.setEmail(req.getParameter("emailId"));
		user.setPassword(req.getParameter("passwordinput"));
		user.setIndirizzo(req.getParameter("address"));

		try {
			UtenteDao userDao = new UtenteDao();
			userDao.upLoadUtente(user);

			System.out.println("Utente inserito!");

			user=userDao.doRetrieveByMail(user.getEmail());

			String dominio;
			int ini=user.getEmail().indexOf('@');
			dominio=user.getEmail().substring(ini);
			TirocinanteDao t= new TirocinanteDao();
			TutorUniversitarioDao tu=new TutorUniversitarioDao();

			switch(dominio)
			{
			case "@studenti.unisa.it":
				t.setIdSql(user.getEmail());
				break;
			case "@docenti.unisa.it":
				tu.inserisciTU(user.getId());
				break;
			default : break;
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePageViewGenerale.jsp");
			dispatcher.forward(req, resp);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

