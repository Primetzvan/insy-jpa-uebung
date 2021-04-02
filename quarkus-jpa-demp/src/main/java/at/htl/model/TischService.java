package at.htl.model;

import at.htl.entity.Bestellung;
import at.htl.entity.Kunde;
import at.htl.entity.Reservierung;
import at.htl.entity.Tisch;
import at.htl.repository.TischRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/api/tisch")
public class TischService {

  private final TischRepo tischRepo;

  public TischService(TischRepo tischRepo) {
    this.tischRepo = tischRepo;
  }

  @POST
  @Path("addTisch")
  @Transactional
  public Tisch addTisch(Tisch tisch){
    tischRepo.addTisch(tisch);
    return tisch;
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Tisch> getAll(){
    return this.tischRepo.getAllTIsch();
  }





}
