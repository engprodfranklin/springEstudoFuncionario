package com.br.franklin.springEstudo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcionarios;

	@Column(length = 255, nullable = true, unique = true)
	private String nome;

	@Column
	private char sexo;

	@Column(length = 50, nullable = true)
	private String cpf;

	@Column(nullable = true)
	private Double salario;

	// Construtor vazio
	public Funcionarios() {
	}

	// Modelo para fazer chave estrangeira, quem recebe a chave estrangeira
	// Definir o tipo de relacionamento que eu quero
	// Significa que existem Muitos funcionários para 1 setor: @ManyToOne
	// Identificação da chave estrangeira: @JoinColumn(name = "fk_funcionario_setor")
	// Informe a relação com a outra tabela: private Setores setores;
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario_setor")
	private Setores setores;

	@JsonIgnore
	@OneToMany(mappedBy = "funcionarios")
	private List<Despesas> despesas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario_cargo")
	private Cargos cargos;

	public Funcionarios(String nome, char sexo, String cpf, Double salario, Setores setores, Cargos cargos) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.salario = salario;
		this.setores = setores;
		this.cargos = cargos;
	}

	public Integer getId_funcionarios() {
		return id_funcionarios;
	}

	public void setId_funcionarios(Integer id_funcionarios) {
		this.id_funcionarios = id_funcionarios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Setores getSetores() {
		return setores;
	}

	public void setSetores(Setores setores) {
		this.setores = setores;
	}

	public Cargos getCargos() {
		return cargos;
	}

	public void setCargos(Cargos cargos) {
		this.cargos = cargos;
	}

	// Lista de Despesas
	public List<Despesas> getDespesas() {
		return despesas;
	}

}
