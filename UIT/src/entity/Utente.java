/**
 * pakckage entity rappresentano le entità del database UIT 
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
   * Costruttore della classe senza id, serve quando hai bisogno di inserire un nuovo utente perchè l'id lo   *genererà mysql
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
 * @return
 */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}