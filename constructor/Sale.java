package constructor;

import java.sql.Timestamp;


public class Sale {
    
    private int identifier;
    private String client_id;
    private double total_amount;
    private Timestamp open_date;

    public Sale(int identifier, String client_id, double total_amount, Timestamp open_date) {
        this.identifier = identifier;
        this.client_id = client_id;
        this.total_amount = total_amount;
        this.open_date = open_date;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Timestamp getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Timestamp open_date) {
        this.open_date = open_date;
    }

    @Override
    public String toString() {
        return "Sale{" + "identifier=" + identifier + ", client_id=" + client_id + ", total_amount=" + total_amount + ", open_date=" + open_date + '}';
    }
    
}
