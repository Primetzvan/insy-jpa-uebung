package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "artikel_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Artikel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer id;
  @Column
  public String name;
  @Column
  public Long preis;

  @OneToMany(mappedBy = "artikel")
  private List<Bestellliste> bestelllist = new ArrayList<Bestellliste>();

  public Artikel(String name, Long preis) {
    this.name = name;
    this.preis = preis;
  }

  public Artikel() {

  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPreis() {
    return preis;
  }

  public void setPreis(Long preis) {
    this.preis = preis;
  }
}
