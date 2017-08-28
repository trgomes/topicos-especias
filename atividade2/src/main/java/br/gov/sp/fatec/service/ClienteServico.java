package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;

@Service("clienteServico")
public class ClienteServico {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public void salvaCliente(Cliente cliente) {
		clienteRepo.save(cliente);
	}
	
}
