package com.samuel.scherf.funcionariosbarp2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class FuncionariosService {

	@Autowired
	private FuncionariosRepository repository;

	public Optional<Funcionarios> buscarFuncionariosPorId(int id) {
		return repository.findById(id);
	}

	public List<Funcionarios> listarTodosFuncionarios() {
		return (List<Funcionarios>) repository.findAll();
	}

	@Transactional
	public Funcionarios inserirFuncionarios(Funcionarios funcionario) {

		Funcionarios existing = repository.findByCpf(funcionario.getCpf());

		return repository.save(funcionario);
	}

	public FuncionariosRepository getRepository() {
		return repository;
	}

	public void setRepository(FuncionariosRepository repository) {
		this.repository = repository;
	}

}