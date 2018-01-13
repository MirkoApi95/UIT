package model;

import entity.TutorAziendale;
import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutorAziendaleDao extends UtenteDao {
  //****VARIABILI DELLA CLASSE****\\
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private TutorAziendale ta=null;


  //****QUERY****\\
  private final String selectfromIdSql = "SELECT * FROM tutoraziendale WHERE Utente_id_Utente=?";
  private final String insertDati = "INSERT INTO tutoraziendale ("
      + "NomeAzienda,Sede,utente_id_Utente)"
      + "VALUES(?,?,?)";
  private final String listaAziende = "SELECT NomeAzienda,utente_id_Utente FROM  tutoraziendale";


  //****COSTRUTTORE****\\
  public TutorAziendaleDao() throws SQLException {
    connection = DriverManagerConnectionPoolUIT.getConnection();
  }
  //****CHIUSURA DELLA CONNESSIONE\\
  
  public boolean ChiudiConnessione() {
    try {
      return DriverManagerConnectionPoolUIT.releaseConnection(connection);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;
  }

  //****METODI DI DOWNLOAD****\\
  public TutorAziendale doRetrieveByKey(int id) {
   TutorAziendale otherUser=new TutorAziendale();   
    try {
      preparedStatement = connection.prepareStatement(selectfromIdSql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      otherUser.setNomeazienda(rs.getString("NomeAzienda"));
      otherUser.setSede(rs.getString("Sede"));
      return otherUser;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  //****METODO DI UPLOAD
  public boolean inserisciTA(String Azienda,String Sede,int id) {

    try {
      preparedStatement = connection.prepareStatement(insertDati);
      preparedStatement.setString(1, Azienda);
      preparedStatement.setString(2, Sede);
      preparedStatement.setInt(3, id);
      preparedStatement.executeUpdate();
      connection.commit();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
      return false;
    }

  }
  //***METODO LISTA AZIENDA
  public ArrayList<TutorAziendale> listaAziende() {
    ArrayList<TutorAziendale> lista = new ArrayList<TutorAziendale>();
    try {
      preparedStatement = connection.prepareStatement(listaAziende);
      ResultSet rs = preparedStatement.executeQuery();
     
      while (rs.next()) {
        ta=new TutorAziendale();
        ta.setNomeazienda(rs.getString(1));
        ta.setId(rs.getInt(2));
        lista.add(ta);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }
  
  public static synchronized ArrayList<TutorAziendale> selectTutornames() throws SQLException{
    final String sqlselect="SELECT NomeAzienda,utente_id_Utente FROM  tutoraziendale";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ArrayList<TutorAziendale> tutorList = new ArrayList<TutorAziendale>();

    try {
        connection=DriverManagerConnectionPoolUIT.getConnection();
        preparedStatement=connection.prepareStatement(sqlselect);
        ResultSet rs=preparedStatement.executeQuery();

        while (rs.next()){
            TutorAziendale t=new TutorAziendale();
            t.setNomeazienda(rs.getString("NomeAzienda"));
            t.setId((rs.getInt("utente_id_Utente")));
            tutorList.add(t);
            System.out.println(t);
        }
}catch (SQLException e) {
    e.printStackTrace();
}
    return tutorList;
}
}