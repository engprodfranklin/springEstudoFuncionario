package com.br.franklin.springEstudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.franklin.springEstudo.entities.Funcionarios;

//extends JpaRepository<Nome da entidade, Tipo primito do ID>

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {

}
