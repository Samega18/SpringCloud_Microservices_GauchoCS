package com.samuel.scherf.clientesbarp2;

import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes ,Integer>{
	
	public Clientes findByCpf(int cpf);
	
}
