
import DAO.ProductDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        Product p = ProductDAO.retreaveByBarcode("236869413594");
        System.out.println(p.toString());
        
//        ArrayList<Product> p = ProductDAO.retreaveByDescription("calça");
//        System.out.println(p.toString());
        
    }
    
}
