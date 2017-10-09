package br.gov.sp.fatec.web.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value = "/cliente/get/{nome}")
	//@JsonView(View.Main.class)
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public ResponseEntity <Collection<Cliente>> pesquisar(@PathVariable("nome") String nome) 
	{			
		// Seria possivel incluir um try/catch e retornar um HttpStatus.INTERNAL_SERVER_ERROR, por exemplo
		return new ResponseEntity<Collection <Cliente>>(clienteServico.clientePorNome(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente")
	public String teste() {
		return "Thiago";
	}
	
	
}
