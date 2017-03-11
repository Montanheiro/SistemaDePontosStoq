package resource;

import com.google.gson.Gson;
import dao.AdminDAO;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Admin;

@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId (@QueryParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        Admin a = AdminDAO.retreave(id);
        return gson.toJson(a);
    }

}
