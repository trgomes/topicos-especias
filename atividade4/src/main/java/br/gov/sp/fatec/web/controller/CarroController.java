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

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.service.CarroServico;

import br.gov.sp.fatec.view.View;


@RestController
public class CarroController {
	
	@Autowired
	private CarroServico carroServico;
	

	public void setClienteServico(CarroServico carroServico) {
		this.carroServico = carroServico;
	}
	
	@RequestMapping(value = "/carro/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Carro> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Carro carro = carroServico.carroPorId(id);
		if(carro == null) {
			return new ResponseEntity<Carro>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/carro/getCliente/{modelo}") //Rota que pode retornar mais de um registro
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public ResponseEntity <Collection<Cliente>> pesquisar(@PathVariable("modelo") String modelo) 
	{			
		// Seria possivel incluir um try/catch e retornar um HttpStatus.INTERNAL_SERVER_ERROR, por exemplo
		return new ResponseEntity<Collection <Cliente>>(carroServico.clientePorModelo(modelo), HttpStatus.OK);
	}

	
	 //Salva o cliente
	@RequestMapping(value = "/carro/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)	
	@ResponseStatus(HttpStatus.CREATED)
	public Carro save(@RequestBody Carro carro, HttpServletRequest request, HttpServletResponse response) {
		carro = carroServico.salvaCarro(carro);;
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/carro/getById?id=" + carro.getId());
		return carro;
	}
	
	
	
}
