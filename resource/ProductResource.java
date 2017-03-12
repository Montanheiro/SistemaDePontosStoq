package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Client;
import constructor.History;
import constructor.Product;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import persistence.ClientDAO;
import persistence.HistoryDAO;
import persistence.ProductDAO;

@Path("product")
public class ProductResource {

    @Context
    private UriInfo context;

    public ProductResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eancode")
    public String eancode(@HeaderParam("token") String token, 
            @QueryParam("search") String eancode) 
            throws SQLException, Exception {
        
        if(token != null){
            int id = new Token().getSubject(token, "client");
            if(id == 0) throw new Exception("Token invalido.");
            
            Client c = ClientDAO.retreave(id);
            History h = new History(c, eancode, new Timestamp(System.currentTimeMillis()), 1);
            HistoryDAO.create(h);
        }else{
            Client c = new Client(1);
            History h = new History(c, eancode, new Timestamp(System.currentTimeMillis()), 1);
            HistoryDAO.create(h);
        }
        
        Gson gson = new Gson();     
        Product p = ProductDAO.retreaveByBarcode(eancode);
        return gson.toJson(p);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/desc")
    public String getAll(@HeaderParam("token") String token, 
            @QueryParam("search") String desc) 
            throws SQLException, Exception{
        
        if(token != null){
            int id = new Token().getSubject(token, "client");
            if(id == 0) throw new Exception("Token invalido.");
            
            Client c = ClientDAO.retreave(id);
            History h = new History(c, desc, new Timestamp(System.currentTimeMillis()), 2);
            HistoryDAO.create(h);
        }else{
            Client c = new Client(1);
            History h = new History(c, desc, new Timestamp(System.currentTimeMillis()), 2);
            HistoryDAO.create(h);
        }
        
        Gson gson = new Gson();
        ArrayList<Product> product = ProductDAO.retreaveByDescription(desc);
        return gson.toJson(product);  
    }

}
