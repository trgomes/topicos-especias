package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.service.CarroServico;
import br.gov.sp.fatec.service.ClienteServico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	

		//Criar clientes
		//Cliente cliente1 = new Cliente("Thiago", "999.999.999-99");
		Cliente cliente = new Cliente("Thiago", "888.888.888-88");
		
		ClienteServico clis = (ClienteServico)context.getBean("clienteServico");			
		
		try {
			clis.salvaCliente(cliente);
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
		
		//Criar carros
		Carro carro1 = new Carro("Chevrolet", "Corsa", "Azul", "AAA-9999");
		Carro carro2 = new Carro("Fiat", "Uno", "Branco", "BBB-9999");
		
		CarroServico cars = (CarroServico)context.getBean("carroServico");
		
		try {
			cars.salvaCarro(carro1, cliente);
			cars.salvaCarro(carro2, cliente);
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
				
		//Consultas cliente
		System.out.println(clis.clientePorNome("Thiago"));		
				
		System.out.println(clis.clientePorSegmento("go"));
		
		//Consulta carro
		System.out.println(cars.modeloPorMarca("Chevrolet"));
		
		System.out.println(cars.modeloPorSegmento("ro"));				
		
		// Cliente por modelo
		System.out.println(cars.clientePorModelo("Uno"));
		
		((AbstractApplicationContext) context).close();		
		
			
    }
}
