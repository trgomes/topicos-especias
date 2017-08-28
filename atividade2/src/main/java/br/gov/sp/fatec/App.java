package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.CarroServico;
import br.gov.sp.fatec.service.ClienteServico;
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
		Cliente cliente = new Cliente("Thiago", "888.888.888-88");
		
		ClienteServico clis = (ClienteServico)context.getBean("clienteServico");
		clis.salvaCliente(cliente);
		
		//Criar carros
		Carro carro1 = new Carro("Chevrolet", "Corsa", "Azul", "AAA-9999");
		Carro carro2 = new Carro("Fiat", "Uno", "Branco", "BBB-9999");
		
		CarroServico cars = (CarroServico)context.getBean("carroServico");
		cars.salvaCarro(carro1, cliente);
		cars.salvaCarro(carro2, cliente);
		
		
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
		
		
		System.out.println("Testando join ===> " + carroRepo.getByModelo("Uno").getCliente().getNome());
		
		
		
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
