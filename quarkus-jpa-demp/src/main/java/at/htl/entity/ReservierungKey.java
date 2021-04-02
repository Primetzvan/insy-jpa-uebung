package at.htl.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservierungKey implements Serializable {

  //@JsonbTransient
  @ManyToOne
  //@MapsId("kunde_id")
  @JoinColumn(name = "kunde_id")
  public Kunde kunde;

  @ManyToOne
  //@MapsId("tisch_id")
  @JoinColumn(name = "tisch_id")
  public Tisch tisch;

  public Kunde getKunde() {
    return kunde;
  }

  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
  }

  public Tisch getTisch() {
    return tisch;
  }

  public void setTisch(Tisch tisch) {
    this.tisch = tisch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReservierungKey that = (ReservierungKey) o;
    return Objects.equals(kunde, that.kunde) && Objects.equals(tisch, that.tisch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kunde, tisch);
  }
}
