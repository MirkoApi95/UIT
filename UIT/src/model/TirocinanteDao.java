package model;

import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TirocinanteDao extends UtenteDao {
  //****QUERY****\\
  private final String selectId = "select utente.id_Utente from utente where utente.Email=?";
  private final String inserimentoId = "INSERT INTO tirocinante("
      + "AnnoIscrizione,CFU,utente_id_utente,matricola)" + "VALUES(?,?,?,?)";
  private final String selectDatiUnisa = "SELECT AnnoIscrizione,CFU,"
      + "matricola FROM university WHERE Email=?";
  //****VARIABILI DELLA CLASSE****\\

  private Connection connectionUit;
  private Connection connectionUnisa;
  private PreparedStatement preparedStatement;

  //****COSTRUTTORE E CREAZIONE CONNESSIONE****\\
  public TirocinanteDao() throws SQLException {
    connectionUit = DriverManagerConnectionPoolUIT.getConnection();
    connectionUnisa = DriverManagerConnectionPoolUnisa.getConnection();
  }
  //****CHIUSURA DELLA CONNESSIONE\\

  public boolean ChiudiConnessione() {
    try {
      return DriverManagerConnectionPoolUIT.releaseConnection(connectionUit)
          && DriverManagerConnectionPoolUnisa.releaseConnection(connectionUnisa);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;
  }
  //****METODI DI POPOLAMENTO TIROCINANTE E CHIAVE ESTERNA****\\
  public boolean setIdSql(String Email) {
    try {
      preparedStatement = connectionUit.prepareStatement(selectId);
      preparedStatement.setString(1, Email);
      ResultSet rs = preparedStatement.executeQuery();
      rs.next();
      preparedStatement = connectionUnisa.prepareStatement(selectDatiUnisa);
      preparedStatement.setString(1, Email);
      ResultSet rs1 = preparedStatement.executeQuery();
      rs1.next();
      preparedStatement = connectionUit.prepareStatement(inserimentoId);
      preparedStatement.setDate(1, rs1.getDate(1));
      preparedStatement.setInt(2, rs1.getInt(2));
      preparedStatement.setInt(3,rs.getInt(1));
      preparedStatement.setInt(4,rs1.getInt(3));
      preparedStatement.executeUpdate();
      connectionUit.commit();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}