package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sun.nio.cs.MS1250;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		Placa obj = (Placa) context.getBean("placa");
		System.out.println(obj.ler());
		
		HelloWorld msg1 = (HelloWorld) context.getBean("mensagem");
		System.out.println(msg1.getMensagem());
		msg1.setNome("Teste");
		
		HelloWorld msg2 = (HelloWorld)context.getBean("mensagem");
		System.out.println(msg2.getMensagem());
		
		HelloWorld msg3 = (HelloWorld)context.getBean("mensagem2");
		System.out.println(msg3.getMensagem());
		msg3.setNome("Teste");
		
		HelloWorld msg4 = (HelloWorld)context.getBean("mensagem2");
		System.out.println(msg4.getMensagem());
		
		((AbstractApplicationContext) context).close();
		
	}
}
