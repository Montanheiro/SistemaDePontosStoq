/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class History {
    
    private int id;
    private Client client;
    private String eancode;
    private Date date;

    public History(int id, Client client, String eancode, Date date) {
        this.id = id;
        this.client = client;
        this.eancode = eancode;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEancode() {
        return eancode;
    }

    public void setEancode(String eancode) {
        this.eancode = eancode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", client=" + client + ", eancode=" + eancode + ", date=" + date + '}';
    }
       
}