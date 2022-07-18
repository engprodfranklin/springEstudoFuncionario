package com.br.franklin.springEstudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.franklin.springEstudo.entities.Despesas;

import com.br.franklin.springEstudo.repository.DespesasRepository;

@RestController
@RequestMapping(value = "/despesas")
public class DespesasControllers {
	
	@Autowired
	private DespesasRepository despesasRepository;
	
	@GetMapping
	public ResponseEntity<List<Despesas>> findAll(){
		List<Despesas> list = despesasRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id_despesas}")
	public ResponseEntity<Despesas> findById(@PathVariable Integer id_despesas){
		Despesas desp = despesasRepository.findById(id_despesas).get();
		return ResponseEntity.ok().body(desp);	
	}
	
	
}
