package com.br.franklin.springEstudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.franklin.springEstudo.entities.Setores;

//extends JpaRepository<Nome da entidade, Tipo primito do ID>

@Repository
public interface SetoresRepository extends JpaRepository<Setores, Integer>{

}
