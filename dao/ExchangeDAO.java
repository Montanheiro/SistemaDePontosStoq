/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Exchange;

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
   
}
