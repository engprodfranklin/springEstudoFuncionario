package com.br.franklin.springEstudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.franklin.springEstudo.entities.Setores;
import com.br.franklin.springEstudo.repository.SetoresRepository;

@RestController
@RequestMapping(value = "/setores")
public class SetoresControllers {

	// Preciso do Repository de Setores
	@Autowired
	private SetoresRepository setoresRepository;

	@GetMapping
	public ResponseEntity<List<Setores>> findAll() {
		List<Setores> list = setoresRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id_setores}")
	public ResponseEntity<Setores> findById(@PathVariable Integer id_setores){
		Setores setor = setoresRepository.findById(id_setores).get();
		return ResponseEntity.ok().body(setor);	
	}

}
