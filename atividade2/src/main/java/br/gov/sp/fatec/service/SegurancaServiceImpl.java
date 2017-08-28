package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.ClienteRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private CarroRepository carroRepo;

	@Transactional
	public void transacao() {
		// Cria usuario
		Cliente cliente = new Cliente("Pedro", "777.777.777-78");
		//Salva cliente
		clienteRepo.save(cliente);
		
		//Cria carro
		Carro carro = new Carro("Ford", "Fiesta", "Branco", "TTT-1111");		
		//Adicionando dono ao Carro
		carro.setCliente(cliente);
		//Salva carro
		carroRepo.save(carro);
					
	}


	public void setClienteRepo(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

}
