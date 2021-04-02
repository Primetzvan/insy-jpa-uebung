package at.htl.repository;

import at.htl.entity.Bestellliste;

public class BestellJoin {

  public Integer bestellisteId;
  public Integer bestellungId;

  public BestellJoin(Integer bestellisteId, Integer bestellungId) {
    this.bestellisteId = bestellisteId;
    this.bestellungId = bestellungId;
  }

  public BestellJoin() {
  }

  public Integer getBestellisteId() {
    return bestellisteId;
  }

  public void setBestellisteId(Integer bestellisteId) {
    this.bestellisteId = bestellisteId;
  }

  public Integer getBestellungId() {
    return bestellungId;
  }

  public void setBestellungId(Integer bestellungId) {
    this.bestellungId = bestellungId;
  }
}
