package com.br.franklin.springEstudo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.franklin.springEstudo.entities.Cargos;
import com.br.franklin.springEstudo.entities.Despesas;
import com.br.franklin.springEstudo.entities.Funcionarios;
import com.br.franklin.springEstudo.entities.Setores;
import com.br.franklin.springEstudo.repository.CargosRepository;
import com.br.franklin.springEstudo.repository.DespesasRepository;
import com.br.franklin.springEstudo.repository.FuncionariosRepository;
import com.br.franklin.springEstudo.repository.SetoresRepository;

@SpringBootApplication
public class SpringEstudoApplication implements CommandLineRunner {

	// Colocar aqui as injeções de Dependência dos Repository
	@Autowired
	private SetoresRepository setoresRepository;

	@Autowired
	private FuncionariosRepository funcionariosRepository;

	@Autowired
	private CargosRepository cargosRepository;

	@Autowired
	private DespesasRepository despesasRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringEstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Setores set1 = new Setores("Informártica", 2000.0);
		Setores set2 = new Setores("Administrativo", 2580.0);
		Setores set3 = new Setores("Serviços Gerais", 1478.0);

		Cargos carg1 = new Cargos(null, "Auxiliar Administrativo");
		Cargos carg2 = new Cargos(null, "Analista de TI");
		Cargos carg3 = new Cargos(null, "Auxiliar de Limpeza");

		Funcionarios func1 = new Funcionarios("Franklin", 'M', "000.000-00", 2300.0, set1, carg2);
		Funcionarios func2 = new Funcionarios("Regina", 'F', "111.111-11", 5894.0, set2, carg1);
		Funcionarios func3 = new Funcionarios("Ligiane", 'F', "222.222-22", 1852.0, set3, carg3);

		set1.getFuncionarios().addAll(Arrays.asList(func1));
		set2.getFuncionarios().addAll(Arrays.asList(func2));
		set3.getFuncionarios().addAll(Arrays.asList(func3));

		carg1.getFuncionarios().addAll(Arrays.asList(func2));
		carg2.getFuncionarios().addAll(Arrays.asList(func1));
		carg3.getFuncionarios().addAll(Arrays.asList(func3));

		Despesas desp1 = new Despesas("10/01/2022", 3000.0, "Notebook", set1, func1);
		Despesas desp2 = new Despesas("04/03/2022", 3200.0, "Papel A4, Notebook, Caneta", set2, func2);
		Despesas desp3 = new Despesas("20/06/2022", 150.0, "Pano de chão, Material de Limpeza", set3, func3);
		
		// Salvar todos os dados
		setoresRepository.save(set1);
		setoresRepository.save(set2);
		setoresRepository.save(set3);

		cargosRepository.save(carg1);
		cargosRepository.save(carg2);
		cargosRepository.save(carg3);

		funcionariosRepository.save(func1);
		funcionariosRepository.save(func2);
		funcionariosRepository.save(func3);
		
		despesasRepository.save(desp1);
		despesasRepository.save(desp2);
		despesasRepository.save(desp3);
	}

}
