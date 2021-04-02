package at.htl.model;

import at.htl.entity.Kunde;
import at.htl.entity.Speisse;
import at.htl.repository.KundeRepo;
import at.htl.repository.SpeisseRepo;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/speisse")
@RequestScoped
public class SpeisseService {

    private final SpeisseRepo speisseRepo;

    public SpeisseService(SpeisseRepo speisseRepo) {
      this.speisseRepo = speisseRepo;
    }

    @POST
    @Path("add")
    @Transactional
    public Speisse add(String name, Long preis, Long gewicht, Boolean salat){
      if(name == null){
        throw new IllegalArgumentException();
      }
      return  this.speisseRepo.add(name,preis,gewicht,salat);
    }

    @POST
    @Path("addSpeisse")
    @Transactional
    public Speisse addSpeisse(Speisse speisse){
      speisseRepo.addSpeisse(speisse);
      return speisse;
    }

    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Speisse> getAll(){
      return this.speisseRepo.getAllSpeissen();
    }

  }
