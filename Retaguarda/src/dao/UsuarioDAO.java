package dao;

import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO extends Data{
    
    public void inserir(Usuario u){
        
        DataSource ds = new DataSource();
        Connection con = ds.getConnection();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO Usuario (Nome, Abreviacao, Senha) VALUES (?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getAbreviacao());
            stmt.setString(3, u.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch(SQLException ex){
            System.err.println("ERRO na Conexao "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }finally{
            ds.closeDataSource();
        }
    }
    
    public Usuario retornaDadosCodigo(int codigo){
        
        DataSource ds = new DataSource();
        Connection con = ds.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Usuario u = new Usuario();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE codigo = ?");
            stmt.setInt(1, codigo);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                u.setCodigo(rs.getInt("Codigo"));
                u.setNome(rs.getString("Nome"));
                u.setAbreviacao(rs.getString("Abreviacao"));
                u.setSenha(rs.getString("Senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ds.closeDataSource();
        }
        return u;
    }
    
    //Ainda tem que implementar a descricao
    public List<Usuario> retornaDadosDesc(int codigo){
        
        DataSource ds = new DataSource();
        Connection con = ds.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE codigo = ?");
            stmt.setInt(1, codigo);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario produto = new Usuario(rs.getString("Nome"), 
                        rs.getString("Abreviacao"), rs.getString("Senha"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ds.closeDataSource();
        }
        
        return usuarios;
    }
    
}
