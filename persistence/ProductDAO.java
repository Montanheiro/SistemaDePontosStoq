/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import business.Parameters;
import constructor.Product;

/**
 *
 * @author lucas
 */
public class ProductDAO {
    
    
    public static Product retreaveByBarcode(String barcode) throws SQLException {
        Statement stm1
                = DatabaseStoq.createConnection().
                        createStatement();
        //busca produto por código de barras
        String sql1 = "SELECT sellable.id, sellable.barcode, sellable.base_price, "
                + "sellable.description, sellable.on_sale_end_date, "
                + "sellable.on_sale_price, sellable.on_sale_start_date "
                + "FROM sellable WHERE sellable.status = 'available' "
                + "AND LOWER(sellable.barcode) = '" + barcode + "'";
        ResultSet rs1 = stm1.executeQuery(sql1);
//        rs1.next();  
//        
        if(!rs1.next()){
            System.out.println("não existe produto com esse código");
        }
        
        //busca estoque minimo e maximo, com o id do produto
        Statement stm2
                = DatabaseStoq.createConnection().
                        createStatement();
        String idSellable = rs1.getString("id");
        String sql2 = "SELECT storable.id, storable.minimum_quantity "
                + "FROM storable WHERE storable.id = '" + idSellable + "' LIMIT 1";
        ResultSet rs2 = stm2.executeQuery(sql2);
        rs2.next();
        
        //ve quantos tem em estoque na matriz, com o id do produto que pegou acima
        Statement stm3
                = DatabaseStoq.createConnection().
                        createStatement();
        String idStorable = rs2.getString("id");
        String sql3 = "SELECT SUM(product_stock_item.quantity) AS qtd "
                + "FROM product_stock_item WHERE product_stock_item.storable_id"
                + " = '"+ idStorable +"' AND product_stock_item.branch_id = '"
                + Parameters.IDBRACNH + "'";
        ResultSet rs3 = stm3.executeQuery(sql3);
        rs3.next();
          
        return new Product(
                idSellable,
                rs1.getString("barcode"),
                rs1.getDouble("base_price"),
                rs1.getString("description"),
                rs1.getDate("on_sale_end_date"), 
                rs1.getDate("on_sale_start_date"),
                rs1.getDouble("on_sale_price"),
                idStorable,
                rs2.getDouble("minimum_quantity"),
                rs3.getDouble("qtd"));   
    }
    
    public static ArrayList<Product> retreaveByDescription(String description) throws SQLException {
        Statement stm1
                = DatabaseStoq.createConnection().
                        createStatement();
        //busca produto por código de barras
        String sql1 = "SELECT sellable.id, sellable.barcode, sellable.base_price,"
                + "sellable.description, sellable.on_sale_end_date, "
                + "sellable.on_sale_price, sellable.on_sale_start_date "
                + "FROM sellable WHERE sellable.status = 'available' "
                + "AND sellable.description ~*'" + description + "'";
        ResultSet rs1 = stm1.executeQuery(sql1);
        
        ArrayList<Product> p = new ArrayList<>();
        
        while(rs1.next()){
            
            //busca estoque minimo e maximo, com o id do produto
            Statement stm2
                    = DatabaseStoq.createConnection().
                            createStatement();

            String idSellable = rs1.getString("id");
            String sql2 = "SELECT storable.id, storable.minimum_quantity "
                    + "FROM storable WHERE storable.id = '" + idSellable + "' LIMIT 1";
            ResultSet rs2 = stm2.executeQuery(sql2);
            rs2.next();

            //ve quantos tem em estoque na matriz, com o id do produto que pegou acima
            Statement stm3
                    = DatabaseStoq.createConnection().
                            createStatement();
            String idStorable = rs2.getString("id");
            String sql3 = "SELECT SUM(product_stock_item.quantity) AS qtd "
                    + "FROM product_stock_item WHERE product_stock_item.storable_id"
                    + " = '"+ idStorable +"' AND product_stock_item.branch_id = '"
                    + Parameters.IDBRACNH + "'";
            ResultSet rs3 = stm3.executeQuery(sql3);
            rs3.next();
            
            p.add(new Product(
                idSellable,
                rs1.getString("barcode"),
                rs1.getDouble("base_price"),
                rs1.getString("description"),
                rs1.getDate("on_sale_end_date"), 
                rs1.getDate("on_sale_start_date"),
                rs1.getDouble("on_sale_price"),
                idStorable,
                rs2.getDouble("minimum_quantity"),
                rs3.getDouble("qtd")));
        }
        rs1.next();  
        return p;
    }   
}
