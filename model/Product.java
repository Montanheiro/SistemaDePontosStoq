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
public class Product {
    private String idSellable;
    private String barcode;
    private double price;
    private String description;
    private Date onSaleEnd;
    private Date onSaleStart;
    private double salePrice;
    private String idStorable;
    private double minimumQuantity;
    private double quantity;

    public Product(String idSellable, String barcode, double price, String description, Date onSaleEnd, Date onSaleStart, double salePrice, String idStorable, double minimumQuantity, double quantity) {
        this.idSellable = idSellable;
        this.barcode = barcode;
        this.price = price;
        this.description = description;
        this.onSaleEnd = onSaleEnd;
        this.onSaleStart = onSaleStart;
        this.salePrice = salePrice;
        this.idStorable = idStorable;
        this.minimumQuantity = minimumQuantity;
        this.quantity = quantity;
    }

    public String getIdSellable() {
        return idSellable;
    }

    public void setIdSellable(String idSellable) {
        this.idSellable = idSellable;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOnSaleEnd() {
        return onSaleEnd;
    }

    public void setOnSaleEnd(Date onSaleEnd) {
        this.onSaleEnd = onSaleEnd;
    }

    public Date getOnSaleStart() {
        return onSaleStart;
    }

    public void setOnSaleStart(Date onSaleStart) {
        this.onSaleStart = onSaleStart;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getIdStorable() {
        return idStorable;
    }

    public void setIdStorable(String idStorable) {
        this.idStorable = idStorable;
    }

    public double getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(double minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "idSellable=" + idSellable + ", barcode=" + barcode + ", price=" + price + ", description=" + description + ", onSaleEnd=" + onSaleEnd + ", onSaleStart=" + onSaleStart + ", salePrice=" + salePrice + ", idStorable=" + idStorable + ", minimumQuantity=" + minimumQuantity + ", quantity=" + quantity + '}';
    }
    
    
}
