package DAO;

//TUTORIAL: http://www.devmedia.com.br/criando-uma-conexao-java-mysql-server/16753

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import model.Parameters;
 
//Início da classe de conexão//
public class DatabaseStoqLocal { 
    
    public static String status = "Não conectou...";
 
    //Método Construtor da Classe//
        public DatabaseStoqLocal() {
    }
 
    //Método de Conexão//
    public static java.sql.Connection createConnection() {
        Connection connection;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão                        
            Class.forName(Parameters.DRIVER3);

            connection = DriverManager.getConnection(Parameters.URL3, Parameters.USR3, Parameters.PWD3);

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } 
            else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
 
    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

   //Método que fecha sua conexão//
    public static boolean FecharConexao() {
 
        try {
            DatabaseStoqLocal.createConnection().close(); 
            return true;
 
        } catch (SQLException e) {
            return false;
        }
    }
  
    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return DatabaseStoqLocal.createConnection();
    }
}