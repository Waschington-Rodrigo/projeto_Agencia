/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import ConectaBanco.ConnectionDB;
import agencia.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Waschington Rodrigo
 */
public class UsuarioDAO {
        public void save(Usuario usuario){
        /*
         * Isso é uma sql comum, os ? são os parametros que nós vamos adicionar na base de dados
         */

        String sql = "INSERT INTO usuario(telefone,endereco,estado,cidade,email,nome,cpf,dataNascimento)" + " VALUES(?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parametro da sql
            pstm.setString(1, usuario.getTelefone());
            pstm.setString(2, usuario.getEndereco());
            pstm.setString(3, usuario.getEstado());
            pstm.setString(4, usuario.getCidade());
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getNome());
            pstm.setString(7, usuario.getCPf());
            pstm.setDate(8, new Date(usuario.getDataNascimento().getTime()));

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //fecha as conexões
            
            try{
                if(pstm !=null) pstm.close();
                
                if(conn !=null) conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
    public void removedById(int id){
        String sql = "DELETE FROM usuario WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionDB.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.execute();  
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(pstm != null) pstm.close();
                if(conn != null) conn.close();
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void update(Usuario usuario){
        String sql = "UPDATE usuario SET telefone = ?, endereco = ?, estado = ?, cidade = ?, email = ?, nome = ?, cpf = ?, dataNascimento = ? " + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //Cria uma conexão com o banco de dados
            conn = ConnectionDB.createConnectionToMySQL();
            
            //Cria uma PreparedStatement, classe usada oara executar a query
            pstm = conn.prepareStatement(sql);
            
            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, usuario.getTelefone());
            pstm.setString(2, usuario.getEndereco());
            pstm.setString(3, usuario.getEstado());
            pstm.setString(4, usuario.getCidade());
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getNome());
            pstm.setString(7, usuario.getCPf());
            pstm.setDate(8, new Date(usuario.getDataNascimento().getTime()));
            pstm.setInt(9, usuario.getId());
            
            //Executa a sql para inserção dos dados
            pstm.execute();
            
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //fecha as conexões
            try{
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public List<Usuario> getUsuarios(){
        
        String sql = "SELECT * FROM usuario";
        
        List<Usuario> usuarios = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        
        try{
            conn = ConnectionDB.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){
             Usuario usuario = new Usuario();
             
             //Recupera o id do banco e atribui ele ao objeto
             usuario.setId(rset.getInt("id"));
             usuario.setTelefone(rset.getString("telefone"));
             usuario.setEndereco(rset.getString("endereco"));
             usuario.setEstado(rset.getString("estado"));
             usuario.setCidade(rset.getString("cidade"));
             usuario.setEmail(rset.getString("email"));
             usuario.setNome(rset.getString("nome"));
             usuario.setCPF(rset.getString("cpf"));
             usuario.setDataNascimento(rset.getDate("dataNascimento"));
             
             //Adiciono o contato recuperado, a lista de contatos
             usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            
            try{
                if (rset != null) rset.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return usuarios;
    }
}
