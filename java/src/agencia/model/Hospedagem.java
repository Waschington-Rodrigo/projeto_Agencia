/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.model;

/**
 *
 * @author Waschington Rodrigo
 */
public class Hospedagem {
    private int id ;
    private String nome;
    private String cidade;
    private String estado;
    private String endereco;
    private String tipo;
    private String telefone;
    private double valorDiaria;
    
    public Hospedagem(){
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
    
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
     
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    } 
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public double getValorDiaria(){
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
}
