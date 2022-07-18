package com.br.franklin.springEstudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.franklin.springEstudo.entities.Cargos;
import com.br.franklin.springEstudo.repository.CargosRepository;

@RestController
@RequestMapping(value = "/cargos")
public class CargosControllers {

	@Autowired
	private CargosRepository cargosRepository;

	@GetMapping
	public ResponseEntity<List<Cargos>> findAll() {
		List<Cargos> carg = cargosRepository.findAll();
		return ResponseEntity.ok().body(carg);
	}
	
	@GetMapping(value = "/{id_cargos}")
	public ResponseEntity<Cargos> findById(@PathVariable Integer id_cargos){
		Cargos id = cargosRepository.findById(id_cargos).get();
		return ResponseEntity.ok().body(id);
	}
}
