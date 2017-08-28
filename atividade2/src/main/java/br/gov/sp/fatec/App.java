package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.SegurancaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	// Recupera os repositorios
		CarroRepository carroRepo = (CarroRepository) context.getBean("carroRepository");
		ClienteRepository clienteRepo = (ClienteRepository) context.getBean("clienteRepository");
		
		//Criar clientes
		//Cliente cliente1 = new Cliente("Thiago", "999.999.999-99");
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Thiago");
		cliente2.setCpf("888.888.888-88");
		
		clienteRepo.save(cliente2);
		
		
		//Criar carros
		Carro carro1 = new Carro("Chevrolet", "Corsa", "Azul", "AAA-9999");
		Carro carro2 = new Carro("Fiat", "Uno", "Branco", "BBB-9999");			
		
		carro1.setCliente(cliente2);
		carro2.setCliente(cliente2);			
		
		carroRepo.save(carro1);
		carroRepo.save(carro2);		
		
		//Consultas cliente
		System.out.println("Resultado da busca de cliente por nome: " + clienteRepo.findByNome("Thiago").getNome());
		
		for(Cliente cli: clienteRepo.buscaCliente("oa")) {
			System.out.println("Cliente por segmento: " + cli.getNome());
		}
		
		//Consulta carro
		System.out.println("Resultado da busca de carro por nome: " + carroRepo.findByMarca("Chevrolet").getMarca());
		
		for(Carro car: carroRepo.buscaCarro("or")) {
			System.out.println("Cliente por segmento: " + car.getModelo());
		}
		
		
		//Transação
		SegurancaService seg = (SegurancaService)context.getBean("segurancaService");
		
		try {
			seg.transacao();
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
    }
}
