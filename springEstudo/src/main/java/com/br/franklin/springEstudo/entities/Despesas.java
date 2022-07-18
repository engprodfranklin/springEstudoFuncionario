package com.br.franklin.springEstudo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_despesas")
public class Despesas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_despesa;
	
	@Column(nullable = true)
	private String data_despesa;
	
	@Column(nullable = true)
	private Double valor_despesa;
	
	@Column(length = 255)
	private String descricao;
	
	public Despesas() {}

	@ManyToOne
	@JoinColumn(name = "fk_despesas_setor")
	private Setores setores;
	
	@ManyToOne
	@JoinColumn(name = "fk_despesas_funcionarios")
	private Funcionarios funcionarios;
	
	
	public Despesas(String data_despesa, Double valor_despesa, String descricao, Setores setores, Funcionarios funcionarios) {
		super();
		this.data_despesa = data_despesa;
		this.valor_despesa = valor_despesa;
		this.descricao = descricao;
		this.setores = setores;
		this.funcionarios = funcionarios;
	}

	public String getData_despesa() {
		return data_despesa;
	}

	public void setData_despesa(String data_despesa) {
		this.data_despesa = data_despesa;
	}

	public Double getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(Double valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
