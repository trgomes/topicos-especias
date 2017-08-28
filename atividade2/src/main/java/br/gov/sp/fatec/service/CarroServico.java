package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.CarroRepository;

@Service("carroServico")
public class CarroServico {	
	
	@Autowired
	private CarroRepository carroRepo;
	
	
	public void salvaCarro(Carro carro, Cliente cliente) {
		carro.setCliente(cliente);
		carroRepo.save(carro);
	}

}
