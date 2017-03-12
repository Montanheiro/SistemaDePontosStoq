package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Client;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import persistence.ClientDAO;

@Path("point")
public class PointResource {

    @Context
    private UriInfo context;

    public PointResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public String get(@HeaderParam("token") String token) throws Exception {
        
        int id = new Token().getSubject(token, "client");
        if(id == 0) throw new Exception("Token invalido.");
        Client c = ClientDAO.retreave(id);
        
        
        
        Gson gson = new Gson();
        return gson.toJson(c);
    }
}
