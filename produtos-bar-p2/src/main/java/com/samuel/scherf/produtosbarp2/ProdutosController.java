package com.samuel.scherf.produtosbarp2;

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
public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;

	@RequestMapping(value = "/produto", method = RequestMethod.GET)
	public ResponseEntity< List<Produtos> > listarProdutos() {

		List<Produtos> listaProdutos = produtosService.listarTodosProdutos();

		return new ResponseEntity<List<Produtos>>(listaProdutos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produtos> obterProduto(@PathVariable int id) {

		Optional<Produtos> produto = produtosService.buscarProdutosPorId(id);

		if (produto == null) {
			return new ResponseEntity<Produtos>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Produtos>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/produtoCreate", method = RequestMethod.POST)
	public ResponseEntity<Produtos> criarProduto(@RequestBody Produtos produto) throws UserAlreadyExistsException {

		try {
			Produtos produtoInserido = produtosService.inserirProdutos(produto);
			
			return new ResponseEntity<Produtos>(produtoInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Produtos>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ProdutosService getProdutosService() {
		return produtosService;
	}

	public void setProdutosService(ProdutosService produtosService) {
		this.produtosService = produtosService;
	}

}