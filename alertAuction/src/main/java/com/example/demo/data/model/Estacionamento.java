package com.example.demo.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private Integer idVeiculo;
	private Integer idEstabelecimento;
	private Date dtEntradaEstacionamento;
	private Date dtSaidaEstacionamento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEstabelecimento() {
		return idEstabelecimento;
	}
	public void setIdEstabelecimento(Integer idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}
	public Date getDtEntradaEstacionamento() {
		return dtEntradaEstacionamento;
	}
	public void setDtEntradaEstacionamento(Date dtEntradaEstacionamento) {
		this.dtEntradaEstacionamento = dtEntradaEstacionamento;
	}
	public Date getDtSaidaEstacionamento() {
		return dtSaidaEstacionamento;
	}
	public void setDtSaidaEstacionamento(Date dtSaidaEstacionamento) {
		this.dtSaidaEstacionamento = dtSaidaEstacionamento;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
}
