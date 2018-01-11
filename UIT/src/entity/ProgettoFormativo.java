/**
 * pakckage entity rappresentano le entit� del database UIT 
 */

package entity;

/**
 * Classe che rappresenta l'entit� ProgettoFormativo presente nel database UIT
 * @author Mirko
 */
public class ProgettoFormativo {
  private int idProgettoFormativo;
  private int tutorAziendaleUtenteIdUtente;
  private int tutorUniversitarioUtenteIdUtente;
  private int tirocinanteUtenteIdUtente;
  private int direttoreDipartimentoUtenteIdUtente;
  private boolean convalidaDd;
  private boolean convalidaTu;
  private String obiettivi;

  /**
   * Costruttore della classe che prende anche l'id, quindi utilizzato per le pratiche gi� presenti in data base
   * @param id l'id vine generato automaticamente da MySql � un intero
   * @param convalidaDd rappresenta se il progetto � stato validato dal Direttore del Dipartimento,
   * � un booleano settato inizialmente a false
   * @param convalidaTu rappresenta se il progetto � stato validato dal Tutor universitario scelto,
   * � un booleano settato inizialmente a false
   * @param obiettivi � di tipo string contine gli obiettivi e finalit� del tirocinante 
   * @param tutorAziendaleUtenteIdUtente � un intenro rappresenta l'id del tutor Aziendale selezionato per il progetto
   * @param tutorUniversitarioUtenteIdUtente � un intenro rappresenta l'id del tutor Universitario selezionato per il progetto
   * @param tirocinanteUtenteIdUtente � un intenro rappresenta l'id del tirocinante per il progetto
   * @param direttoreDipartimentoIdDirettoreDipartimento � un intenro rappresenta l'id del direttore del dipartimento per il progetto
   */
  public ProgettoFormativo(
      int id,
      Boolean convalidaDd,
      Boolean convalidaTu,
      String obiettivi,
      int tutorAziendaleUtenteIdUtente,
      int tutorUniversitarioUtenteIdUtente, 
      int tirocinanteUtenteIdUtente,
      int direttoreDipartimentoIdDirettoreDipartimento) {
    this.tutorAziendaleUtenteIdUtente = tutorAziendaleUtenteIdUtente;
    this.tutorUniversitarioUtenteIdUtente = tutorUniversitarioUtenteIdUtente;
    this.tirocinanteUtenteIdUtente = tirocinanteUtenteIdUtente;
    this.direttoreDipartimentoUtenteIdUtente = direttoreDipartimentoIdDirettoreDipartimento;
    this.convalidaDd = convalidaDd;
    this.convalidaTu = convalidaTu;
    this.obiettivi = obiettivi;
    this.idProgettoFormativo = id;
  }
  /**
   * Costruttore della classe senza id, utilizzato per creare un nuovo progetto, l'id sar� generato automaticamente da MySql
   * @param convalidaDd rappresenta se il progetto � stato validato dal Direttore del Dipartimento,
   * � un booleano settato inizialmente a false
   * @param convalidaTu rappresenta se il progetto � stato validato dal Tutor universitario scelto,
   * � un booleano settato inizialmente a false
   * @param obiettivi � di tipo string contine gli obiettivi e finalit� del tirocinante 
   * @param tutorAziendaleUtenteIdUtente � un intenro rappresenta l'id del tutor Aziendale selezionato per il progetto
   * @param tutorUniversitarioUtenteIdUtente � un intenro rappresenta l'id del tutor Universitario selezionato per il progetto
   * @param tirocinanteUtenteIdUtente � un intenro rappresenta l'id del tirocinante per il progetto
   * @param direttoreDipartimentoIdDirettoreDipartimento � un intenro rappresenta l'id del direttore del dipartimento per il progetto
   */
  public ProgettoFormativo(
      Boolean convalidaDd,
      Boolean convalidaTu,
      String obiettivi,
      int tutorAziendaleUtenteIdUtente,
      int tutorUniversitarioUtenteIdUtente,
      int tirocinanteUtenteIdUtente,
      int direttoreDipartimentoIdDirettoreDipartimento) {
    this.tutorAziendaleUtenteIdUtente = tutorAziendaleUtenteIdUtente;
    this.tutorUniversitarioUtenteIdUtente = tutorUniversitarioUtenteIdUtente;
    this.tirocinanteUtenteIdUtente = tirocinanteUtenteIdUtente;
    this.direttoreDipartimentoUtenteIdUtente = direttoreDipartimentoIdDirettoreDipartimento;
    this.convalidaDd = convalidaDd;
    this.convalidaTu = convalidaTu;
    this.obiettivi = obiettivi;

  }
  /**
   * Cotruttore vuoto della classe
   */
  public ProgettoFormativo() {}

