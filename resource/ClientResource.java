/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import persistence.ClientDAO;

@Path("client")
public class ClientResource {

    @Context
    private UriInfo context;

    public ClientResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(String body) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Client c = gson.fromJson(body, Client.class);
        System.out.println("Cliente >>>>> " + c);
        
        if(c.getCpf() != null){
            c = ClientDAO.retreave(c.getCpf(), c.getPassword());
        }else{
            c = ClientDAO.retreave(c.getEmail(), c.getPassword());
        }
     
        System.out.println("Cliente válido, gerando token");
        
        String token = new Token().Gerate("client", c.getId(), 30);
        return token;
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/verify")
    public String verify(@HeaderParam("token") String token) throws Exception {
        
        System.out.println("Verificando >>>> " + token);
        if(!new Token().Verify(token, "client")) throw new Exception("Token invalido.");
        
        return "200";
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public String create(String body) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Client c = gson.fromJson(body, Client.class);
        c = ClientDAO.create(c);
        
        String token = new Token().Gerate("client", c.getId(), 30);
        return token;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getid")
    public String  getId(@HeaderParam("token") String token, 
            @QueryParam("id") int id) throws SQLException, Exception {
        
        if(!new Token().Verify(token, "admin") || !new Token().Verify(token, "superadmin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        Client c = ClientDAO.retreave(id);
        
        return gson.toJson(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getall")
    public String getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!new Token().Verify(token, "admin") || !new Token().Verify(token, "superadmin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        ArrayList<Client> client = ClientDAO.retreaveAll();
        return gson.toJson(client);  
    }
}
