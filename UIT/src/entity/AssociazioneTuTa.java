package entity;

public class AssociazioneTuTa {
  
  private String nomeazienda;
  private String nominativo;
  private int tutoruniveristarioUtenteIdUtente;
  private int tutoraziendaleUtenteIdUtente;
  
  public int getTutoraziendale_utente_idUtente() {
    return tutoraziendaleUtenteIdUtente;
  }
  
  public void setTutoraziendale_utente_idUtente(int tutoraziendaleUtenteIdUtente) {
    this.tutoraziendaleUtenteIdUtente = tutoraziendaleUtenteIdUtente;
  }
  
  public int getTutoruniveristario_utente_idUtente() {
    return tutoruniveristarioUtenteIdUtente;
  }
  
  public void setTutoruniveristario_utente_idUtente(int tutoruniveristarioUtenteIdUtente) {
    this.tutoruniveristarioUtenteIdUtente = tutoruniveristarioUtenteIdUtente;
  }
  
  public AssociazioneTuTa(int tutoraziendaleUtenteIdUtente,
      int tutoruniveristarioUtenteIdUtente) {
    this.tutoraziendaleUtenteIdUtente = tutoraziendaleUtenteIdUtente;
    this.tutoruniveristarioUtenteIdUtente = tutoruniveristarioUtenteIdUtente;
  }
  
  public AssociazioneTuTa() {}
  
  public String getNomeazienda() {
    return nomeazienda;
  }
  
  public void setNomeazienda(String nomeazienda) {
    this.nomeazienda = nomeazienda;
  }
  
  public String getNominativo() {
    return nominativo;
  }
  
  public void setNominativo(String nominativo) {
    this.nominativo = nominativo;
  }
}
