package com.samuel.scherf.funcionariosbarp2;

import org.springframework.data.repository.CrudRepository;

public interface FuncionariosRepository extends CrudRepository<Funcionarios ,Integer>{
	
	public Funcionarios findByCpf(int cpf);
	
}
