package entity;

public class TutorUniversitario extends Utente {

  public TutorUniversitario(String nome,String cognome, String email,
      String password, String indirizzo) {
    super.setCognome(cognome);
    super.setNome(nome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }
}