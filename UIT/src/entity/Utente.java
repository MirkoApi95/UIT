package entity;

public class Utente
{
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String indirizzo;
	
	public Utente(String nome, String cognome, String email, String password, String indirizzo,int id) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.id=id;
	}
	
	public Utente(String nome, String cognome, String email, String password, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
	}
	
	public Utente()
	{	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}