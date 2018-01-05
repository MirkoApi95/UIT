<<<<<<< HEAD
package entity;

public class Associazionetu_ta
{
	private int tutoraziendale_utente_idUtente;
	private String nomeazienda;
	private String nominativo;
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
	public Associazionetu_ta(int tutoraziendale_utente_idUtente, int tutoruniveristario_utente_idUtente) {
		super();
		this.tutoraziendale_utente_idUtente = tutoraziendale_utente_idUtente;
		this.tutoruniveristario_utente_idUtente = tutoruniveristario_utente_idUtente;
	}
	public Associazionetu_ta() {}
	public String getNomeazienda() {
		return nomeazienda;
	}
	public void setNomeazienda(String nomeazienda) {
		this.nomeazienda = nomeazienda;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
}
=======
package entity;

public class Associazionetu_ta
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
	public Associazionetu_ta(int tutoraziendale_utente_idUtente, int tutoruniveristario_utente_idUtente) {
		super();
		this.tutoraziendale_utente_idUtente = tutoraziendale_utente_idUtente;
		this.tutoruniveristario_utente_idUtente = tutoruniveristario_utente_idUtente;
	}
}
>>>>>>> 5d43d8a470fc83bca8596d39815be94869dea29d
