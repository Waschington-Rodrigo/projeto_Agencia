/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.model;

/**
 *
 * @author Waschington Rodrigo
 */
public class Destino {
    private int id;
    private String cidade;
    private String estado;
    private String localDestino;
    
    public Destino(){
        super();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    
    public String getLocalDestino(){
        return localDestino;
    }
    public void setLocalDestino(String localDestino){
        this.localDestino = localDestino;
    }
}
