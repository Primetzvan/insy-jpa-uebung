package at.htl;

import at.htl.entity.Kunde;
import at.htl.entity.Speisse;
import at.htl.repository.KundeRepo;
import at.htl.repository.SpeisseRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class TestKundeRepo {

  @Inject
  private KundeRepo kundeRepo;

  @Test
  public void addKunde(){
    var kunde = new Kunde();
    kunde.setFirstname("Hans");
    kunde.setLastname("Müller");
    kunde.setAge(60);

    assertThatCode(()->kundeRepo.addKunde(kunde)).doesNotThrowAnyException();

    var loadedKunde = kundeRepo.getKundeById(kunde.getId());

    assertThat(loadedKunde.getFirstname()).isNotNull().isEqualTo(kunde.getFirstname());

  }

  @Test
  public void getKunde_notExists(){
    var id = 3;

    AtomicReference<Kunde> loadedKunde = new AtomicReference<>();
    assertThatCode(()->{
      loadedKunde.set(kundeRepo.getKundeById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedKunde.get()).isNull();
  }

}
