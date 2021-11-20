package com.samuel.scherf.clientesbarp2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ClientesService {

	@Autowired
	private ClientesRepository repository;

	public Optional<Clientes> buscarClientesPorId(int id) {
		return repository.findById(id);
	}

	public List<Clientes> listarTodosClientes() {
		return (List<Clientes>) repository.findAll();
	}

	@Transactional
	public Clientes inserirClientes(Clientes cliente) {

		Clientes existing = repository.findByCpf(cliente.getCpf());

		return repository.save(cliente);
	}

	public ClientesRepository getRepository() {
		return repository;
	}

	public void setRepository(ClientesRepository repository) {
		this.repository = repository;
	}

}