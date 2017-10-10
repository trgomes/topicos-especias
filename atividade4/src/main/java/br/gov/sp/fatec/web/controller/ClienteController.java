package br.gov.sp.fatec.web.controller;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.service.ClienteServico;
import br.gov.sp.fatec.view.View;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteServico clienteServico;
	

	public void setClienteServico(ClienteServico clienteServico) {
		this.clienteServico = clienteServico;
	}


	@RequestMapping(value = "/")
	public String hello()
	{
		return "O mapeamento Cliente está funcionando!";
	}
	
	
	@RequestMapping(value = "/cliente/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Cliente> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Cliente cliente = clienteServico.clientePorId(id);
		if(cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
		
	
	@RequestMapping(value = "/cliente/get/{nome}") //Rota que pode retornar mais de um registro
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public ResponseEntity <Collection<Cliente>> pesquisar(@PathVariable("nome") String nome) 
	{			
		// Seria possivel incluir um try/catch e retornar um HttpStatus.INTERNAL_SERVER_ERROR, por exemplo
		return new ResponseEntity<Collection <Cliente>>(clienteServico.clientePorNome(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente/getAll") // Rota que retorna todos os clientes
	@JsonView(View.Main.class)
	public ResponseEntity<Collection<Cliente>> getAll() {
		return new ResponseEntity<Collection<Cliente>>(clienteServico.getAllClientes(), HttpStatus.OK);
	}
	
	
	// Salva o cliente
	@RequestMapping(value = "/cliente/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)	
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente, HttpServletRequest request, HttpServletResponse response) {
		cliente = clienteServico.salvaCliente(cliente);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/cliente/getById?id=" + cliente.getId());
		return cliente;
	}	
	
	
}
