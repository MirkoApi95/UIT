package control;


import entity.TutorAziendale;
import entity.TutorUniversitario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TutorAziendaleDao;
import model.TutorUniversitarioDao;

@WebServlet("/SelezioneAzienda")
public class SelezioneAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SelezioneAzienda() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
    doPost(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ArrayList<TutorAziendale> listata=TutorAziendaleDao.selectTutornames();
      String nome=request.getParameter("azienda");
      System.out.println(nome);
      //TutorUniversitario tuni = (TutorUniversitario)request.getSession().getAttribute("tuni");
      //ArrayList<TutorUniversitario> listatu=null;
      //listatu=TutorUniversitarioDao.selectTutorNames(nome);
      //int contatore=TutorUniversitarioDao.countTutor(nome);
      //for(int j=0;j<contatore;j++) {
        //tuni.setCognome(listatu.get(j).getCognome());
        //tuni.setNome(listatu.get(j).getNome());
      //}
      //ArrayList<TutorUniversitario> tunidef=new ArrayList<TutorUniversitario>();
      //tunidef.add(tuni);
      request.setAttribute("lista", listata);
      //request.setAttribute("listaprof", tunidef);
      request.getRequestDispatcher("/ListaAziendeView.jsp").forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}