package entity;

public class Tirocinante extends Utente {
	
	private long matricola;
	private int numeroCFU;

	public Tirocinante(String nome, String cognome, String email, String password, String indirizzo, long matricola, int numeroCFU){
		super(nome, cognome, email, password, indirizzo);
		this.matricola=matricola;
		this.numeroCFU=numeroCFU;
	}

	public long getMatricola() {
		return matricola;
	}

	public void setMatricola(long matricola) {
		this.matricola = matricola;
	}

	public int getNumeroCFU() {
		return numeroCFU;
	}

	public void setNumeroCFU(int numeroCFU) {
		this.numeroCFU = numeroCFU;
	}

}
