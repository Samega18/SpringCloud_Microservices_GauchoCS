package com.samuel.scherf.produtosbarp2;

import org.springframework.data.repository.CrudRepository;

public interface ProdutosRepository extends CrudRepository<Produtos ,Integer>{
	
	public Produtos findByName(String name);
	
}
