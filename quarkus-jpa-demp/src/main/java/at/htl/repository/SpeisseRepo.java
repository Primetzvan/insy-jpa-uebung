package at.htl.repository;

import at.htl.entity.MAType;
import at.htl.entity.Mitarbeiter;
import at.htl.entity.Speisse;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class SpeisseRepo {

  private final EntityManager entityManager;

  public SpeisseRepo(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Speisse getSpeisseById(int id) {
    var query = entityManager.createQuery("Select s from Speisse s where s.id = :id", Speisse.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public void addSpeisse(Speisse speisse) {
    entityManager.persist(speisse);
  }

  public void updateSpeisse(Speisse speisse) {
    entityManager.merge(speisse);
  }

  public Speisse add(String name, Long preis, Long gewicht, Boolean salat) {
    Speisse speisse = new Speisse();
    speisse.setName(name);
    speisse.setPreis(preis);
    speisse.setGewicht(gewicht);
    speisse.setSalat(salat);
    entityManager.persist(speisse);
    return speisse;
  }

  public List<Speisse> getAllSpeissen() {
    var query = entityManager.createQuery("Select s from Speisse s",Speisse.class);
    return query.getResultList();
  }

}
