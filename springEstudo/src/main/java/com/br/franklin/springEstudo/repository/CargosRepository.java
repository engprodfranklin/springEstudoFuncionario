package com.br.franklin.springEstudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.franklin.springEstudo.entities.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer>{

}
