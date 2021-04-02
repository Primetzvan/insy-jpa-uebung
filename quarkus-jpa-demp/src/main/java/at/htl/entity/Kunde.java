package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kunde {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  @Column
  public String firstname;
  @Column
  public String lastname;
  @Column
  public int age;


  @OneToMany(mappedBy = "id.kunde", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private List<Reservierung> reservierungList = new ArrayList<>();

  public Kunde(String firstname, String lastname, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
  }

  public Kunde() {

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Kunde{" +
      "id=" + id +
      ", name='" + firstname + '\'' +
      '}';
  }

  public void addReservierungen(Tisch tisch){
    var rid = new ReservierungKey();
    rid.setKunde(this);
    rid.setTisch(tisch);
    var r = new Reservierung();
    r.setId(rid);
    this.reservierungList.add(r);
  }

}
