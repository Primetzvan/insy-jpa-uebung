package at.htl.entity;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("getraenke")
//@PrimaryKeyJoinColumn(columnDefinition = "getraenke_id")
public class Getraenk extends Artikel {

  @Column
  public Long menge;
  @Column
  public Boolean eiswuerfel;

  public Getraenk(String name, Long preis, Long menge, Boolean eiswuerfel) {
    super(name, preis);
    this.menge = menge;
    this.eiswuerfel = eiswuerfel;
  }

  public Getraenk() {

  }

  public Long getMenge() {
    return menge;
  }

  public void setMenge(Long menge) {
    this.menge = menge;
  }

  public Boolean getEiswuerfel() {
    return eiswuerfel;
  }

  public void setEiswuerfel(Boolean eiswuerfel) {
    this.eiswuerfel = eiswuerfel;
  }

}
