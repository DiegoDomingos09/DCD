package dao;

import Entity.Usuario;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Data {
    
    /**
     *
     * @param diego
     */
    public void inserirData(Object obj){
        
        DataSource ds = new DataSource();
        Connection con = ds.getConnection();
        
        PreparedStatement stmt = null;
        
        String insert = "";
        String values = "";
        
        try{
            //insert = "INSERT INTO " + obj.getClass().getName(). + " ("; 
            values = " VALUES (";
            for(Field field : obj.getClass().getFields()){
                
                insert += field.getName() + ", ";
                
                if (field.getType() == Integer.TYPE){
                    values += field.toString();
                }else{
                    values += field.toString();
                }
            }
            /*
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getAbreviacao());
            stmt.setString(3, u.getSenha());
            */
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch(SQLException ex){
            System.err.println("ERRO na Conexao "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }finally{
            ds.closeDataSource();
        }
    }
}
