package at.htl.repository;

import at.htl.entity.*;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class MitarbeiterRepo {

  private final EntityManager entityManager;

  public MitarbeiterRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Mitarbeiter getMitarbeiterById(int id) {
    var query = entityManager.createQuery("Select m from Mitarbeiter m where m.id = :id", Mitarbeiter.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addMitarbeiter(Mitarbeiter mitarbeiter) {
    entityManager.persist(mitarbeiter);
  }

  public void updateMitarbeiter(Mitarbeiter mitarbeiter) {
    entityManager.merge(mitarbeiter);
  }

  public List<Mitarbeiter> getAllMitarbeiter() {
    var query = entityManager.createQuery("Select m from Mitarbeiter m",Mitarbeiter.class);
    return query.getResultList();
  }

  public List<Double> getAllKoeche() {
    var query = entityManager.createQuery("Select avg(m.age) from Mitarbeiter m group by m.type",Double.class);
    return query.getResultList();
  }

}
