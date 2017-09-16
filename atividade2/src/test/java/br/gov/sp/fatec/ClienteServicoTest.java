package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteServico;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Rollback
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteServicoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private ClienteServico cliServico;

	public void setClienteServicoTest(ClienteServico cliServico) {		
		this.cliServico = cliServico;
	}
	
	@Test
	public void aTestInsert() {	
		Cliente cli = new Cliente("fany", "444.444.444-45");
		cliServico.salvaCliente(cli);
		assertTrue(cli.getId() != null);		
	}
	
	
	@Test	
	public void bTestConsultaSegmento() {		
			
		assertEquals("Thiago", cliServico.clientePorSegmento("go"));		
	}
	
	@Test
	public void cTestConsultaNome() {		
		assertEquals("Thiago", cliServico.clientePorNome("Thiago"));
	}
	
	

}
