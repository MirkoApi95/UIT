/**
 * pakckage entity rappresentano le entità del database UIT 
 */
package entity;
/**
 *Classe che rappresenta l'entità Tutor Aziendale del database UIT
 * @author Mirko
 *
 */
public class TutorAziendale extends Utente {

  private String nomeazienda;
  private String sede;
/**
 * Costruttore della classe  che riempirà anche la superclasse
 * @param nomeazienda stringa contente il nome dell'azienda
 * @param sede stringa contente la città dell'azienda
 * @param nome stringa contente il nome del tutor aziendale associato all'azienda
 * @param cognome stringa contente il nome del tutor aziendale associato all'azienda
 * @param email stringa contente l'email associata all'azienda
 * @param password stringa contente la passowrd
 * @param indirizzo string contente l'indirizzo del tutor aziendale 
 */
  public TutorAziendale(String nomeazienda,String sede,String nome,
      String cognome, String email, String password, String indirizzo) {
    super.setNome(nome);
    super.setCognome(cognome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }
/**
 * Costruttore vuoto
 */
  public TutorAziendale() {
  }
/**
 * metodo per restituire il nome dell'azienda
 * @return stringa conente il nome dell'azienda
 */
  public String getNomeazienda() {
    return nomeazienda;
  }
  /**
   * metodo per settare il nome dell'azienda
   * @param nomeazienda stringa contenente il nome dell'azienda
   */
  public void setNomeazienda(String nomeazienda) {
    this.nomeazienda = nomeazienda;
  }
  /**
   * metodo per restituire la sede dell'azienda
   * @return stringa contenente il nome della sede
   */
  public String getSede() {
    return sede;
  }
  /**
   * Metodo per settare la sede dell'azienda ospitante
   * @param sede stringa contenente la sede
   */
  public void setSede(String sede) {
    this.sede = sede;
  }
}