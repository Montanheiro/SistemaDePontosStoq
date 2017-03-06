/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    
}
