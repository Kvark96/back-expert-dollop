package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ConferenceDTO;
import facades.ConferenceFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("conf")
public class ConferenceResource {
    private EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private final ConferenceFacade FACADE = ConferenceFacade.getConferenceFacade(emf);
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    @RolesAllowed("user")
    public String getAllConf(){
        return GSON.toJson(FACADE.getAllConf());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Path("addConf")
    public String addConf(String conf){
        ConferenceDTO cdto = GSON.fromJson(conf, ConferenceDTO.class);
        return GSON.toJson(FACADE.addConference(cdto));
    }

}
