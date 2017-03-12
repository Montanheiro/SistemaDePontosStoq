/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import constructor.Client;
import business.Token;

/**
 *
 * @author lucas
 */
public class ClientDAO {
    
    public static Client create(Client c) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO client (`name`, `phone_number`, `mobile_number`, "
                    + "`email`, `rg`, `cpf`, `city`, `country`, `state`, `street`, "
                    + "`streetnumber`, `district`, `idstoq`, `password`, `created`, "
                    + "`on_stoq`) VALUES ('"
                    + c.getName() + "','"
                    + c.getPhone() + "','"
                    + c.getMobile() + "','"
                    + c.getEmail() + "','"
                    + c.getRg() + "','"
                    + c.getCpf() + "','"
                    + c.getCity() + "','"
                    + c.getCountry() + "','"
                    + c.getState() + "','"
                    + c.getStreet() + "','"
                    + c.getStreetnumber() + "','"
                    + c.getDistrict() + "','"
                    + c.getIdstoq() + "','"
                    + c.getPassword() + "','"
                    + c.getCreated() + "',"
                    + c.getOn_stoq()+ ")";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);
            return c;
    }

    public static Client retreave(int id) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM client where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Client(
                    id,
                    rs.getString("name"), 
                    rs.getString("phone_number"), 
                    rs.getString("mobile_number"), 
                    rs.getString("email"), 
                    rs.getString("rg"), 
                    rs.getString("cpf"), 
                    rs.getString("city"), 
                    rs.getString("country"), 
                    rs.getString("state"), 
                    rs.getString("street"), 
                    rs.getString("streetnumber"), 
                    rs.getString("district"), 
                    rs.getString("idstoq"), 
                    rs.getTimestamp("created"),
                    rs.getInt("on_stoq"));            
    }
    
    public static Client retreave(String emailOrCpf, String password) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
        Statement stm
                = DatabasePoints.createConnection().
                        createStatement();
        String sql = "SELECT * FROM client WHERE email = '" + emailOrCpf 
                + "' || cpf = '" + emailOrCpf + "' AND password = '" 
                + new Token().Password(password) + "' LIMIT 1";
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        
        return new Client(
                rs.getInt("id"),
                rs.getString("name"), 
                rs.getString("phone_number"), 
                rs.getString("mobile_number"), 
                rs.getString("email"), 
                rs.getString("rg"), 
                rs.getString("cpf"), 
                rs.getString("city"), 
                rs.getString("country"), 
                rs.getString("state"), 
                rs.getString("street"), 
                rs.getString("streetnumber"), 
                rs.getString("district"), 
                rs.getString("idstoq"), 
                rs.getTimestamp("created"),
                rs.getInt("on_stoq")); 
    }
    
    public static ArrayList<Client> retreaveAll() throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM client";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Client> c = new ArrayList<>();
            while (rs.next()) {
                c.add(new Client(
                    rs.getInt("id"),
                    rs.getString("name"), 
                    rs.getString("phone_number"), 
                    rs.getString("mobile_number"), 
                    rs.getString("email"), 
                    rs.getString("rg"), 
                    rs.getString("cpf"), 
                    rs.getString("city"), 
                    rs.getString("country"), 
                    rs.getString("state"), 
                    rs.getString("street"), 
                    rs.getString("streetnumber"), 
                    rs.getString("district"), 
                    rs.getString("idstoq"), 
                    rs.getTimestamp("created"),
                    rs.getInt("on_stoq")));
            }
            rs.next();
            return c;
    }
    
    public static void update(Client c) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "UPDATE client SET "
                    + "`name`='" + c.getName() + "',"
                    + "`phone_number`='" + c.getPhone() + "',"
                    + "`mobile_number`='" + c.getMobile() + "',"
                    + "`email`='" + c.getEmail() + "',"
                    + "`rg`='" + c.getRg() + "',"
                    + "`cpf`='" + c.getCpf() + "',"
                    + "`city`='" + c.getCity() + "',"
                    + "`country`='" + c.getCountry() + "',"
                    + "`state`='" + c.getState() + "',"
                    + "`street`='" + c.getStreet() + "',"
                    + "`streetnumber`='" + c.getStreetnumber() + "',"
                    + "`district`='" + c.getDistrict() + "',"
                    + "`idstoq`='" + c.getIdstoq() + "',"
                    + "`created`='" + c.getCreated() + "',"
                    + "`on_stoq`=" + c.getOn_stoq() 
                    + " WHERE `id`= " + c.getId();
            stm.execute(sql);
    }
    
    public static void updatePassword(Client c) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "UPDATE client SET "
                    + "`password`='" + new Token().Password(c.getPassword()) + "'"
                    + " WHERE `id`= " + c.getId();
            stm.execute(sql);
    }
    
    
}
