package entity;

public class Tirocinante extends Utente {

	private int matricola;
	private int numeroCFU;
	private int id;

	public Tirocinante(String nome, String cognome, String email, String password, String indirizzo,int matricola, int numeroCFU){
		super();
		this.matricola=matricola;
		this.numeroCFU=numeroCFU;

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

	public int getNumeroCFU() {
		return numeroCFU;
	}

	public void setNumeroCFU(int numeroCFU) {
		this.numeroCFU = numeroCFU;
	}

}
