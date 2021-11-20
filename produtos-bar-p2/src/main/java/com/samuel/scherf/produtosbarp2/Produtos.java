package com.samuel.scherf.produtosbarp2;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {
	
	@Id
	private int id;
	private String name;
	private String qtdProduto;
	private String fornecedor;
	private String preco;
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
