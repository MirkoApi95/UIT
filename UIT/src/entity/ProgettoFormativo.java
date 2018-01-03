package entity;

public class ProgettoFormativo 
{
	private int id_ProgettoFormativo;
	private int TutorAziendale_Utente_idUtente;
	private int TutorUniversitario_Utente_idUtente;
	private int Tirocinante_Utente_idUtente;
	private int DirettoreDipartimento_Utente_idUtente;
	private boolean convalidaDD;
	private boolean convalidaTU;
	private String Obiettivi;

	public ProgettoFormativo(
			int id,
			Boolean ConvalidaDD , 
			Boolean ConvalidaTU,
			String obiettivi,
			int tutorAziendale_Utente_idUtente,
			int tutorUniversitario_Utente_idUtente, 
			int tirocinante_Utente_idUtente,
			int direttoreDipartimento_idDirettoreDipartimento){
		TutorAziendale_Utente_idUtente = tutorAziendale_Utente_idUtente;
		TutorUniversitario_Utente_idUtente = tutorUniversitario_Utente_idUtente;
		Tirocinante_Utente_idUtente = tirocinante_Utente_idUtente;
		DirettoreDipartimento_Utente_idUtente = direttoreDipartimento_idDirettoreDipartimento;
		this.convalidaDD = ConvalidaDD;
		this.convalidaTU = ConvalidaTU;
		Obiettivi = obiettivi;
		this.id_ProgettoFormativo=id;
	}
	
	public ProgettoFormativo(Boolean ConvalidaDD , 
			Boolean ConvalidaTU,
			String obiettivi,
			int tutorAziendale_Utente_idUtente,
			int tutorUniversitario_Utente_idUtente, 
			int tirocinante_Utente_idUtente,
			int direttoreDipartimento_idDirettoreDipartimento			
			){
		TutorAziendale_Utente_idUtente = tutorAziendale_Utente_idUtente;
		TutorUniversitario_Utente_idUtente = tutorUniversitario_Utente_idUtente;
		Tirocinante_Utente_idUtente = tirocinante_Utente_idUtente;
		DirettoreDipartimento_Utente_idUtente = direttoreDipartimento_idDirettoreDipartimento;
		this.convalidaDD = ConvalidaDD;
		this.convalidaTU = ConvalidaTU;
		Obiettivi = obiettivi;

	}
	public ProgettoFormativo() {}

	public int getId_progetto() {
		return id_ProgettoFormativo;
	}

	public void setId_progetto(int id) {
		this.id_ProgettoFormativo = id;
	}

	public int getTutorAziendale_Utente_idUtente() {
		return TutorAziendale_Utente_idUtente;
	}

	public void setTutorAziendale_Utente_idUtente(int tutorAziendale_Utente_idUtente) {
		TutorAziendale_Utente_idUtente = tutorAziendale_Utente_idUtente;
	}

	public int getTutorUniversitario_Utente_idUtente() {
		return TutorUniversitario_Utente_idUtente;
	}

	public void setTutorUniversitario_Utente_idUtente(int tutorUniversitario_Utente_idUtente) {
		TutorUniversitario_Utente_idUtente = tutorUniversitario_Utente_idUtente;
	}

	public int getTirocinante_Utente_idUtente() {
		return Tirocinante_Utente_idUtente;
	}

	public void setTirocinante_Utente_idUtente(int tirocinante_Utente_idUtente) {
		Tirocinante_Utente_idUtente = tirocinante_Utente_idUtente;
	}

	public int getDirettoreDipartimento_idDirettoreDipartimento(){
		return DirettoreDipartimento_Utente_idUtente;
	}

	public void setDirettoreDipartimento_idDirettoreDipartimento(int direttoreDipartimento_idDirettoreDipartimento) {
		DirettoreDipartimento_Utente_idUtente = direttoreDipartimento_idDirettoreDipartimento;
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
