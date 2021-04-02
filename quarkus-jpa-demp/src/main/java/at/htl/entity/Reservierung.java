package at.htl.entity;
import javax.persistence.*;

@Entity
public class Reservierung {

  @EmbeddedId
  private ReservierungKey id;

  public ReservierungKey getId() {
    return id;
  }

  public void setId(ReservierungKey id) {
    this.id = id;
  }

}

  //  private Integer kundeId;
//  private Integer tischhId;
//
//  public Reservierung(Integer kundeId, Integer tischhId) {
//    this.kundeId = kundeId;
//    this.tischhId = tischhId;
//  }

//  public Kunde getKunde() {
//    return kunde;
//  }
//
//  public void setKunde(Kunde kunde) {
//    this.kunde = kunde;
//  }
//
//  public Tisch getTisch() {
//    return tisch;
//  }
//
//  public void setTisch(Tisch tisch) {
//    this.tisch = tisch;
//  }


