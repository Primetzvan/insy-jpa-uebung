package at.htl.repository;

import at.htl.entity.Tisch;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class TischRepo {

  private final EntityManager entityManager;

  public TischRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Tisch getTischById(int id) {
    var query = entityManager.createQuery("Select t from Tisch t where t.id = :id", Tisch.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addTisch(Tisch tisch) {
    entityManager.persist(tisch);
  }

  public void updateTisch(Tisch tisch) {
    entityManager.merge(tisch);
  }

  public List<Tisch> getAllTIsch() {
    var query = entityManager.createQuery("Select t from Tisch t",Tisch.class);
    return query.getResultList();
  }

}
