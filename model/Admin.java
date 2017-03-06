/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Admin {
    
    private int id;
    private String user;
    private String password;
    private Timestamp created;
    private int status;

    public Admin(int id, String user, Timestamp created, int status) {
        this.id = id;
        this.user = user;
        this.created = created;
        this.status = status;
    }

    public Admin(String user, Timestamp created, int status) {
        this.user = user;
        this.created = created;
        this.status = status;
    }
    
    public Admin(String user, String password, Timestamp created, int status) {
        this.user = user;
        try {
            this.password = new Token().Password(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.created = created;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", user=" + user + ", created=" + created + ", status=" + status + '}';
    }
    
}
