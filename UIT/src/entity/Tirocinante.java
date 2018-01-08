package entity;

public class Tirocinante extends Utente {

  private int matricola;
  private int numeroCfu;
  private int id;

  public Tirocinante(String nome, String cognome, String email, String password,
      String indirizzo,int matricola, int numeroCfu) {
    super();
    this.matricola = matricola;
    this.numeroCfu = numeroCfu;
  }

  public int getId() {
    return id;
  }


  public int getMatricola() {
    return matricola;
  }

  public void setMatricola(int matricola) {
    this.matricola = matricola;
  }

  public int getNumeroCfu() {
    return numeroCfu;
  }

  public void setNumeroCfu(int numeroCfu) {
    this.numeroCfu = numeroCfu;
  }
}