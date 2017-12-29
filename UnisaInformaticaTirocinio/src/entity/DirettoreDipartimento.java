package entity;

public class DirettoreDipartimento extends Utente{

	private int identificativo;
	
	public DirettoreDipartimento(String nome, String cognome, String email, String password, String indirizzo, int identificativo) {
		super(nome, cognome, email, password, indirizzo);
		this.setIdentificativo(identificativo);
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

}
