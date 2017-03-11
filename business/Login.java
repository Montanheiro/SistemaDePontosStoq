/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import constructor.Admin;
import constructor.Client;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import persistence.AdminDAO;
import persistence.ClientDAO;

/**
 *
 * @author lucas
 */
public class Login {
    
    public Admin admin(String user, String pass) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException{
        return AdminDAO.retreave(user, pass);
    }
    
    public Client client(String emailOrCpf, String pass) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException{
        return ClientDAO.retreave(emailOrCpf, pass);
    }
}
