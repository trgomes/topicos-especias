package br.gov.sp.fatec;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"); 

    	// Carros
    	Carro carro = (Carro) context.getBean("carro");
    	System.out.println(carro);     
    	
    	Carro carro2 = (Carro) context.getBean("carro2");
    	System.out.println(carro2);
    	
    	// Clientes
    	Cliente cliente = (Cliente)  context.getBean("cliente");
    	System.out.println(cliente);
    	
    	Cliente cliente2 = (Cliente)  context.getBean("cliente2");
    	System.out.println(cliente2);
    	
    	// Oficina
    	Oficina oficina = (Oficina) context.getBean("oficina");
    	System.out.println(oficina);
		
		((AbstractApplicationContext) context).close();
    }
}
