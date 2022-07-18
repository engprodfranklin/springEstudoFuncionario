package com.br.franklin.springEstudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.franklin.springEstudo.entities.Funcionarios;
import com.br.franklin.springEstudo.repository.FuncionariosRepository;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionariosControllers {

	@Autowired
	private FuncionariosRepository funcionariosRepository;

	@GetMapping
	public ResponseEntity<List<Funcionarios>> findAll() {
		List<Funcionarios> list = funcionariosRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id_funcionarios}")
	public ResponseEntity<Funcionarios> findById(@PathVariable Integer id_funcionarios) {
		Funcionarios func = funcionariosRepository.findById(id_funcionarios).get();
		return ResponseEntity.ok().body(func);
	}

}