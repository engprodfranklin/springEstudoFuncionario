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
@Table(name = "cargos")
public class Cargos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cargos;

	@Column(length = 100, nullable = true)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "cargos")
	private List<Funcionarios> funcionarios = new ArrayList<>();

	public Cargos() {
	}

	public Cargos(Integer id_cargos, String nome) {
		super();
		this.id_cargos = id_cargos;
		this.nome = nome;
	}

	public Integer getId_cargos() {
		return id_cargos;
	}

	public void setId_cargos(Integer id_cargos) {
		this.id_cargos = id_cargos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Lista get para funcionarios
	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

}
