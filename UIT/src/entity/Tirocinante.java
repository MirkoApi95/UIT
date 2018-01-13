/**
 * pakckage entity rappresentano le entità del database UIT 
 */
package entity;

import java.sql.Date;

/**
 * Classe che rappresenta l'entità Tirocinante del database UIT
 * @author Mirko
 */
public class Tirocinante extends Utente {

  private int matricola;
  private int numeroCfu;
  private int id;
  private Date annoIscrizione;
  /**
   * Costruttore della classe 
   * @param nome Stringa contenente il nome del tirocinante
   * @param cognome Stringa contenente il cognomenome del tirocinante
   * @param email Stringa contenente l'email ministeriale del tirocinante
   * @param password Stringa contenente la password del tirocinante
   * @param indirizzo Stringa contenente l'indirizzo del tirocinante
   * @param matricola Intero contenente la matricola del tirocinante
   * @param numeroCfu intero contenente i cuf del tirocinante, presi dal database universitario
   */
  public Tirocinante(String nome, String cognome, String email, String password,
      String indirizzo,int matricola, int numeroCfu) {
    super();
    this.matricola = matricola;
    this.numeroCfu = numeroCfu;
  }
  public Tirocinante() {

  }
  /**
   * metodo per restituire l'id
   * @param id= intero contenente l'id preso dal database
   */
  public int getId() {
    return id;
  }
  /**
   * Metodo per restituire la matricola
   * @return intero contentente la matricola
   */
  public int getMatricola() {
    return matricola;
  }
  /**
   * metodo per settare la matricola
   * @param matricola intero che rappresente la matricola
   */
  public void setMatricola(int matricola) {
    this.matricola = matricola;
  }
  /**
   * metodo per visualizzare il numero di cfu
   * @return un intero che rappresenta i cfu
   */
  public int getNumeroCfu() {
    return numeroCfu;
  }
  /**
   * metodo per settare il numero di cfu
   * @param numeroCfu intero che rappresenta il numero di cfu
   */
  public void setNumeroCfu(int numeroCfu) {
    this.numeroCfu = numeroCfu;
  }
  public void setAnno(String date) {
    annoIscrizione=java.sql.Date.valueOf(date);

  }
  public Date getAnno() {
    return annoIscrizione;

  }
}