package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Utente;
import gestoreStorage.DriverManagerConnectionPoolUIT;
import gestoreStorage.DriverManagerConnectionPoolUnisa;

public class UtenteDao {
  //****VARIABILI DELLA CLASSE****\

  private Connection connection = null;
  private PreparedStatement preparedStatement = null;

  //****QUERY****\\
  private final String selectFromIdSql = "select * FROM Utente "
      + "WHERE utente.id_Utente= ?";
  private final String selectFromEmailSql = "select * FROM Utente "
      + "WHERE utente.Email= ?";
  private final String insertUtente = "INSERT INTO Utente " 
      + "(Nome, Cognome, Indirizzo, Email, Password) " + "VALUES(?,?,?,?,?)";
  private final String editaddress = "UPDATE utente SET Indirizzo=? "
      + "WHERE utente.id_Utente=?";
  private final String editpassword = "UPDATE utente SET Password=? "
      + "WHERE utente.id_Utente=?";
  private final String checkUtente = "SELECT Email FROM university "
      + "WHERE Email=?";
  private final String datiUnisa = "SELECT Nome,Cognome,Indirizzo FROM university WHERE Email=?";
  //****COSTRUTTORE****\\
  public UtenteDao() throws SQLException {
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
  public Utente doRetrieveByKey(int id) {
    Utente utente = new Utente();
    try {
      preparedStatement = connection.prepareStatement(selectFromIdSql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        utente.setNome(rs.getString("Nome"));
        utente.setCognome(rs.getString("Cognome"));
        utente.setIndirizzo(rs.getString("Indirizzo"));
        utente.setEmail(rs.getString("Email"));
        utente.setPassword(rs.getString("Password"));
        utente.setId(rs.getInt("id_Utente"));
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    if (utente.getId() == 0) {
      return null;
    }
    return utente;
  }
  
  public Utente doRetrieveByMail (String mail) {
    Utente utente = new Utente();
    try {
      preparedStatement = connection.prepareStatement(selectFromEmailSql);
      preparedStatement.setString(1, mail);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        utente.setNome(rs.getString("Nome"));
        utente.setCognome(rs.getString("Cognome"));
        utente.setIndirizzo(rs.getString("Indirizzo"));
        utente.setEmail(rs.getString("Email"));
        utente.setPassword(rs.getString("Password"));
        utente.setId(rs.getInt("id_Utente"));
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    if (utente.getId() == 0) {
      return null;
    }
    return utente;
  }
  //****METODi DI UPLOAD****\\
  public boolean upLoadUtente(Utente Object) throws SQLException {
    //Connection conUnisa=null;
    try {
      //CONTROLLO DATABASE UNIVERSITARIO
      Connection conUnisa = DriverManagerConnectionPoolUnisa.getConnection();
      preparedStatement = conUnisa.prepareStatement(checkUtente);
      preparedStatement.setString(1, Object.getEmail());
      ResultSet rs = preparedStatement.executeQuery();
      System.out.println("CONTROLLO NEL DATABASE UNIVERSITARIO");
      if (!rs.next()) {
        return false;
      }
      DriverManagerConnectionPoolUnisa.releaseConnection(conUnisa);
      //CONTROLLO SUL DATABASE INTERNO
      preparedStatement = connection.prepareStatement(selectFromEmailSql);
      preparedStatement.setString(1, Object.getEmail());
      ResultSet rs1 = preparedStatement.executeQuery();
      System.out.println("CONTROLLO NEL DATABASE INTERNO");
      if (rs1.next()) {
        return false;
      }
      //POPOLAMENTO CAMPI MANCANTI
      
      preparedStatement = conUnisa.prepareStatement(datiUnisa);
      preparedStatement.setString(1, Object.getEmail());
      ResultSet rs2 = preparedStatement.executeQuery();
      System.out.println("DOWNLOAD DATI DA UNISA");
      while(rs2.next()) {
      Object.setNome(rs2.getString("Nome"));
      Object.setCognome(rs2.getString("Cognome"));
      Object.setIndirizzo(rs2.getString("Indirizzo"));
      System.out.println("FINE DOWNLOAD");
      }

      
      //ESEGUE INSERIMENTO
      preparedStatement = connection.prepareStatement(insertUtente);
      preparedStatement.setString(1, Object.getNome());
      preparedStatement.setString(2, Object.getCognome());
      preparedStatement.setString(3, Object.getIndirizzo());
      preparedStatement.setString(4, Object.getEmail());
      preparedStatement.setString(5, Object.getPassword());
      int n = preparedStatement.executeUpdate();
      connection.commit();
      System.out.println("INSERITO NELLA TABELLA UTENTE");
      if (n != 0) {
        return true;
      } else {
        return false;
      }}
     catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean modificaIndirizzo(Utente Object,String indirizzo) {
    if (Object == null) {
      return false;
    }
    try {
      preparedStatement = connection.prepareStatement(editaddress);
      preparedStatement.setString(1, indirizzo);
      preparedStatement.setInt(2, Object.getId());
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

  public boolean modificaPassword(Utente Object,String password) {
    if (Object == null) {
      return false;
    }
    try {
      preparedStatement = connection.prepareStatement(editpassword);
      preparedStatement.setString(1, password);
      preparedStatement.setInt(2, Object.getId());
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