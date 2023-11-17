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
public class Passagem {
    private int id;
    private int pacotePromo;
    private Date dataViagem;
    private int idUsuario;
    private int idDestino;
    private float valor ;
    
    public Passagem(){
        super();
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPacotePromo() {
		return pacotePromo;
	}

	public void setPacotePromo(int pacotePromo) {
		this.pacotePromo = pacotePromo;
	}

	public Date getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
