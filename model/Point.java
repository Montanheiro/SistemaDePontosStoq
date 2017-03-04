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
public class Point {
    
    private int id;
    private Client client;
    private int value;
    private Date date;
    private String desc;

    public Point(int id, Client client, int value, Date date, String desc) {
        this.id = id;
        this.client = client;
        this.value = value;
        this.date = date;
        this.desc = desc;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Point{" + "id=" + id + ", client=" + client + ", value=" + value + ", date=" + date + ", desc=" + desc + '}';
    }
    
}
