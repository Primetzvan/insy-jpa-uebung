package at.htl;

import at.htl.entity.Speisse;
import at.htl.repository.SpeisseRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicReference;

@QuarkusTest
public class TestSpeisseRepo {

  @Inject
  private SpeisseRepo speisseRepo;

  @Test
  public void addSpeisse(){
    var speisse = new Speisse();
    speisse.setName("Berner");
    speisse.setPreis(9L);
    speisse.setGewicht(1L);
    speisse.setSalat(false);

    assertThatCode(()->speisseRepo.addSpeisse(speisse)).doesNotThrowAnyException();

    var loadedSpeisse = speisseRepo.getSpeisseById(speisse.getId());

    assertThat(loadedSpeisse.getName()).isNotNull().isEqualTo(speisse.getName());

  }

  @Test
  public void updateSpeisse(){
    var speisse = new Speisse();
    speisse.setName("Berner");
    speisse.setPreis(9L);
    speisse.setGewicht(1L);
    speisse.setSalat(false);

    speisseRepo.addSpeisse(speisse);

    speisse.setSalat(true);

    speisseRepo.updateSpeisse(speisse);

    var loadedSpeisse = speisseRepo.getSpeisseById(speisse.getId());

    assertThat(loadedSpeisse.getSalat()).isNotNull().isEqualTo(true);

  }

  @Test
  public void getSpeisse_notExists(){
    var id = 3;

    AtomicReference<Speisse> loadedSpeisse = new AtomicReference<>();
    assertThatCode(()->{
      loadedSpeisse.set(speisseRepo.getSpeisseById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedSpeisse.get()).isNull();
  }


}
