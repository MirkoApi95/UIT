package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;
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
			//userDao.ChiudiConnessione();

			/*if(check==false) {
				PrintWriter out = resp.getWriter();
				out.println("<script>");
				out.println("alert('ERRORE username già esistente')");
				out.println("window.history.back()");
				out.println("</script>");
			}else {*/
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePageViewGenerale.jsp");
				dispatcher.forward(req, resp);
			//}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

