
import DAO.ProductDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;

public class Main {

    public static void main(String[] args) throws SQLException {
        
//        Product p = ProductDAO.retreaveByBarcode("236869413594");
//        System.out.println(p.toString());
        
        ArrayList<Product> p = ProductDAO.retreaveByDescription("ajfa");
        System.out.println(p.toString());
        
    }
    
}
