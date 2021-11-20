package com.samuel.scherf.produtosbarp2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProdutosService {

	@Autowired
	private ProdutosRepository repository;

	public Optional<Produtos> buscarProdutosPorId(int id) {
		return repository.findById(id);
	}

	public List<Produtos> listarTodosProdutos() {
		return (List<Produtos>) repository.findAll();
	}

	@Transactional
	public Produtos inserirProdutos(Produtos produto) {

		Produtos existing = repository.findByName(produto.getName());

		return repository.save(produto);
	}

	public ProdutosRepository getRepository() {
		return repository;
	}

	public void setRepository(ProdutosRepository repository) {
		this.repository = repository;
	}

}