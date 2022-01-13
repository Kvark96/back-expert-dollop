package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.ConferenceFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    //@RolesAllowed("user")
    public String getAllConf(){
        return GSON.toJson(FACADE.getAllConf());
    }

}
