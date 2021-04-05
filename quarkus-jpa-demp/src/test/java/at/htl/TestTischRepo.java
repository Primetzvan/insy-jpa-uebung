package at.htl;

import at.htl.entity.MAType;
import at.htl.entity.Mitarbeiter;
import at.htl.entity.Tisch;
import at.htl.repository.TischRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class TestTischRepo {

  @Inject
  private TischRepo tischRepo;

  @Test
  public void addTisch(){
    var tisch = new Tisch();
    tisch.setPlaetze(4);

    assertThatCode(()-> tischRepo.addTisch(tisch)).doesNotThrowAnyException();

    var loadedTisch = tischRepo.getTischById(tisch.getId());

    assertThat(loadedTisch.getPlaetze()).isNotNull().isEqualTo(tisch.getPlaetze());

  }

  @Test
  public void updateTisch(){
    var tisch = new Tisch();
    tisch.setPlaetze(4);

    tischRepo.addTisch(tisch);

    tisch.setPlaetze(2);

    tischRepo.updateTisch(tisch);

    var loadedTisch = tischRepo.getTischById(tisch.getId());

    assertThat(loadedTisch.getPlaetze()).isNotNull().isEqualTo(2);

  }

  @Test
  public void getTisch_notExists(){
    var id = 3;

    AtomicReference<Tisch> loadedTisch = new AtomicReference<>();
    assertThatCode(()->{
      loadedTisch.set(tischRepo.getTischById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedTisch.get()).isNull();
  }

}
