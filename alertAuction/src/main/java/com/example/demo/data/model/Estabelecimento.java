package com.example.demo.data.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Estabelecimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="estabelecimento_seq", sequenceName="estabelecimento_sequence", initialValue=1)
	private Integer id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private Integer qtdVagaCarro;
	private Integer qtdVagaMoto;
	
	@OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "id")
	private Set<Veiculo> veiculos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getQtdVagaCarro() {
		return qtdVagaCarro;
	}
	public void setQtdVagaCarro(Integer qtdVagaCarro) {
		this.qtdVagaCarro = qtdVagaCarro;
	}
	public Integer getQtdVagaMoto() {
		return qtdVagaMoto;
	}
	public void setQtdVagaMoto(Integer qtdVagaMoto) {
		this.qtdVagaMoto = qtdVagaMoto;
	}
	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
