package at.htl;

import at.htl.entity.MAType;
import at.htl.entity.Mitarbeiter;
import at.htl.entity.Speisse;
import at.htl.repository.MitarbeiterRepo;
import at.htl.repository.SpeisseRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class TestMitarbeiterRepo {

  @Inject
  private MitarbeiterRepo mitarbeiterRepo;

  @Test
  public void addMitarbeiter(){
    var mitarbeiter = new Mitarbeiter();
    mitarbeiter.setFirstname("Werner");
    mitarbeiter.setLastname("Werner");
    mitarbeiter.setType(MAType.Kellner);

    assertThatCode(()->mitarbeiterRepo.addMitarbeiter(mitarbeiter)).doesNotThrowAnyException();

    var loadedMitarbeiter = mitarbeiterRepo.getMitarbeiterById(mitarbeiter.getId());

    assertThat(loadedMitarbeiter.getFirstname()).isNotNull().isEqualTo(mitarbeiter.getFirstname());

  }


  @Test
  public void updateMitarbeiter(){
    var mitarbeiter = new Mitarbeiter();
    mitarbeiter.setFirstname("Werner");
    mitarbeiter.setLastname("Werner");
    mitarbeiter.setType(MAType.Kellner);

    mitarbeiterRepo.addMitarbeiter(mitarbeiter);

    mitarbeiter.setType(MAType.Koch);

    mitarbeiterRepo.updateMitarbeiter(mitarbeiter);

    var loadedMitarbeiter = mitarbeiterRepo.getMitarbeiterById(mitarbeiter.getId());

    assertThat(loadedMitarbeiter.getType()).isNotNull().isEqualTo(MAType.Koch);

  }

  @Test
  public void getSpeisse_notExists(){
    var id = 3;

    AtomicReference<Mitarbeiter> loadedMitarbeiter = new AtomicReference<>();
    assertThatCode(()->{
      loadedMitarbeiter.set(mitarbeiterRepo.getMitarbeiterById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedMitarbeiter.get()).isNull();
  }

}
