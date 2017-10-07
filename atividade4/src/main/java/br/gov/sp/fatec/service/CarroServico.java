package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.CarroRepository;

@Service("carroServico")
public class CarroServico {	
	
	@Autowired
	private CarroRepository carroRepo;
	
	@Transactional
	public void salvaCarro(Carro carro, Cliente cliente) {
		carro.setCliente(cliente);
		carroRepo.save(carro);		
	}
	
	public String modeloPorMarca(String marca) {
		
		return carroRepo.findByMarca("Chevrolet").getModelo();	
		
	}
	
	
	// segmento de marca
	public String modeloPorSegmento(String marca) {
		
		String modelo = "Modelos de carros: ";
		
		for(Carro car: carroRepo.buscaCarro("or")) {
			System.out.println("Cliente por segmento: " + car.getModelo());		
			modelo += " " + car.getModelo();
			
		}
		
		return modelo;
		
	}
	
	public String clientePorModelo(String modelo) {		
		
		return carroRepo.getByModelo(modelo).getCliente().getNome();
		
	}
	
	
	
	

}
