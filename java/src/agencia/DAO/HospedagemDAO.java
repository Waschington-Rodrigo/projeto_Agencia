/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import ConectaBanco.ConnectionDB;
import agencia.model.Hospedagem;
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
public class HospedagemDAO {
     public void save(Hospedagem hospedagem){
        /*
         * Isso é uma sql comum, os ? são os parametros que nós vamos adicionar na base de dados
         */

        String sql = "INSERT INTO hospedagem(cidade,estado,tipo,valorDiaria,endereco,telefone,nome)" + " VALUES(?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parametro da sql
            pstm.setString(1, hospedagem.getCidade());
            pstm.setString(2, hospedagem.getEstado());
            pstm.setString(3, hospedagem.getTipo());
            pstm.setFloat(4, (float) hospedagem.getValorDiaria());
            pstm.setString(5, hospedagem.getEndereco());
            pstm.setString(6, hospedagem.getTelefone());
            pstm.setString(7, hospedagem.getNome());
            
            
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
        String sql = "DELETE FROM hospedagem WHERE id = ?";
        
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
    
    public void update(Hospedagem hospedagem){
        String sql = "UPDATE hospedagem SET cidade = ?, estado = ?, tipo = ?, valorDiaria = ?, endereco = ?, telefone = ?, nome = ?" + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //Cria uma conexão com o banco de dados
            conn = ConnectionDB.createConnectionToMySQL();
            
            //Cria uma PreparedStatement, classe usada oara executar a query
            pstm = conn.prepareStatement(sql);
            
            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, hospedagem.getCidade());
            pstm.setString(2, hospedagem.getEstado());
            pstm.setString(3, hospedagem.getTipo());
            pstm.setFloat(4, (float) hospedagem.getValorDiaria());
            pstm.setString(5, hospedagem.getEndereco());
            pstm.setString(6, hospedagem.getTelefone());
            pstm.setString(7, hospedagem.getNome());
            
            pstm.setInt(8, hospedagem.getId());
            
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
    
    public List<Hospedagem> getHospedagens(){
        
        String sql = "SELECT * FROM hospedagem";
        
        List<Hospedagem> hospedagens = new ArrayList<>();
        
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
             Hospedagem hospedagem = new Hospedagem();
             
             //Recupera o id do banco e atribui ele ao objeto
             hospedagem.setId(rset.getInt("id"));
             hospedagem.setCidade(rset.getString("cidade"));
             hospedagem.setEstado(rset.getString("estado"));
             hospedagem.setTipo(rset.getString("tipo"));
             hospedagem.setValorDiaria(rset.getFloat("valorDiaria"));
             hospedagem.setEndereco(rset.getString("endereco"));
             hospedagem.setTelefone(rset.getString("telefone"));
             hospedagem.setNome(rset.getString("nome"));
             
             //Adiciono o contato recuperado, a lista de contatos
             hospedagens.add(hospedagem);
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
        return hospedagens;
    }
}
