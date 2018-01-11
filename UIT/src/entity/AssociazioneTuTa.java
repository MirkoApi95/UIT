package entity;

/**
 * @author Salvatore Mirko Apicella
 * Clesse che rappesenta l'entità nel database UIT AssociazioneTU_TA, serve per collegare i professori alle aziende
 * viene utilizzata durante la scelta dell'azienda con un possibile tutor universitario
 */

public class AssociazioneTuTa {

  private String nomeazienda;
  private String nominativo;
  private int tutoruniveristarioUtenteIdUtente;
  private int tutoraziendaleUtenteIdUtente;

  /**
   * Metodo di get id_Utente del tutor aziendale
   * @return un intero che corrispendo all'id del tutor aziendale
   */
  public int getTutoraziendale_utente_idUtente() {
    return tutoraziendaleUtenteIdUtente;
  }
  /**
   * Metodo di set id_Utente del tutor aziendale
   * @return nulla
   */
  public void setTutoraziendale_utente_idUtente(int tutoraziendaleUtenteIdUtente) {
    this.tutoraziendaleUtenteIdUtente = tutoraziendaleUtenteIdUtente;
  }
  /**
   * Metodo di get id_Utente del tutor universitario
   * @return un intero che corrispendo all'id del tutor universitario
   */
  public int getTutoruniveristario_utente_idUtente() {
    return tutoruniveristarioUtenteIdUtente;
  }
  /**
   * Metodo di set id_Utente del tutor universitario
   * @return un interno che corrisponde all'id del tutor universitario associazto
   */
  public void setTutoruniveristario_utente_idUtente(int tutoruniveristarioUtenteIdUtente) {
    this.tutoruniveristarioUtenteIdUtente = tutoruniveristarioUtenteIdUtente;
  }
  /**
   * Costruttore della classe
   * @param tutoraziendaleUtenteIdUtente è un interno corrispondente all'id del tutor aziendale da associare
   * @param tutoruniveristarioUtenteIdUtente è un interno corrispondente all'id del tutor universitario da 
   * sociare
   */
  public AssociazioneTuTa(int tutoraziendaleUtenteIdUtente,
      int tutoruniveristarioUtenteIdUtente) {
    this.tutoraziendaleUtenteIdUtente = tutoraziendaleUtenteIdUtente;
    this.tutoruniveristarioUtenteIdUtente = tutoruniveristarioUtenteIdUtente;
  }
  /**
   * Costruttore vuoto della classe non prende nessun parametro in input
   */
  public AssociazioneTuTa() {}
  /**
   * Metodo per restituire il nome dell'azienda del tutor aziendale settato
   * @return una stringa corrispondente al nome dell'azienda settata
   */
  public String getNomeazienda() {
    return nomeazienda;
  }
  /**
   * Metodo per settare il nome azienda del tutor aziendale settato
   * @param nomeazienda è una stringa che rappresenta il nome dell'azienda
   */
  public void setNomeazienda(String nomeazienda) {
    this.nomeazienda = nomeazienda;
  }
  /**
   * Metodo che restituisce il nome del tutor aziendale settato
   * @return una stringa conentente il nome del tutor aziendale
   */
  public String getNominativo() {
    return nominativo;
  }
/**
 * Metodo per settare il nome del tutor aziendale
 * @param nominativo rappresenta il nome del tutor aziendale da settare
 */
  public void setNominativo(String nominativo) {
    this.nominativo = nominativo;
  }
}
