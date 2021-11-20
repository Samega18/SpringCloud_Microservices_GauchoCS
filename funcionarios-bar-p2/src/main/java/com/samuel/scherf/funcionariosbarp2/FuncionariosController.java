package com.samuel.scherf.funcionariosbarp2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FuncionariosController {

	@Autowired
	private FuncionariosService funcionariosService;

	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ResponseEntity< List<Funcionarios> > listarUsuarios() {

		List<Funcionarios> listaFuncionarios = funcionariosService.listarTodosFuncionarios();

		return new ResponseEntity<List<Funcionarios>>(listaFuncionarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Funcionarios> obterUsuario(@PathVariable int id) {

		Optional<Funcionarios> funcionario = funcionariosService.buscarFuncionariosPorId(id);

		if (funcionario == null) {
			return new ResponseEntity<Funcionarios>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Funcionarios>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/funcionarioCreate", method = RequestMethod.POST)
	public ResponseEntity<Funcionarios> criarFuncionario(@RequestBody Funcionarios funcionario) throws UserAlreadyExistsException {

		try {
			Funcionarios funcionarioInserido = funcionariosService.inserirFuncionarios(funcionario);
			
			return new ResponseEntity<Funcionarios>(funcionarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Funcionarios>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public FuncionariosService getFuncionariosService() {
		return funcionariosService;
	}

	public void setFuncionariosService(FuncionariosService funcionariosService) {
		this.funcionariosService = funcionariosService;
	}

}