/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import ConectaBanco.ConnectionDB;
import agencia.model.Passagem;
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
public class PassagemDAO {
     public void save(Passagem passagem){
        /*
         * Isso é uma sql comum, os ? são os parametros que nós vamos adicionar na base de dados
         */

        String sql = "INSERT INTO passagem(pacotePromo,dataViagem,idUsuario,idDestino,valor)" + " VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parametro da sql
            pstm.setInt(1, passagem.getPacotePromo());
            pstm.setDate(2, new Date(passagem.getDataViagem().getTime()));
            pstm.setInt(3, passagem.getIdUsuario());
            pstm.setInt(4, passagem.getIdDestino());
            pstm.setFloat(5, passagem.getValor());

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
        String sql = "DELETE FROM passagem WHERE id = ?";
        
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
    
    public void update(Passagem passagem){
        String sql = "UPDATE passagem SET pacotePromo = ?, dataViagem = ?, idUsuario = ?, idDestino = ?, valor = ?" + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //Cria uma conexão com o banco de dados
            conn = ConnectionDB.createConnectionToMySQL();
            
            //Cria uma PreparedStatement, classe usada oara executar a query
            pstm = conn.prepareStatement(sql);
            
            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setInt(1, passagem.getPacotePromo());
            pstm.setDate(2, new Date(passagem.getDataViagem().getTime()));
            pstm.setInt(3, passagem.getIdUsuario());
            pstm.setInt(4, passagem.getIdDestino());
            pstm.setFloat(5, passagem.getValor());
            pstm.setInt(6, passagem.getId());
            
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
    
    public List<Passagem> getPassagens(){
        
        String sql = "SELECT * FROM passagem";
        
        List<Passagem> passagens = new ArrayList<>();
        
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
             Passagem passagem = new Passagem();
             
             //Recupera o id do banco e atribui ele ao objeto
             passagem.setId(rset.getInt("id"));
             passagem.setPacotePromo(rset.getInt("pacotePromo"));
             passagem.setDataViagem(rset.getDate("dataViagem"));
             passagem.setIdUsuario(rset.getInt("idUsuario"));
             passagem.setIdDestino(rset.getInt("idDestino"));
             passagem.setValor(rset.getFloat("valor"));
             
             
             //Adiciono o contato recuperado, a lista de contatos
             passagens.add(passagem);
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
        return passagens;
    }
}
