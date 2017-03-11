/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

import business.Token;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author lucas
 */
public class Client {
    
    private int id;
    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String rg;
    private String cpf;
    private String city;
    private String country;
    private String state;
    private String street;
    private String streetnumber;
    private String district;
    private String idstoq;
    private String password;
    private Timestamp created;
    private int on_stoq;

    public Client(String name, String phone, String mobile, String email, 
            String rg, String cpf, String city, String country, String state, 
            String street, String streetnumber, String district, String idstoq, 
            String password, Timestamp created, int on_stoq) {
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.city = city;
        this.country = country;
        this.state = state;
        this.street = street;
        this.streetnumber = streetnumber;
        this.district = district;
        this.idstoq = idstoq;  
        try {
            this.password = new Token().Password(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.created = created;
        this.on_stoq = on_stoq;
    }

    public Client(int id, String name, String phone, String mobile, String email, 
            String rg, String cpf, String city, String country, String state, 
            String street, String streetnumber, String district, String idstoq, 
            Timestamp created, int on_stoq) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.city = city;
        this.country = country;
        this.state = state;
        this.street = street;
        this.streetnumber = streetnumber;
        this.district = district;
        this.idstoq = idstoq;
        this.created = created;
        this.on_stoq = on_stoq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIdstoq() {
        return idstoq;
    }

    public void setIdstoq(String idstoq) {
        this.idstoq = idstoq;
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

    public int getOn_stoq() {
        return on_stoq;
    }

    public void setOn_stoq(int on_stoq) {
        this.on_stoq = on_stoq;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", phone=" + phone 
                + ", mobile=" + mobile + ", email=" + email + ", rg=" + rg 
                + ", cpf=" + cpf + ", city=" + city + ", country=" + country 
                + ", state=" + state + ", street=" + street + ", streetnumber=" 
                + streetnumber + ", district=" + district + ", idstoq=" + idstoq 
                + ", created=" + created + ", on_stoq=" + on_stoq + '}';
    }
    
}
