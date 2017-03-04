package model;

public class Parameters {
    
    // PARAMETROS DO SISTEMA DE PONTOS
    public static final double EXCHANGEPOINTS = 30; //quantos pontos valem 1 real
    public static final double CONVERSION = 1; //fator de conversão dos pontos
    public static final double MAXIMUMDISCOUNT = 20; //percentual maximo de desconto
    public static final int VALID = 13; //validade em meses
    
    // PARAMETROS DO STOQ
    public static final String IDIMBALANCEACCOUNT = ""; //configurações stoq
    public static final String IDPAYMENTCREDIT = ""; //configurações stoq
    public static final String IDBRACNH = "26a26e97-f79a-11e6-85ce-e0db55a5104f"; //configurações stoq
    
    // BANCO DE DADOS DO SISTEMA DE PONTOS
    public static final String URL1 = "jdbc:mysql://localhost/pontos"; 
    public static final String USR1 = "root"; 
    public static final String PWD1 = "root"; 
    public static final String DRIVER1 = "com.mysql.jdbc.Driver";
    
    // BANCO DE DADOS DO STOQ REPLICA - CONSULTA
    public static final String URL2 = "jdbc:postgresql://localhost:5432/stoq";
    public static final String USR2 = "postgres";
    public static final String PWD2 = "postgres";
    public static final String DRIVER2 = "org.postgresql.Driver";
    
    // BANCO DE DADOS DO STOQ LOCAL - INSERT POINTS
    public static final String URL3 = "jdbc:postgresql://localhost:5432/stoq";
    public static final String USR3 = "postgres";
    public static final String PWD3 = "postgres";
    public static final String DRIVER3 = "org.postgresql.Driver";
}