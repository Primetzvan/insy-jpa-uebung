package at.htl.repository;

import at.htl.entity.Bestellliste;

public class BestellungBestellliste {

  public Bestellliste bestelliste;
  public Integer bid;

  public BestellungBestellliste(Bestellliste bestelliste, Integer bestllungID) {
    this.bestelliste = bestelliste;
    this.bid = bestllungID;
  }

  public BestellungBestellliste() {
  }

  public Bestellliste getBestelliste() {
    return bestelliste;
  }

  public void setBestelliste(Bestellliste bestelliste) {
    this.bestelliste = bestelliste;
  }

  public Integer getBid() {
    return bid;
  }

  public void setBid(Integer bid) {
    this.bid = bid;
  }
}
