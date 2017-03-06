/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Client;
import model.History;

/**
 *
 * @author lucas
 */
public class HistoryDAO {
    
    public static History create(History h) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO history (`client`, `eancode`, `date`) VALUES ('"
                    + h.getClient().getId() + "','"
                    + h.getEancode() + "','" 
                    + h.getDate() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            h.setId(key);
            return h;
    }
    
    public static History retreave(int id) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM history where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            Client c = ClientDAO.retreave(rs.getInt("client"));
            return new History(
                    id, 
                    c,
                    rs.getString("eancode"),
                    rs.getTimestamp("date"));                
    }
    
    
}
