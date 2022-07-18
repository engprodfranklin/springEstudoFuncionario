package com.br.franklin.springEstudo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_setores")
public class Setores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id_setores;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column
	private Double orcamento;

	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Funcionarios> funcionarios = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Despesas> despesas = new ArrayList<>();
	
	// Construtor Vazio
	public Setores() {
	}

	public Setores(String nome, Double orcamento) {
		super();
		this.nome = nome;
		this.orcamento = orcamento;
	}

	public Integer getId_setores() {
		return id_setores;
	}

	public void setId_setores(Integer id_setores) {
		this.id_setores = id_setores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	//Lista de Despesas
	public List<Despesas> getDespesas() {
		return despesas;
	}

	//Lista de Funcionarios
	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}
	
}
