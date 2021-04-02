package at.htl.entity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
//@DiscriminatorValue("speissen")
//@PrimaryKeyJoinColumn(columnDefinition = "artikel_id")
public class Speisse extends Artikel{

  @Column
  public Long gewicht;
  @Column
  public Boolean salat;

  public Speisse(String name, Long preis, Long gewicht, Boolean salat) {
    super(name, preis);
    this.gewicht = gewicht;
    this.salat = salat;
  }

  public Speisse() {

  }

  public Long getGewicht() {
    return gewicht;
  }

  public void setGewicht(Long gewicht) {
    this.gewicht = gewicht;
  }

  public Boolean getSalat() {
    return salat;
  }

  public void setSalat(Boolean salat) {
    this.salat = salat;
  }
}
