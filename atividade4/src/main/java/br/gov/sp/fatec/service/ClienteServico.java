package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	
	@Transactional	
	public Collection<Cliente> clientePorNome(String nome) {
		
		List<Cliente> retorno = new ArrayList<Cliente>();
		
//		Cliente cliente = new Cliente();			
//		
//		cliente.setNome(clienteRepo.findByNome(nome).getNome());
//		cliente.setCpf(clienteRepo.findByNome(nome).getCpf());
//		retorno.add(cliente);
		
		retorno.add(clienteRepo.findByNome(nome));
		
		return retorno;
	}
	
	@Transactional
	public String clientePorSegmento(String segmento) {
		
		String nomes = "Cliente(s): ";
		
		for(Cliente cli: clienteRepo.buscaCliente(segmento)) {
						
			nomes += " " + cli.getNome();
		}
		
		return nomes;
	}
}
