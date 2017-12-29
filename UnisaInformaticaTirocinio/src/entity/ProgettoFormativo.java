package entity;

public class ProgettoFormativo 
{
	private long id_progetto;								//long o id autogenerato//da correggere
	private String TutorAziendale_Utente_idUtente;
	private String TutorUniversitario_Utente_idUtente;
	private String Tirocinante_Utente_idUtente;
	private String DirettoreDipartimento_idDirettoreDipartimento;
	private boolean convalidaDD;
	private boolean convalidaTU;
	private String Obiettivi;
	
	public ProgettoFormativo(long id_progetto, String tutorAziendale_Utente_idUtente,
			String tutorUniversitario_Utente_idUtente, String tirocinante_Utente_idUtente,
			String direttoreDipartimento_idDirettoreDipartimento, Boolean ConvalidaDD , Boolean ConvalidaTU,
			String obiettivi) {
		super();
		this.id_progetto = id_progetto;
		TutorAziendale_Utente_idUtente = tutorAziendale_Utente_idUtente;
		TutorUniversitario_Utente_idUtente = tutorUniversitario_Utente_idUtente;
		Tirocinante_Utente_idUtente = tirocinante_Utente_idUtente;
		DirettoreDipartimento_idDirettoreDipartimento = direttoreDipartimento_idDirettoreDipartimento;
		this.convalidaDD = ConvalidaDD;
		this.convalidaTU = ConvalidaTU;
		Obiettivi = obiettivi;
		
	}
	
	public ProgettoFormativo() {
		
	}

	public long getId_progetto() {
		return id_progetto;
	}

	public void setId_progetto(long id) {
		this.id_progetto = id;
	}

	public String getTutorAziendale_Utente_idUtente() {
		return TutorAziendale_Utente_idUtente;
	}

	public void setTutorAziendale_Utente_idUtente(String tutorAziendale_Utente_idUtente) {
		TutorAziendale_Utente_idUtente = tutorAziendale_Utente_idUtente;
	}

	public String getTutorUniversitario_Utente_idUtente() {
		return TutorUniversitario_Utente_idUtente;
	}

	public void setTutorUniversitario_Utente_idUtente(String tutorUniversitario_Utente_idUtente) {
		TutorUniversitario_Utente_idUtente = tutorUniversitario_Utente_idUtente;
	}

	public String getTirocinante_Utente_idUtente() {
		return Tirocinante_Utente_idUtente;
	}

	public void setTirocinante_Utente_idUtente(String tirocinante_Utente_idUtente) {
		Tirocinante_Utente_idUtente = tirocinante_Utente_idUtente;
	}

	public String getDirettoreDipartimento_idDirettoreDipartimento() {
		return DirettoreDipartimento_idDirettoreDipartimento;
	}

	public void setDirettoreDipartimento_idDirettoreDipartimento(String direttoreDipartimento_idDirettoreDipartimento) {
		DirettoreDipartimento_idDirettoreDipartimento = direttoreDipartimento_idDirettoreDipartimento;
	}

	public boolean getConvalidaDD() {
		return convalidaDD;
	}

	public void setConvalidaDD(boolean convalidaDD) {
		this.convalidaDD = convalidaDD;
	}

	public boolean getConvalidaTU() {
		return convalidaTU;
	}

	public void setConvalidaTU(boolean convalidaTU) {
		this.convalidaTU = convalidaTU;
	}

	public String getObiettivi() {
		return Obiettivi;
	}

	public void setObiettivi(String obiettivi) {
		Obiettivi = obiettivi;
	}
	
}
