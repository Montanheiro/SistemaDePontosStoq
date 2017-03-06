
import dao.AdminDAO;
import dao.ClientDAO;
import dao.HistoryDAO;
import dao.ProductDAO;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import model.Admin;
import model.Client;
import model.History;
import model.Product;

public class Main {

    public static void main(String[] args) throws SQLException {
        
            // TESTES PRODUTO
        
//        Product p = ProductDAO.retreaveByBarcode("2368694135945");
//        System.out.println(p.toString());
        
//        ArrayList<Product> p2 = ProductDAO.retreaveByDescription("usa");       
//        for (Product p : p2) {
//            System.out.println(p);
//        }
      
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

//        System.out.println(AdminDAO.retreave("user", "senha")); 
          
            // TESTES CLIENTES
    
//        Client c = new Client("nome", "telefone", "celular", "email", "rg", "cpf",
//                "cidade", "pais", "estado", "rua", "numero", "cidade", "id stoq",
//                "senha", new Timestamp(System.currentTimeMillis()), 0);
//        ClientDAO.create(c);

//        System.out.println(ClientDAO.retreave(1));

//        ArrayList<Client> cli = ClientDAO.retreaveAll();
//        for (Client c1 : cli) {
//            System.out.println(c1);
//        }

//        Client c = new Client(1, "kgjs", "fssf", "kgjs", "kgjs", "kgjs", "kgjs",
//                "kgjs", "kgjs", "kgjs", "kgjs", "kgjs", "kgjs", "id kgjs",
//                "kgjs", new Timestamp(System.currentTimeMillis()), 1);
//        ClientDAO.update(c);
//        System.out.println(ClientDAO.retreave(1));

        Client c = new Client(1, "kgjs", "fssf", "kgjs", "kgjs", "kgjs", "kgjs",
                "kgjs", "kgjs", "kgjs", "kgjs", "kgjs", "kgjs", "id kgjs",
                "kgjs", new Timestamp(System.currentTimeMillis()), 1);
        History h = new History(c, "eancode", new Timestamp(System.currentTimeMillis()));
        System.out.println(HistoryDAO.create(h));
    }
    
}
