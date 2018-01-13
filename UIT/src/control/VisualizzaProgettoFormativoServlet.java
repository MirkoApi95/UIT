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


@WebServlet("/VisualizzaProgettoFormativoServlet")
public class VisualizzaProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public VisualizzaProgettoFormativoServlet() {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    
    
    request.getRequestDispatcher("/??????????????????????VisualizzaProgettoFormativoView.jsp").forward(request, response);
  }

}