  /**
   * Metodo che restituisce l'id del progetto formativo
   * @return un intero che rappresenta l'id assegnato al progetto formativo
   */
  public int getId_progetto() {
    return idProgettoFormativo;
  }
  /**
   * Setta l'id al progetto feromativo, l'id deve essere preso dal DataBase
   * @param id � un intero che rappresenta l'id
   */
  public void setId_progetto(int id) {
    this.idProgettoFormativo = id;
  }
  /**
   * Metodo che restituisce l'id del tutor aziendale
   * @return un interno che rappresenta l' id del Tutor Aziendale presente in questo progetto
   */
  public int getTutorAziendale_Utente_idUtente() {
    return tutorAziendaleUtenteIdUtente;
  }
  /**
   * Metodo che setta l'id del tutor aziendale scelto, l'id � preso dal database UIT
   * @param tutorAziendaleUtenteIdUtente � un intero che rappresenta l'id
   */
  public void setTutorAziendale_Utente_idUtente(int tutorAziendaleUtenteIdUtente) {
    this.tutorAziendaleUtenteIdUtente = tutorAziendaleUtenteIdUtente;
  }
  /**
   * Metodo che restituisce l'id del tutor universitario
   * @return un interno che rappresenta l' id del Tutor universitario presente in questo progetto
   */
  public int getTutorUniversitario_Utente_idUtente() {
    return tutorUniversitarioUtenteIdUtente;
  }
  /**
   * Metodo che setta l'id del tutor universitario scelto, l'id � preso dal database UIT
   * @param tutorAziendaleUtenteIdUtente � un intero che rappresenta l'id
   */
  public void setTutorUniversitario_Utente_idUtente(int tutorUniversitarioUtenteIdUtente) {
    this.tutorUniversitarioUtenteIdUtente = tutorUniversitarioUtenteIdUtente;
  }
  /**
   * Meotodo che restituisce l'id del tirocinante
   * @return un interno che rappresenta l'id del tirocinante
   */
  public int getTirocinante_Utente_idUtente() {
    return tirocinanteUtenteIdUtente;
  }
/**
 *  Metodo per settare l'id del tirocinante interessato
 * @param tirocinanteUtenteIdUtente � un intero che rappresenta l'id
 */
  public void setTirocinante_Utente_idUtente(int tirocinanteUtenteIdUtente) {
    this.tirocinanteUtenteIdUtente = tirocinanteUtenteIdUtente;
  }
/**
 * Metodo per restituire il direttore dipartimento associato al progetto formativo
 * @return � un intero che rappresenta l'id del direttore del dipartimento
 */
  public int getDirettoreDipartimento_idDirettoreDipartimento() {
    return direttoreDipartimentoUtenteIdUtente;
  }
  /**
   * Metodo per settare l'id del direttore dipartimento associato al progetto formativo
   * @param direttoreDipartimentoIdDirettoreDipartimento � un interno che rappresenta l'id del direttore del dipartimento
   */
  public void setDirettoreDipartimento_idDirettoreDipartimento(
      int direttoreDipartimentoIdDirettoreDipartimento) {
    this.direttoreDipartimentoUtenteIdUtente = direttoreDipartimentoIdDirettoreDipartimento;
  }
/**
 *  Metodo per visualizzare se la convalida da parte de direttore del dipartimento � avvenuta
 * @return un boolean true=validato false=non validato
 */
  public boolean getConvalidaDd() {
    return convalidaDd;
  }
  /**
   * Metodo per cambiare lo stato della pratica da parte del direttore del dipartimento
   * @param convalidaDd un booleano per settare lo stato di convalida
   */
  public void setConvalidaDd(boolean convalidaDd) {
    this.convalidaDd = convalidaDd;
  }
  /**
   *  Metodo per visualizzare la convalida da parte del tutor universitario se � avvenuta
   * @return un boolean true=validato false=non validato
   */
  public boolean getConvalidaTu() {
    return convalidaTu;
  }
  /**
   * Metodo per cambiare lo stato della pratica da parte del tutor universitario
   * @param convalidaTu un booleano per settare lo stato di convalida
   */
  public void setConvalidaTu(boolean convalidaTu) {
    this.convalidaTu = convalidaTu;
  }
/**
 * Metodo per visualizzare gli obiettivi inseriti dal tirocinante
 * @return una stringa con gli obiettivi
 */
  public String getObiettivi() {
    return obiettivi;
  }
/**
 * Metodo per inserire gli obiettivi del tirocinante 
 * @param obiettivi stringa contente gli obbiettivi
 */
  public void setObiettivi(String obiettivi) {
    this.obiettivi = obiettivi;
  }
}