package control;

import entity.AssociazioneTuTa;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AssociazioneTuTaDao;
import model.TutorAziendaleDao;

@WebServlet("/SelezioneAzienda")
public class SelezioneAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SelezioneAzienda() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      List <AssociazioneTuTa> listatatu ;
      List <TutorAziendale> listata;
      AssociazioneTuTaDao tutadao;
      TutorAziendaleDao tad=new TutorAziendaleDao();
      listata=tad.listaAziende();
      for(int i = 0;i<listata.size();i++) {
        listatatu.get(i).addTa(listata.get(i));
      }for(int j=0;j<listata.size();j++) {
        listatatu.get(j).addListTu(tutadao.listaAssociazioniTU_TA(listata.get(j)));
      }

      request.setAttribute("array", );
      request.getRequestDispatcher("/ListaAziendeView.jsp").forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException 
  {
    response.getWriter().append("Served at: error ").append(request.getContextPath());
  }
}