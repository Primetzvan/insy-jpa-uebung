package at.htl.model;

import at.htl.entity.*;
import at.htl.repository.BestellJoin;
import at.htl.repository.BestellungBestellliste;
import at.htl.repository.BestellungRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/bestellung")
@RequestScoped
public class BestellungService {

  private final BestellungRepo bestellungRepo;

  public BestellungService(BestellungRepo bestellungRepo){
    this.bestellungRepo = bestellungRepo;
  }


  @POST
  @Path("addBestellung")
  @Transactional
  public Bestellung addBestellung(Bestellung bestellung){
    bestellungRepo.addBestellung(bestellung);
    return bestellung;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @POST
  @Path("updateBestellung")
  @Transactional
  public Bestellung updateBestellung(Bestellung bestellung){
    bestellungRepo.updateBestellung(bestellung);
    return bestellung;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @POST
  @Path("createBestellliste")
  @Transactional
  public Bestellliste createBestelliste(BestellungBestellliste bestellliste){
    bestellungRepo.createBestelliste(bestellliste.bestelliste,bestellliste.bid);
    return bestellliste.bestelliste;
    //return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Bestellung> getAll(){
    return this.bestellungRepo.getAllBestellung();
  }


  @GET
  @Path("getJoin/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<BestellJoin> getJoin(@PathParam("id") Integer id){
    return this.bestellungRepo.findAllBestellungenByBestellungslistID(id);
  }

}
