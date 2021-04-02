package at.htl.model;

import at.htl.entity.Kunde;
import at.htl.repository.KundeRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("/api/kunde")
@RequestScoped
public class KundenService {

  private final KundeRepo kundeRepo;

  public KundenService(KundeRepo kundeRepo) {
    this.kundeRepo = kundeRepo;
  }

  @POST
  @Path("addKunde")
  @Transactional
  public Kunde addKunde(Kunde kunde){
    kundeRepo.addKunde(kunde);
    return kunde;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Kunde> getAll(){
    return this.kundeRepo.getAllKunden();
  }


}
