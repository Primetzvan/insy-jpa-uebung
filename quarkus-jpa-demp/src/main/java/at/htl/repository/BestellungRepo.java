package at.htl.repository;

import at.htl.entity.Bestellliste;
import at.htl.entity.Bestellung;
import at.htl.entity.Mitarbeiter;
import at.htl.entity.Tisch;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class BestellungRepo {

  private final EntityManager entityManager;

  public BestellungRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Bestellung getBestellungById(int id) {
    var query = entityManager.createQuery("Select b from Bestellung b where b.id = :id", Bestellung.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addBestellung(Bestellung bestellung) {
    entityManager.persist(bestellung);
  }

  public List<Bestellung> getAllBestellung() {
    var query = entityManager.createQuery("Select b from Bestellung b",Bestellung.class);
    return query.getResultList();
  }

  //TODO: selber Fehler: could not prepare statement
  public void createBestelliste(Bestellliste liste, int id){
    System.out.println(getBestellungById(id));
      this.getBestellungById(id).addBestelllisten(liste.mitarbeiter, liste.artikel);
  }

  //TODO:TestBestellungRepo wirft fehler aber nicht im Endpoint
  public List<BestellJoin> findAllBestellungenByBestellungslistID(Integer id){
    return entityManager.createQuery("select NEW at.htl.repository.BestellJoin(b.id, b.bestellung.id) from Bestellliste b join b.bestellung c where c.id = :id",BestellJoin.class).
      setParameter("id",id).getResultList();
  }

}
