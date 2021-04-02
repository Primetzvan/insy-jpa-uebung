package at.htl.entity;

import javax.persistence.*;

@Entity
public class Bestellliste {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @ManyToOne
  @JoinColumn(name = "bestellung_id")
  public Bestellung bestellung;

  @ManyToOne
  @JoinColumn(name = "mitarbeiter_id")
  public Mitarbeiter mitarbeiter;

  @ManyToOne
  @JoinColumn(name = "artikel_id")
  public Artikel artikel;

  public Bestellliste(Bestellung bestellung, Mitarbeiter mitarbeiter, Artikel artikel) {
    this.bestellung = bestellung;
    this.mitarbeiter = mitarbeiter;
    this.artikel = artikel;
  }

  public Bestellliste() {

  }

  public Bestellung getBestellung() {
    return bestellung;
  }

  public void setBestellung(Bestellung bestellung) {
    this.bestellung = bestellung;
  }

  public Mitarbeiter getMitarbeiter() {
    return mitarbeiter;
  }

  public void setMitarbeiter(Mitarbeiter mitarbeiter) {
    this.mitarbeiter = mitarbeiter;
  }

  public Artikel getArtikel() {
    return artikel;
  }

  public void setArtikel(Artikel artikel) {
    this.artikel = artikel;
  }

  @Override
  public String toString() {
    return "Bestellliste{" +
      "id=" + id +
      ", bestellung=" + bestellung +
      ", mitarbeiter=" + mitarbeiter +
      ", artikel=" + artikel +
      '}';
  }
}
