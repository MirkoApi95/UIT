package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.TutorUniversitario;
import model.ProgettoFormativoDao;


@WebServlet("/ProgettoFormativoServlet")
public class ProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public ProgettoFormativoServlet() {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList<String> listacompleta=new ArrayList<String>();
    String nominativo=(String) request.getParameter("dropdown");
    HttpSession session=request.getSession();
    session.setAttribute("tutorUni", nominativo);
    
    
    request.getRequestDispatcher("/CompilaProgettoFormativoView.jsp").forward(request, response);
  }

}
