package entity;

public class ProgettoFormativo {
  private int idProgettoFormativo;
  private int tutorAziendaleUtenteIdUtente;
  private int tutorUniversitarioUtenteIdUtente;
  private int tirocinanteUtenteIdUtente;
  private int direttoreDipartimentoUtenteIdUtente;
  private boolean convalidaDd;
  private boolean convalidaTu;
  private String obiettivi;

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

  public ProgettoFormativo() {}

  public int getId_progetto() {
    return idProgettoFormativo;
  }

  public void setId_progetto(int id) {
    this.idProgettoFormativo = id;
  }

  public int getTutorAziendale_Utente_idUtente() {
    return tutorAziendaleUtenteIdUtente;
  }

  public void setTutorAziendale_Utente_idUtente(int tutorAziendaleUtenteIdUtente) {
    this.tutorAziendaleUtenteIdUtente = tutorAziendaleUtenteIdUtente;
  }

  public int getTutorUniversitario_Utente_idUtente() {
    return tutorUniversitarioUtenteIdUtente;
  }

  public void setTutorUniversitario_Utente_idUtente(int tutorUniversitarioUtenteIdUtente) {
    this.tutorUniversitarioUtenteIdUtente = tutorUniversitarioUtenteIdUtente;
  }

  public int getTirocinante_Utente_idUtente() {
    return tirocinanteUtenteIdUtente;
  }

  public void setTirocinante_Utente_idUtente(int tirocinanteUtenteIdUtente) {
    this.tirocinanteUtenteIdUtente = tirocinanteUtenteIdUtente;
  }

  public int getDirettoreDipartimento_idDirettoreDipartimento() {
    return direttoreDipartimentoUtenteIdUtente;
  }

  public void setDirettoreDipartimento_idDirettoreDipartimento(
      int direttoreDipartimentoIdDirettoreDipartimento) {
    this.direttoreDipartimentoUtenteIdUtente = direttoreDipartimentoIdDirettoreDipartimento;
  }

  public boolean getConvalidaDd() {
    return convalidaDd;
  }

  public void setConvalidaDd(boolean convalidaDd) {
    this.convalidaDd = convalidaDd;
  }

  public boolean getConvalidaTu() {
    return convalidaTu;
  }

  public void setConvalidaTu(boolean convalidaTu) {
    this.convalidaTu = convalidaTu;
  }

  public String getObiettivi() {
    return obiettivi;
  }

  public void setObiettivi(String obiettivi) {
    this.obiettivi = obiettivi;
  }
}