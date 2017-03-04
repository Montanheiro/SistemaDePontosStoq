/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Parameters {
    
    // PARAMETROS GERAIS
    public static final double EXCHANGEPOINTS = 30; //quantos pontos valem 1 real
    public static final double CONVERSION = 1; //fator de conversão dos pontos
    public static final double MAXIMUMDISCOUNT = 20; //percentual maximo de desconto
    public static final int VALID = 13; //validade em meses
    public static final String IDIMBALANCEACCOUNT = ""; //configurações stoq
    public static final String IDPAYMENTCREDIT = ""; //configurações stoq
    public static final String IDBRACNH = "26a26e97-f79a-11e6-85ce-e0db55a5104f"; //configurações stoq
    
    // BANCO DE DADOS DO STOQ
    public static final String URL1 = "jdbc:postgresql://localhost:5432/stoq";
    public static final String USR1 = "postgres";
    public static final String PWD1 = "postgres";
    public static final String DRIVER1 = "org.postgresql.Driver";
    
    // BANCO DE DADOS DO SISTEMA DE PONTOS
    public static final String URL2 = "jdbc:mysql://localhost/pontos"; 
    public static final String USR2 = "root"; 
    public static final String PWD2 = "root"; 
    public static final String DRIVER2 = "com.mysql.jdbc.Driver";
}