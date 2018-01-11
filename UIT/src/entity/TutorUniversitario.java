/**
 * pakckage entity rappresentano le entità del database UIT 
 */
package entity;
/**
 * Classe che rappresenta il TutorUniversitario nel database UIT
 * @author Mirko
 *
 */
public class TutorUniversitario extends Utente {
/**
 * Costruttore della classe
 * @param nome contiene una stringa con il nome del tutor universitario
 * @param cognome contiene una stringa con il cognome del tutor universitario
 * @param email contiene una stringa con l'email del tutor universitario
 * @param password contiene una stringa con la password del tutor universitario
 * @param indirizzo contiene una stringa con l'indirizzo del tutor universitario
 */
  public TutorUniversitario(String nome,String cognome, String email,
      String password, String indirizzo) {
    super.setCognome(cognome);
    super.setNome(nome);
    super.setEmail(email);
    super.setPassword(password);
    super.setIndirizzo(indirizzo);
  }
}