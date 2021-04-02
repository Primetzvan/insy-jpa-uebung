package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tisch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @Column
  public int plaetze;

  @OneToMany(mappedBy = "tisch")
  private List<Bestellung> bestellungList = new ArrayList<Bestellung>();

  @OneToMany(mappedBy = "id.tisch")
  private List<Reservierung> reservierungList = new ArrayList<Reservierung>();

  public Tisch(int plaetze) {
    this.plaetze = plaetze;
  }

  public Tisch() {

  }

  public Integer getId() {
    return id;
  }

  public int getPlaetze() {
    return plaetze;
  }

  public void setPlaetze(int plaetze) {
    this.plaetze = plaetze;
  }

  @Override
  public String toString() {
    return "Tisch{" +
      "id=" + id +
      '}';
  }
}
