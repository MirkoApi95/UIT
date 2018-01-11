/**
 * pakckage entity rappresentano le entit� del database UIT 
 */
package entity;
/**
 * Classe che rappresenta l'Utente nel database UIT
 * @author Mirko
 *
 */
public class Utente {
  private int id;
  private String nome;
  private String cognome;
  private String email;
  private String password;
  private String indirizzo;
  /**
   * Costruttore della classe 
   * @param nome stringa contente il nome del utente
   * @param cognome stringa contente il cognome dell'utente
   * @param email stringa contente l'email dell'utente
   * @param password stringa contente la passowrd
   * @param indirizzo string contente l'indirizzo dell'utente
   * @param id intero contenente l'id dell'utente generato dal database
   */
  public Utente(String nome, String cognome, String email,
      String password, String indirizzo,int id) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.indirizzo = indirizzo;
    this.id = id;
  }
  /**
   * Costruttore della classe senza id, serve quando hai bisogno di inserire un nuovo utente perch� l'id lo   *generer� mysql
   * @param nome stringa contente il nome del utente
   * @param cognome stringa contente il cognome dell'utente
   * @param email stringa contente l'email dell'utente
   * @param password stringa contente la passowrd
   * @param indirizzo string contente l'indirizzo dell'utente
   */
  public Utente(String nome, String cognome, String email,
      String password, String indirizzo) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.indirizzo = indirizzo;
  }
/**
 * costruttore vuoto
 */
  public Utente(){
  }
/**
 * metodo che restituisce il nome dell'utente
 * @return stringa contenente il nome
 */
  public String getNome() {
    return nome;
  }
/**
 * metodo per settare il nome dell'utente
 * @param nome stringa contenente il nome
 */
  public void setNome(String nome) {
    this.nome = nome;
  }
/**
 * metodo per restituire l'email
 * @return string contenente l'email
 */
  public String getEmail() {
    return email;
  }
  /**
   * metodo per settare l'email
   * @param email stringa contenente l'email
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * metodo per restituire il cognome
   * @return string contenente il cognome
   */
  public String getCognome() {
    return cognome;
  }
  /**
   * metodo per settare il cognome
   * @param email stringa contenente il cognome
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
  /**
   * metodo per restituire la password
   * @return string contenente la password
   */
  public String getPassword() {
    return password;
  }
  /**
   * metodo per settare la password
   * @param email stringa contenente la password
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * metodo per restituire l'indirizzo
   * @return string contenente l'indirizzo
   */
  public String getIndirizzo() {
    return indirizzo;
  }
  /**
   * metodo per settare l'indirizzo
   * @param email stringa contenente l'indirizzo
   */
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }
  /**
   * metodo per restituire l'id utente
   * @return id intero contenente l'id utente
   */
  public int getId() {
    return id;
  }
  /**
   * metodo per settare l'id
   * @param id intero contenente l'id
   */
  public void setId(int id) {
    this.id = id;
  }
}