/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.SQLException;
/**
 *
 * @author diego
 */
public class DataSource {
    private String hostname;
    private int    port;
    private String database;
    private String username;
    private String password;
    private String url;
    
    private Connection connection;
    
    public DataSource(){
        try{
            hostname = "localhost";
            port     = 1433;
            database = "dcd";
            username = "sa";
            password = "epilef";
            
            url = "jdbc:sqlserver://"+hostname+";databaseName="+database;
            
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Deu certo...");
        }
        catch(SQLException ex){
            System.err.println("ERRO na Conexao "+ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Erro geral "+ex.getMessage() + " ---- " + url);
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.err.println("Erro ao desconectar "+ex.getMessage());
        }
        
    }
}
