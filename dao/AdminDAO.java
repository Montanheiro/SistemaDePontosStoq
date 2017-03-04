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
import java.util.Date;
import model.Admin;

/**
 *
 * @author lucas
 */
public class AdminDAO {  
    
    public static Admin create(Admin a) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO admin (`user`, `password`, `created`, `status`) VALUES ('"
                    + a.getUser() + "','"
                    + a.getPassword() + "','"
                    + a.getCreated() + "','" 
                    + a.getStatus() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            a.setId(key);
            return a;
    }

    public static Admin retreave(int id) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM admin where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            String test1 = rs.getString("created");
            return new Admin(
                    id, 
                    rs.getString("user"), 
                    rs.getTimestamp("created"), 
                    rs.getInt("status"));
                    
    }
    
    public static Admin retreave(String user, String password) throws SQLException {
        Statement stm
                = DatabasePoints.createConnection().
                        createStatement();
        String sql = "SELECT * FROM admin WHERE user = '" + user 
                + "' AND password = '" + password + "' AND status = 1";
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        
        return new Admin(
                rs.getInt("id"),
                rs.getString("user"), 
                rs.getTimestamp("created"), 
                rs.getInt("status"));
    }

    public static ArrayList<Admin> retreaveAll() throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Admin> a = new ArrayList<>();
            while (rs.next()) {
                a.add(new Admin(
                    rs.getInt("id"),
                    rs.getString("user"), 
                    rs.getTimestamp("created"), 
                    rs.getInt("status")));
            }
            rs.next();
            return a;
    }
    
    public static void update(Admin a) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "UPDATE admin SET "
                    + "`user`='" + a.getUser() + "',"
                    + "`created`='" + a.getCreated() + "',"
                    + "`status`=" + a.getStatus()
                    + " WHERE `id`= " + a.getId();
            stm.execute(sql);
    }
    
    public static void updatePassword(Admin a) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "UPDATE admin SET "
                    + "`password`='" + a.getPassword()+ "'"
                    + " WHERE `id`= " + a.getId();
            stm.execute(sql);
    }

    public static void delete(Admin a) throws SQLException {
            Statement stm
                    = DatabasePoints.createConnection().
                            createStatement();
            String sql = "DELETE FROM admin WHERE `id`=" + a.getId();
            stm.execute(sql);
    }

}
