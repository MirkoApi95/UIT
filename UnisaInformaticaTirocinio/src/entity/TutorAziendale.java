package entity;

public class TutorAziendale extends Utente{

	private int identificativo;
	
	public TutorAziendale(String nome, String cognome, String email, String password, String indirizzo, int identificativo) {
		super(nome, cognome, email, password, indirizzo);
		this.identificativo=identificativo;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

}
