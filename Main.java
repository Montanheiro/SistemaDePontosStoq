
import dao.AdminDAO;
import dao.ProductDAO;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import model.Admin;
import model.Product;

public class Main {

    public static void main(String[] args) throws SQLException {
        
            // TESTES PRODUTO
        
//        Product p = ProductDAO.retreaveByBarcode("236869413594");
//        System.out.println(p.toString());
        
//        ArrayList<Product> p = ProductDAO.retreaveByDescription("ajfa");
//        System.out.println(p.toString());
      
            // TESTES ADMIN

//        Admin a = new Admin("usuario","senha", new Timestamp(System.currentTimeMillis()), 1);
//        System.out.println(AdminDAO.create(a));

//        Admin a2 = AdminDAO.retreave(1);
//        System.out.println(a2);

//        ArrayList<Admin> adm = AdminDAO.retreaveAll();
//        for (Admin a : adm) {
//            System.out.println(a);
//        }
        
        
//        Admin a = new Admin(1, "usuario", new Timestamp(System.currentTimeMillis()), 1);
//        AdminDAO.update(a);
//        Admin a2 = AdminDAO.retreave(1);
//        System.out.println(a2);

//        AdminDAO.delete(a);

//        Admin a = new Admin(1, "usuario", "senha1234", new Timestamp(System.currentTimeMillis()), 1);
//        AdminDAO.updatePassword(a);

        System.out.println(AdminDAO.retreave("user", "senha")); 
        
    }
    
}
