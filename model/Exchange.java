/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Exchange {
    
    private int id;
    private double total;
    private double discount;
    private Point point;
    private Admin admin;

    public Exchange(int id, double total, double discount, Point point, Admin admin) {
        this.id = id;
        this.total = total;
        this.discount = discount;
        this.point = point;
        this.admin = admin;
    }

    public Exchange(double total, double discount, Point point, Admin admin) {
        this.total = total;
        this.discount = discount;
        this.point = point;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Exchange{" + "id=" + id + ", total=" + total + ", discount=" + discount + ", point=" + point + ", admin=" + admin + '}';
    }
    
}
