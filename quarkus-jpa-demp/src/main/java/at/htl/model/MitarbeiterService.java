package at.htl.model;

import at.htl.entity.Mitarbeiter;
import at.htl.repository.MitarbeiterRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/mitarbeiter")
@RequestScoped
public class MitarbeiterService {

  private final MitarbeiterRepo mitarbeiterRepo;

  public MitarbeiterService(MitarbeiterRepo mitarbeiterRepo) {
    this.mitarbeiterRepo = mitarbeiterRepo;
  }

  @POST
  @Path("addMitarbeiter")
  @Transactional
  public Mitarbeiter addMitarbeiter(Mitarbeiter mitarbeiter){
    mitarbeiterRepo.addMitarbeiter(mitarbeiter);
    return mitarbeiter;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @POST
  @Path("updateMitarbeiter")
  @Transactional
  public Mitarbeiter updateMitarbeiter(Mitarbeiter mitarbeiter){
    mitarbeiterRepo.updateMitarbeiter(mitarbeiter);
    return mitarbeiter;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Mitarbeiter> getAll(){
    return this.mitarbeiterRepo.getAllMitarbeiter();
  }

  @GET
  @Path("groupByType")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Double> groupBy(){
    return this.mitarbeiterRepo.getAllKoeche();
  }

}
