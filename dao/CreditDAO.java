/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Credit;
import model.Parameters;

/**
 *
 * @author lucas
 */
public class CreditDAO {
    
    public static Boolean create(Credit c) throws SQLException {
        
            if(c.getClient().getIdstoq() == null || c.getClient().getOn_stoq() == 0){
                System.out.println("Cliente não cadastrado no Stoq");
                return false;
            }
            
            Statement stm1
                    = DatabaseStoqLocal.createConnection().
                            createStatement();
            String sql1
                    = "INSERT INTO payment_group (renegotiation_id, recipient_id, "
                    + "payer_id) VALUES (NULL, NULL, '" + c.getClient().getIdstoq()
                    + "') RETURNING payment_group.id";
               
            ResultSet rs1 = stm1.executeQuery(sql1);
            rs1.next();
            String groupid = rs1.getString("id");
            System.out.println("groupid = " + groupid);
            
            Statement stm2
                    = DatabaseStoqLocal.createConnection().
                            createStatement();
            String sql2
                    = "INSERT INTO payment (bill_received, paid_value, discount, "
                    + "interest, branch_id, payment_number, due_date, value, "
                    + "method_id, cancel_date, payment_type, group_id, open_date, "
                    + "penalty, base_value, paid_date, description, status) VALUES"
                    + " (false, '" + c.getValue() + "', '0', '0', '" 
                    + Parameters.IDBRACNH + "', NULL, NOW(), '" + c.getValue() 
                    + "', '" + Parameters.IDMETHODCREDIT + "', NULL, 'out', '" 
                    + groupid + "', NOW(), '0', '" + c.getValue() + "', "
                    + "TRANSACTION_TIMESTAMP(), '" + c.getDescription() + "', "
                    + "'paid') RETURNING payment.id, payment.identifier";
               
            ResultSet rs2 = stm2.executeQuery(sql2);
            rs2.next();
            String paymentId = rs2.getString("id");
            String paymentIdentifier = rs2.getString("identifier");
            System.out.println("id = " + paymentId + " ident = " + paymentIdentifier);
            
            Statement stm3
                    = DatabaseStoqLocal.createConnection().
                            createStatement();
            String sql3
                    = "INSERT INTO account_transaction (operation_type, code, "
                    + "payment_id, date, source_account_id, description, value, "
                    + "account_id) VALUES ('out', '" + paymentIdentifier + "', '"
                    + paymentId + "', NOW(), '" + Parameters.IDIMBALANCEACCOUNT 
                    + "', '" + c.getDescription() + "', '" + c.getValue() 
                    + "', '" + Parameters.IDIMBALANCEACCOUNT + "') "
                    + "RETURNING account_transaction.id";

               
            ResultSet rs3 = stm3.executeQuery(sql1);
            rs3.next();
            String transactionid = rs3.getString("id");
            System.out.println(transactionid);
            
            return true;
    }
}