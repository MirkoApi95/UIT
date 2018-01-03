package entity;

public class TutorUniversitario extends Utente{

	private int identificativo;
	
	public TutorUniversitario(String nome, String cognome, String email, String password, String indirizzo, int identificativo) {
		super();
		this.identificativo=identificativo;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

}
