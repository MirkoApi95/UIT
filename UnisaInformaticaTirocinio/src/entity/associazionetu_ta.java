package entity;

public class associazionetu_ta
{
	private int tutoraziendale_utente_idUtente;
	private int tutoruniveristario_utente_idUtente;
	public int getTutoraziendale_utente_idUtente() {
		return tutoraziendale_utente_idUtente;
	}
	public void setTutoraziendale_utente_idUtente(int tutoraziendale_utente_idUtente) {
		this.tutoraziendale_utente_idUtente = tutoraziendale_utente_idUtente;
	}
	public int getTutoruniveristario_utente_idUtente() {
		return tutoruniveristario_utente_idUtente;
	}
	public void setTutoruniveristario_utente_idUtente(int tutoruniveristario_utente_idUtente) {
		this.tutoruniveristario_utente_idUtente = tutoruniveristario_utente_idUtente;
	}
	public associazionetu_ta(int tutoraziendale_utente_idUtente, int tutoruniveristario_utente_idUtente) {
		super();
		this.tutoraziendale_utente_idUtente = tutoraziendale_utente_idUtente;
		this.tutoruniveristario_utente_idUtente = tutoruniveristario_utente_idUtente;
	}
	//fare DAO
	
}
