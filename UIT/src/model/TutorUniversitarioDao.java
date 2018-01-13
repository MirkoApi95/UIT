package model;

import gestoreStorage.DriverManagerConnectionPoolUIT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.TutorAziendale;
import entity.TutorUniversitario;
import entity.Utente;

public class TutorUniversitarioDao extends UtenteDao {

  //****VARIABILI DELLA CLASSE****\\
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;

  //****QUERY****\\

  private final String insertDati = "INSERT INTO tutoruniversitario (utente_id_Utente)"
        + "VALUES(?)";

  //****COSTRUTTORE****\\
  public TutorUniversitarioDao() throws SQLException {
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

  //****METODO DI UPLOAD
  public boolean inserisciTU(int id) {
    try {
      preparedStatement = connection.prepareStatement(insertDati);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
      connection.commit();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
      return false;
    }
  }
  public static synchronized ArrayList<TutorUniversitario> selectTutorNames(String azienda) throws SQLException{
    ArrayList<TutorUniversitario> tuList=new ArrayList<TutorUniversitario>();
    final String sqlselect="SELECT Nome, Cognome,id_Utente FROM utente, tutoruniversitario, tutoraziendale, associazionetu_ta WHERE tutoruniversitario.utente_id_Utente=associazionetu_ta.tutoruniversitario_utente_id_Utente AND associazionetu_ta.tutorAziendale1_utente_id_Utente=tutoraziendale.utente_id_Utente AND utente.id_Utente=tutoruniversitario.utente_id_Utente AND tutoraziendale.NomeAzienda=?;";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    try {
      connection=DriverManagerConnectionPoolUIT.getConnection();
      preparedStatement=connection.prepareStatement(sqlselect);
      preparedStatement.setString(1, azienda);
      ResultSet rs=preparedStatement.executeQuery();

      while (rs.next()){
          TutorUniversitario t=new TutorUniversitario();
          t.setNome(rs.getString("Nome"));
          t.setCognome(rs.getString("Cognome"));
          t.setId(rs.getInt("id_Utente"));
          tuList.add(t);
    }
  }catch(SQLException e) {
    e.printStackTrace();
  }
    return tuList;
}
  public static synchronized int countTutor (String azienda) {
    int risultato=0;
    final String sqlcount="select count(*) from (SELECT Nome, Cognome FROM utente, tutoruniversitario, tutoraziendale, associazionetu_ta WHERE tutoruniversitario.utente_id_Utente=associazionetu_ta.tutoruniversitario_utente_id_Utente AND associazionetu_ta.tutorAziendale1_utente_id_Utente=tutoraziendale.utente_id_Utente AND utente.id_Utente=tutoruniversitario.utente_id_Utente AND tutoraziendale.NomeAzienda=?) as conteggio";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    try {
      connection=DriverManagerConnectionPoolUIT.getConnection();
      preparedStatement=connection.prepareStatement(sqlcount);
      preparedStatement.setString(1, azienda);
      ResultSet rs=preparedStatement.executeQuery();

      while (rs.next()){
        risultato=rs.getInt("count(*)");
  }
}catch(SQLException e) { e.printStackTrace();}
    return risultato;
}

}