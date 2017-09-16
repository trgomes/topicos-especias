package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;

@Service("clienteServico")
public class ClienteServico {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Transactional
	public void salvaCliente(Cliente cliente) {
		clienteRepo.save(cliente);
	}
	
	
	public String clientePorNome(String nome) {
		
		return clienteRepo.findByNome(nome).getNome();	
		
	}
	
	public String clientePorSegmento(String segmento) {
		
		String nomes = "";
		
		for(Cliente cli: clienteRepo.buscaCliente(segmento)) {
						
			nomes +=  cli.getNome();
		}
		
		return nomes;
	}
}
