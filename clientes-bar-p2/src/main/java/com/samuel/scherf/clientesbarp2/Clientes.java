package com.samuel.scherf.clientesbarp2;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {
	
	@Id
	private int cpf;
	private String name;
	private String password;
	private String email;
	public int getCpf() {
		// TODO Auto-generated method stub
		return cpf;
	}

}
