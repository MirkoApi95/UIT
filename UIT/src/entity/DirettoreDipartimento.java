/**
 * pakckage entity rappresentano le entità del database UIT 
 */

package entity;
/**
 * Classe che rappresenta l'entità DirettoreDipartimento presente nel database UIT
 * estende Utente in quanto il DirettoreDipartimento è un untente serve per la gestione delle home page
 * @author Mirko
 */
public class DirettoreDipartimento extends Utente {
  /**
   * Costruttore della calsse che riempie i campi anche della superclasse Utente
   * @param nome nome del direttore del dipartimento
   * @param cognome cognome del direttore del dipartimento
   * @param email email ministeriale del direttore dipartimento
   * @param password password del direttore del dipartimento
   * @param indirizzo indirizzo del direttore del diparimeno
   * @param identificativo id generato automaticamnete da MYsql è un interno recuperabile dal database
   */
  public DirettoreDipartimento(String nome, String cognome, String email,
      String password, String indirizzo, int identificativo) {
    super.setCognome(cognome);
    super.setNome(nome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }
}