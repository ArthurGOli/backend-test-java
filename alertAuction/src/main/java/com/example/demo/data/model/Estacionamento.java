package com.example.demo.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private Integer idEstabelecimento;
	private Integer idVeiculo;
	private Date entradaEstacionamento;
	
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
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Date getEntradaEstacionamento() {
		return entradaEstacionamento;
	}
	public void setEntradaEstacionamento(Date entradaEstacionamento) {
		this.entradaEstacionamento = entradaEstacionamento;
	}
	
}
