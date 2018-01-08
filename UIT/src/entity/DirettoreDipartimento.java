package entity;

public class DirettoreDipartimento extends Utente{
  public DirettoreDipartimento(String nome, String cognome, String email, String password, String indirizzo, int identificativo) {
    super.setCognome(cognome);
    super.setNome(nome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }
}
