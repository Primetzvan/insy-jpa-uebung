package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mitarbeiter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  @Column
  public String firstname;
  @Column
  public String lastname;
  @Enumerated(EnumType.ORDINAL)
  private MAType type;
  @Column
  private int age;

  @OneToMany(mappedBy = "mitarbeiter")
  private List<Bestellliste> bestelllist = new ArrayList<Bestellliste>();

  @OneToMany(mappedBy = "mitarbeiter")
  private List<Bestellung> bestellungList = new ArrayList<Bestellung>();

  public Mitarbeiter(String name, String lastname, MAType type, int age) {
    this.firstname = name;
    this.lastname = lastname;
    this.type = type;
    this.age = age;
  }

  public Mitarbeiter() {

  }

  public Integer getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String name) {
    this.firstname = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public MAType getType() {
    return type;
  }

  public void setType(MAType type) {
    this.type = type;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Mitarbeiter{" +
      "id=" + id +
      ", name='" + firstname + '\'' +
      ", type=" + type +
      '}';
  }
}
