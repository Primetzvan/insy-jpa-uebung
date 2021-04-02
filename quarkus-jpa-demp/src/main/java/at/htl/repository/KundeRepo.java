package at.htl.repository;

import at.htl.entity.Kunde;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class KundeRepo {

  private final EntityManager entityManager;

  public KundeRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Kunde getKundeById(int id){
    var query = entityManager.createQuery("Select k from Kunde k where k.id = :id", Kunde.class);
    query.setParameter("id",id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addKunde(Kunde kunde){
    entityManager.persist(kunde);
  }

  public Kunde add(String firstname, String lastname,int age){
    Kunde kunde = new Kunde();
    kunde.setFirstname(firstname);
    kunde.setLastname(lastname);
    kunde.setAge(age);
    entityManager.persist(kunde);
    return kunde;
  }

  public void update(Kunde kunde){
    entityManager.merge(kunde);
  }

  public List<Kunde> getAllKunden(){
    var query = entityManager.createQuery("Select k from Kunde k",Kunde.class);
    return query.getResultList();
  }

}
