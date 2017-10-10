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
	public Cliente salvaCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	
	@Transactional
	public Cliente clientePorId(Long id) {
		return clienteRepo.findOne(id);
	}
	
	
	@Transactional	
	public Collection<Cliente> clientePorNome(String nome) {
		
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		retorno.add(clienteRepo.findByNome(nome));
		
		return retorno;
	}
	
	
	@Transactional
	public List<Cliente> getAllClientes(){
		
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		for(Cliente cliente: clienteRepo.findAll()) {
			retorno.add(cliente);
		}
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
