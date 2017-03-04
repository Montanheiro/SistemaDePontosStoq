/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Parameters;
import model.Product;

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
        rs1.next();   
        
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
    
    
    
//    
//    public static ArrayList<Cliente> retreaveAll() throws SQLException {
//        Statement stm
//                = BancoDados.createConnection().
//                        createStatement();
//        String sql = "SELECT * FROM cliente";
//        ResultSet rs = stm.executeQuery(sql);
//        ArrayList<Cliente> f = new ArrayList<>();
//        while (rs.next()) {       
//            f.add(new Cliente(
//                    rs.getInt("id"),
//                    rs.getString("DataNascimento"),
//                    rs.getInt("RG"),
//                    rs.getDouble("Limite")));
//        }
//        rs.next();
//        return f;
//    }
}


//--busca produto por código de barras
//SELECT sellable.id, sellable.barcode, sellable.base_price, sellable.description, sellable.on_sale_end_date, sellable.on_sale_price, sellable.on_sale_start_date FROM sellable WHERE sellable.status = 'available' AND LOWER(sellable.barcode) = '2368694135945'
//--busca estoque minimo e maximo, com o id do produto
//SELECT storable.id, storable.minimum_quantity FROM storable WHERE storable.id = '26ecd6fd-f79a-11e6-85ce-e0db55a5104f' LIMIT 1
//--ver quantos tem em estoque na matriz, com o id do produto
//SELECT SUM(product_stock_item.quantity) AS qtd FROM product_stock_item WHERE product_stock_item.storable_id = '26ecd6fd-f79a-11e6-85ce-e0db55a5104f' AND product_stock_item.branch_id = '26a26e97-f79a-11e6-85ce-e0db55a5104f'


