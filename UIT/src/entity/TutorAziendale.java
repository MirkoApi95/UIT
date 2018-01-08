package entity;

public class TutorAziendale extends Utente {

  private String nomeazienda;
  private String sede;
  
  public TutorAziendale(String nomeazienda,String sede,String nome,
      String cognome, String email, String password, String indirizzo) {
    super.setNome(nome);
    super.setCognome(cognome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }

  public TutorAziendale() {
  }

  public String getNomeazienda() {
    return nomeazienda;
  }
  
  public void setNomeazienda(String nomeazienda) {
    this.nomeazienda = nomeazienda;
  }
  
  public String getSede() {
    return sede;
  }
  
  public void setSede(String sede) {
    this.sede = sede;
  }
}