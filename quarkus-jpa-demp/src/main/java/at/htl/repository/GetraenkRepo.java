package at.htl.repository;

import at.htl.entity.Getraenk;
import at.htl.entity.MAType;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class GetraenkRepo {

  private final EntityManager entityManager;

  public GetraenkRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Getraenk getGetraenkeById(int id) {
    var query = entityManager.createQuery("Select g from Getraenk g where g.id = :id", Getraenk.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addGetraenke(Getraenk getraenk) {
    entityManager.persist(getraenk);
  }

  public void updateGetraenke(Getraenk getraenk) {
    entityManager.merge(getraenk);
  }

  public Getraenk add(String name, Long preis, Long menge, Boolean eiswuerfel) {
    Getraenk getraenk = new Getraenk();
    getraenk.setName(name);
    getraenk.setPreis(preis);
    getraenk.setMenge(menge);
    getraenk.setEiswuerfel(eiswuerfel);
    entityManager.persist(getraenk);
    return getraenk;
  }

  public List<Getraenk> getAllGetraenke() {
    var query = entityManager.createQuery("Select g from Getraenk g", Getraenk.class);
    return query.getResultList();
  }

}
