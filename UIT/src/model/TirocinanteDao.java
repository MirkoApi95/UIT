package model;
  /**
   * Classe DAO che permette di popolare la tabella del tirocinante e che permette di prelevare i dati appartenenti al tirocinante
   * @author fmanc
   */
import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Tirocinante;
import entity.Utente;

public class TirocinanteDao extends UtenteDao {
  //****QUERY****\\
  private final String selectId = "select utente.id_Utente from utente where utente.Email=?";
  private final String inserimentoId = "INSERT INTO tirocinante("
      + "AnnoIscrizione,CFU,utente_id_utente,matricola)" + "VALUES(?,?,?,?)";
  private final String selectDatiUnisa = "SELECT AnnoIscrizione,CFU,"
      + "matricola FROM university WHERE Email=?";
  private final String selectDatiTirocinanteUit = "SELECT AnnoIscrizione,CFU,Matricola FROM tirocinante WHERE utente_id_Utente=?";
  //****VARIABILI DELLA CLASSE****\\

  private Connection connectionUit;
  private Connection connectionUnisa;
  private PreparedStatement preparedStatement;
  /**
  * @param connectionUit variabile che istanzia la connessione al database UIT
  * @param connectionUnisa variabile che istanzia la connessione al database universitario
  * @param preparedStatement variabile che permette di eseguire la query
  */
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
  public Tirocinante getTirocinante(Utente u) {
    try {
      Tirocinante t = new Tirocinante();
      preparedStatement = connectionUit.prepareStatement(selectDatiTirocinanteUit);
      preparedStatement.setInt(1, u.getId());
      ResultSet rs = preparedStatement.executeQuery();
      rs.next();
      t.setAnno(rs.getString("AnnoIscrizione"));
      t.setNumeroCfu(rs.getInt("CFU"));
      t.setMatricola(rs.getInt("Matricola"));
      return t;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;

  }
}