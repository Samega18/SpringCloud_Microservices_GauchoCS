package com.samuel.scherf.clientesbarp2;

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
public class ClientesController {

	@Autowired
	private ClientesService clientesService;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public ResponseEntity< List<Clientes> > listarClientes() {

		List<Clientes> listaClientes = clientesService.listarTodosClientes();

		return new ResponseEntity<List<Clientes>>(listaClientes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clientes> obterUsuario(@PathVariable int id) {

		Optional<Clientes> cliente = clientesService.buscarClientesPorId(id);

		if (cliente == null) {
			return new ResponseEntity<Clientes>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Clientes>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/clienteCreate", method = RequestMethod.POST)
	public ResponseEntity<Clientes> criarUsuario(@RequestBody Clientes cliente) throws UserAlreadyExistsException {

		try {
			Clientes clienteInserido = clientesService.inserirClientes(cliente);
			
			return new ResponseEntity<Clientes>(clienteInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Clientes>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ClientesService getUserService() {
		return clientesService;
	}

	public void setClientesService(ClientesService clientesService) {
		this.clientesService = clientesService;
	}

}