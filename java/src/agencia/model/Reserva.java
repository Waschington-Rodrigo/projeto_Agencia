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
public class Reserva {
    	private int id;
	private int qtdDias;
	private Date dataReserva;
	private int pacotePromo;
	private float valorTotal;
	private int idHospedagem;
	private int idUsuario;

	public Reserva() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getPacotePromo() {
		return pacotePromo;
	}

	public void setPacotePromo(int pacotePromo) {
		this.pacotePromo = pacotePromo;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
