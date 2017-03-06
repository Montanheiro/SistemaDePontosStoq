/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Admin;
import model.Exchange;
import model.Point;

/**
 *
 * @author lucas
 */
public class ExchangeDAO {
    
    public static Exchange create(Exchange e) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO exchange (`total`, `discount`, `point`, `admin`) VALUES ('"
                    + e.getTotal() + "','"
                    + e.getDiscount() + "','" 
                    + e.getPoint().getId() + "','"
                    + e.getAdmin().getId() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            e.setId(key);
            return e;
    }
    
    public static Exchange retreave(int id) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM exchange where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            Point p = PointDAO.retreave(rs.getInt("point"));
            Admin a = AdminDAO.retreave(rs.getInt("admin"));
            return new Exchange(
                    id,
                    rs.getDouble("total"),
                    rs.getDouble("discount"),
                    p,
                    a);                
    }
    
    public static ArrayList<Exchange> retreaveAll() throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM exchange";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Exchange> e = new ArrayList<>();
            while (rs.next()) {
                Point p = PointDAO.retreave(rs.getInt("point"));
                Admin a = AdminDAO.retreave(rs.getInt("admin"));
                e.add(new Exchange(
                    rs.getInt("id"),
                    rs.getDouble("total"),
                    rs.getDouble("discount"),
                    p,
                    a));
            }
            rs.next();
            return e;
    }
   
}
