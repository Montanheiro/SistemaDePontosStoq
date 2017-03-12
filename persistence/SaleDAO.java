package persistence;

import constructor.Sale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SaleDAO {
    
    public static ArrayList<Sale> retreaveAll() 
            throws SQLException {
        Statement stm1
                = DatabaseStoq.createConnection().
                        createStatement();

        String sql = "SELECT identifier, client_id, total_amount,"
                + "open_date FROM sale WHERE status = 'confirmed' ORDER BY identifier";
        ResultSet rs = stm1.executeQuery(sql);
        
        ArrayList<Sale> s = new ArrayList<>();
        
         while (rs.next()) {
                s.add(new Sale(
                    rs.getInt("identifier"),
                    rs.getString("client_id"), 
                    rs.getDouble("total_amount"), 
                    rs.getTimestamp("open_date")));
            }
        rs.next();  
        return s;
    }   
}
