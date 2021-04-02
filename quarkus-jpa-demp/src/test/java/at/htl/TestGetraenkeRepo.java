package at.htl;

import at.htl.entity.Getraenk;
import at.htl.entity.Speisse;
import at.htl.repository.GetraenkRepo;
import at.htl.repository.SpeisseRepo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class TestGetraenkeRepo {

  @Inject
  private GetraenkRepo getraenkRepo;

  @Test
  public void addGetraenk(){
    var getraenk = new Getraenk();
    getraenk.setName("Eistee");
    getraenk.setPreis(9L);
    getraenk.setMenge(1L);
    getraenk.setEiswuerfel(true);

    assertThatCode(()->getraenkRepo.addGetraenke(getraenk)).doesNotThrowAnyException();

    var loadedGetraenk = getraenkRepo.getGetraenkeById(getraenk.getId());

    assertThat(loadedGetraenk.getName()).isNotNull().isEqualTo(getraenk.getName());

  }

  @Test
  public void getGetraenk_notExists(){
    var id = 3;

    AtomicReference<Getraenk> loadedGetraenk = new AtomicReference<>();
    assertThatCode(()->{
      loadedGetraenk.set(getraenkRepo.getGetraenkeById(id));
    }).doesNotThrowAnyException();

    assertThat(loadedGetraenk.get()).isNull();
  }


}
