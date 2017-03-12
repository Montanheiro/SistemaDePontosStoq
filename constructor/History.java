/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

import java.sql.Timestamp;


/**
 *
 * @author lucas
 */
public class History {
    
    private int id;
    private Client client;
    private String search;
    private Timestamp date;
    private int type;

    public History(int id, Client client, String search, Timestamp date, int type) {
        this.id = id;
        this.client = client;
        this.search = search;
        this.date = date;
        this.type = type;
    }

    public History(Client client, String search, Timestamp date, int type) {
        this.client = client;
        this.search = search;
        this.date = date;
        this.type = type;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", client=" + client + ", search=" + search + ", date=" + date + ", type=" + type + '}';
    }
       
}
