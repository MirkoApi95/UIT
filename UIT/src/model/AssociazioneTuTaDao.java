package model;

import entity.TutorAziendale;
import entity.TutorUniversitario;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssociazioneTuTaDao {

  //****VARIABILI DELLA CLASSE****\
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ArrayList<TutorUniversitario> lista = new ArrayList<TutorUniversitario>();
  private TutorUniversitario tu;


  //****QUERY****\\
  private final String listaIdAssociati = "SELECT tutoruniversitario_utente_id_Utente FROM"
      + "associazionetu_ta WHERE tutorAziendale1_utente_id_Utente=?";

  private final String listaTuAssociati = "SELECT Nome,Cognome FROM Utente WHERE id_Utente =?";

  //****COSTRUTTORE****\\
  public AssociazioneTuTaDao() throws SQLException {
    connection = DriverManagerConnectionPoolUIT.getConnection();
  }
  
  //****CHIUSURA DELLA CONNESSIONE\\
  public boolean chiudiConnessione() {
    try {
      return DriverManagerConnectionPoolUIT.releaseConnection(connection);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;
  }


  //****LISTA ASSOCIAZIONI
  public ArrayList<TutorUniversitario> listaAssociazioniTU_TA(TutorAziendale TA){
    try {
      preparedStatement = connection.prepareStatement(listaIdAssociati);
      preparedStatement.setInt(1, TA.getId());
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        tu.setId(rs.getInt(1));
        lista.add(tu);
      }
      connection.prepareStatement(listaTuAssociati);
      ResultSet rs1 = preparedStatement.executeQuery();

      for (int i = 0; i < lista.size(); i++) {
        lista.get(i).setNome(rs1.getString(1));
        lista.get(i).setCognome(rs1.getString(2));
      }
      return lista;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}