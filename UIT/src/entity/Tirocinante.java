package entity;

public class Tirocinante extends Utente {
	private static int id_Utente;
	private long matricola;
	private int numeroCFU;
	private int id;

	public Tirocinante(String nome, String cognome, String email, String password, String indirizzo, long matricola, int numeroCFU){
		super(nome, cognome, email, password, indirizzo);
		this.matricola=matricola;
		this.numeroCFU=numeroCFU;
		id=id_Utente++;
	}

	
	
	public int getId() {
		return id;
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
