/**
 * pakckage entity rappresentano le entità del database UIT 
 */

package entity;

import java.util.List;

/**
 * @author Salvatore Mirko Apicella
 * Clesse che rappesenta l'entità nel database UIT AssociazioneTU_TA, serve per collegare i professori alle aziende
 * viene utilizzata durante la scelta dell'azienda con un possibile tutor universitario
 */

public class AssociazioneTuTa {

  private TutorAziendale ta;
  private List<TutorUniversitario> listaTU;

  public void addTa(TutorAziendale ta) {
    this.ta=ta;
  }
  
  public void addListTu(List<TutorUniversitario> listadiTU) {
    this.listaTU = listadiTU;
  }

  public List<TutorUniversitario> getListaTU() {
    return listaTU;
  }
  public TutorAziendale getTa() {
    return ta;
  }
}
