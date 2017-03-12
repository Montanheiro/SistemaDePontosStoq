package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Admin;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import persistence.AdminDAO;

@Path("admin")
public class AdminResource {

    @Context
    private UriInfo context;

    public AdminResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(String body) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Admin a = gson.fromJson(body, Admin.class);
        a = AdminDAO.retreave(a.getUser(), a.getPassword());

        String token;
        if(a.getType() == 1) token = new Token().Gerate("superadmin", a.getId(), 30);
        else token = new Token().Gerate("admin", a.getId(), 30);
        
        return token;
    }
}
