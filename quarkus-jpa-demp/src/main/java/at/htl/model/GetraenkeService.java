package at.htl.model;

import at.htl.entity.Getraenk;
import at.htl.entity.Kunde;
import at.htl.repository.GetraenkRepo;
import at.htl.repository.KundeRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/getraenke")
@RequestScoped
public class GetraenkeService {

  private final GetraenkRepo getraenkRepo;

  public GetraenkeService(GetraenkRepo getraenkRepo) {
    this.getraenkRepo = getraenkRepo;
  }

  @POST
  @Path("add")
  @Transactional
  public Getraenk add(String name, Long preis, Long menge, Boolean eiswuerfel){
    if(name == null){
      throw new IllegalArgumentException();
    }
    return  this.getraenkRepo.add(name,preis,menge,eiswuerfel);
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Getraenk> getAll(){
    return this.getraenkRepo.getAllGetraenke();
  }


}
