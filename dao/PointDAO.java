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
import model.Client;
import model.Point;

/**
 *
 * @author lucas
 */
public class PointDAO {
    
    public static Point create(Point p) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO point (`client`, `value`, `date`, `desc`) VALUES ('"
                    + p.getClient().getId() + "','"
                    + p.getValue() + "','"
                    + p.getDate() + "','" 
                    + p.getDesc() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            p.setId(key);
            return p;
    }
    
    public static Point retreave(int id) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM point where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            Client c = ClientDAO.retreave(rs.getInt("client"));
            return new Point(
                    id, 
                    c, 
                    rs.getInt("value"), 
                    rs.getTimestamp("date"),
                    rs.getString("desc"));         
    }
    
    public static ArrayList<Point> retreaveAll() throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM point";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Point> p = new ArrayList<>();
            while (rs.next()) {
                Client c = ClientDAO.retreave(rs.getInt("client"));
                p.add(new Point(
                        rs.getInt("id"), 
                        c, 
                        rs.getInt("value"), 
                        rs.getTimestamp("date"), 
                        rs.getString("desc")));
            }
            rs.next();
            return p;
    }
}
