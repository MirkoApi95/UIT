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

@WebServlet("/Registrationservlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utente user= new Utente();

		user.setNome(req.getParameter("Nome"));
		user.setCognome(req.getParameter("Cognome"));
		user.setEmail(req.getParameter("Email"));
		user.setPassword(req.getParameter("Password"));
		user.setIndirizzo(req.getParameter("Indirizzo"));

		try {
			UtenteDao userDao = new UtenteDao();
			boolean check=userDao.upLoadUtente(user);
			userDao.ChiudiConnessione();

			if(check==false) {
				PrintWriter out = resp.getWriter();
				out.println("<script>");
				out.println("alert('ERRORE username già esistente')");
				out.println("window.history.back()");
				out.println("</script>");
			}else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userLogin");
				dispatcher.forward(req, resp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

