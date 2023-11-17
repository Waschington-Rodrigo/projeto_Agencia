/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.model;

import java.util.Date;

/**
 *
 * @author Waschington Rodrigo
 */
public class Usuario {
    private int id ;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String endereco;
    private String estado;
    private String cidade;
    
    public Usuario(){
        super();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCPf(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
}
