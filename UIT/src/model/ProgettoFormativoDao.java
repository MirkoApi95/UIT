package model;

import entity.ProgettoFormativo;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgettoFormativoDao {

  //****VARIABILI DELLA CLASSE****\\

  private ProgettoFormativo progetto = new ProgettoFormativo();
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;

  //****QUERY****\\
  
  private final String selectFromIdSql = "select * FROM ProgettoFormativo WHERE"
      + "ProgettoFormativo.ID_ProgettoFormativo= ?";
  private final String insertProgetto = "INSERT INTO ProgettoFormativo("
      + "ConvalidaDD,"
      + "ConvalidaTU,"
      + "Obiettivi,"
      + "direttoreDipartimento_utente_id_Utente,"
      + "tutorUniversitario_utente_id_Utente,"
      + "tutorAziendale1_utente_id_Utente,"
      + "tirocinante_utente_id_Utente)"
      + "VALUES(?,?,?,?,?,?,?)";
  private final String editConvalidaDd = "UPDATE ProgettoFormativo SET ConvalidaDD ="
      + "? WHERE ID_ProgettoFormativo = ?";
  private final String editConvalidaTu = "UPDATE ProgettoFormativo SET ConvalidaTU ="
      + "? WHERE ID_ProgettoFormativo = ?";

  //****COSTRUTTORE****\\
  public ProgettoFormativoDao() throws SQLException {
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
  public ProgettoFormativo doRetrieveByKey(int id) {
    try {
      preparedStatement = connection.prepareStatement(selectFromIdSql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        progetto.setTirocinante_Utente_idUtente(rs.getInt("tutorAziendale1_utente_id_Utente"));
        progetto.setTutorUniversitario_Utente_idUtente(
            rs.getInt("tutorUniversitario_utente_id_Utente"));
        progetto.setTirocinante_Utente_idUtente(rs.getInt("tirocinante_utente_id_Utente"));
        progetto.setId_progetto(rs.getInt("ID_ProgettoFormativo"));
        progetto.setDirettoreDipartimento_idDirettoreDipartimento(
            rs.getInt("direttoreDipartimento_utente_id_Utente"));
        progetto.setConvalidaDd(rs.getBoolean("ConvalidaDD"));
        progetto.setConvalidaTu(rs.getBoolean("ConvalidaTU"));
        progetto.setObiettivi(rs.getString("Obiettivi"));
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return progetto;
  }
  //****METODI DI UPLOAD****\\
  public boolean upLoadProject(ProgettoFormativo Object) throws SQLException {
    try {
      preparedStatement = connection.prepareStatement(insertProgetto);
      preparedStatement.setInt(6, Object.getTutorAziendale_Utente_idUtente());
      preparedStatement.setInt(5, Object.getTutorUniversitario_Utente_idUtente());
      preparedStatement.setInt(7, Object.getTirocinante_Utente_idUtente());
      preparedStatement.setInt(4, Object.getDirettoreDipartimento_idDirettoreDipartimento());
      preparedStatement.setBoolean(1, Object.getConvalidaDd());
      preparedStatement.setBoolean(2, Object.getConvalidaTu());
      preparedStatement.setString(3, Object.getObiettivi());
      int n = preparedStatement.executeUpdate();
      connection.commit();
      if (n != 0) {
        return true;
      } else { 
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  //****MEDOTO DI UPLOAD CONVALIDA DD****\\
  public boolean UploadConvalidaDD(ProgettoFormativo Object,boolean conv){
    if (Object == null) {
      return false;
    }
    Object.setConvalidaDd(conv);
    try {
      preparedStatement = connection.prepareStatement(editConvalidaDd);
      preparedStatement.setBoolean(1, Object.getConvalidaDd());
      preparedStatement.setInt(2, Object.getId_progetto());
      int n = preparedStatement.executeUpdate();
      connection.commit();
      if (n != 0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  //****MEDOTO DI UPLOAD CONVALIDA TU****\\
  public boolean UploadConvalidaTD(ProgettoFormativo Object,boolean conv){
    if (Object == null) {
      return false;
    }
    Object.setConvalidaDd(conv);
    try {
      preparedStatement = connection.prepareStatement(editConvalidaTu);
      preparedStatement.setBoolean(1, Object.getConvalidaDd());
      preparedStatement.setInt(2, Object.getId_progetto());
      int n = preparedStatement.executeUpdate();
      connection.commit();
      if (n != 0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}