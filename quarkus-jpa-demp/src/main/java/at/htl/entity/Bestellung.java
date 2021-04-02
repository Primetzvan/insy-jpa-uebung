package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestellung {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @ManyToOne
  @JoinColumn(name = "mitarbeiter_id")
  public Mitarbeiter mitarbeiter;

  @ManyToOne
  @JoinColumn(name = "tisch_id")
  public Tisch tisch;

  @OneToMany(mappedBy = "bestellung")
  private List<Bestellliste> bestelllist = new ArrayList<Bestellliste>();

  public Bestellung(Mitarbeiter mitarbeiter, Tisch tisch) {
    this.mitarbeiter = mitarbeiter;
    this.tisch = tisch;
  }

  public Bestellung() {

  }

  public Integer getId() {
    return id;
  }

  public Mitarbeiter getMitarbeiter() {
    return mitarbeiter;
  }

  public void setMitarbeiter(Mitarbeiter mitarbeiter) {
    this.mitarbeiter = mitarbeiter;
  }

  public Tisch getTisch() {
    return tisch;
  }

  public void setTisch(Tisch tisch) {
    this.tisch = tisch;
  }

  @Override
  public String toString() {
    return "Bestellung{" +
      "id=" + id +
      ", mitarbeiter=" + mitarbeiter +
      ", tisch=" + tisch +
      '}';
  }

  public void addBestelllisten(Mitarbeiter mitarbeiter, Artikel artikel){
    var bestellli = new Bestellliste(this, mitarbeiter, artikel);
    this.bestelllist.add(bestellli);
  }

}
