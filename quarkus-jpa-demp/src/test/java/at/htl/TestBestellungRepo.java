package at.htl;

import at.htl.entity.*;
import at.htl.repository.BestellungRepo;
import at.htl.repository.MitarbeiterRepo;
import at.htl.repository.SpeisseRepo;
import at.htl.repository.TischRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


@QuarkusTest
public class TestBestellungRepo {

  @Inject
  private BestellungRepo bestellungRepo;
  @Inject
  private MitarbeiterRepo mitarbeiterRepo;
  @Inject
  private TischRepo tischRepo;
  @Inject
  private SpeisseRepo speisseRepo;

  @Test
  public void addBestellung(){

    var mitarbeiter = new Mitarbeiter("leo", "neu", MAType.Kellner,22);
    mitarbeiterRepo.addMitarbeiter(mitarbeiter);
    var tisch = new Tisch(4);
    tischRepo.addTisch(tisch);

    var bestellung = new Bestellung();
    bestellung.setMitarbeiter(mitarbeiter);
    bestellung.setTisch(tisch);

    assertThatCode(()->bestellungRepo.addBestellung(bestellung)).doesNotThrowAnyException();

    var loadedBestellung = bestellungRepo.getBestellungById(bestellung.getId());

    assertThat(loadedBestellung.getMitarbeiter().getFirstname()).isNotNull().isEqualTo(bestellung.getMitarbeiter().getFirstname());

  }

  @Test
  public void getBestellung_notExists(){
    var id = 3;

    AtomicReference<Bestellung> loadedBestellung = new AtomicReference<>();
    assertThatCode(()->{
      loadedBestellung.set(bestellungRepo.getBestellungById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedBestellung.get()).isNull();
  }

  @Test
  public void updateBestellung(){
    var mitarbeiter = new Mitarbeiter("leo", "neu", MAType.Kellner,22);
    mitarbeiterRepo.addMitarbeiter(mitarbeiter);
    var tisch = new Tisch(4);
    tischRepo.addTisch(tisch);

    var bestellung = new Bestellung();
    bestellung.setMitarbeiter(mitarbeiter);
    bestellung.setTisch(tisch);

    bestellungRepo.addBestellung(bestellung);

    var loadedBestellung = bestellungRepo.getBestellungById(bestellung.getId());

    //tischupadte
    tisch.setPlaetze(2);
    tischRepo.updateTisch(tisch);

    loadedBestellung.setTisch(tisch);

    bestellungRepo.updateBestellung(loadedBestellung);

    assertThat(loadedBestellung.getTisch().getPlaetze()).isNotNull().isEqualTo(2);

  }



  @Test
  public void testJoin(){

    var mitarbeiter = new Mitarbeiter("leo", "neu", MAType.Kellner,20);
    mitarbeiterRepo.addMitarbeiter(mitarbeiter);
    var tisch = new Tisch(4);
    tischRepo.addTisch(tisch);

    var tisch2 = new Tisch(2);
    tischRepo.addTisch(tisch2);

    var bestellung = new Bestellung();
    bestellung.setMitarbeiter(mitarbeiter);
    bestellung.setTisch(tisch);

    var bestellung2 = new Bestellung();
    bestellung2.setMitarbeiter(mitarbeiter);
    bestellung2.setTisch(tisch2);

    bestellungRepo.addBestellung(bestellung);
    bestellungRepo.addBestellung(bestellung2);

    var speisse = new Speisse("Hotdog", 12L, 12L, false);
    speisseRepo.addSpeisse(speisse);

    var bestellliste = new Bestellliste(bestellung, mitarbeiter, speisse);
    var bestellliste2 = new Bestellliste(bestellung2, mitarbeiter, speisse);



    bestellungRepo.createBestelliste(bestellliste, bestellung.getId());
    bestellungRepo.createBestelliste(bestellliste2, bestellung2.getId());

  }

}
