package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runners.MethodSorters;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Rollback
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteRepositoyTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private ClienteRepository cliRepo;
	
	
	public void setClienteRepository(ClienteRepository cliRepo) {
		
		this.cliRepo = cliRepo;
		
	}
			
	
	@Test
	public void aTestInsert() {	
		Cliente cli = new Cliente("fany", "444.444.444-45");
		cliRepo.save(cli);
		assertTrue(cli.getId() != null);		
	}
	
	
	@Test	
	public void bTestConsulta() {		
	
		String nomes = "";

		for(Cliente c: cliRepo.buscaCliente("go")) {
			nomes += c.getNome();
		}
			
		assertEquals("Thiago", nomes);
		
	}
	
	@Test
	public void cExcluirCliente() {
		
		Cliente cli = new Cliente("fany", "444.444.444-45");
		cliRepo.save(cli);
		cliRepo.delete(cli);
		
		String nomes = "";

		for(Cliente c: cliRepo.buscaCliente("ny")) {
			nomes += c.getNome();
		}
		
		assertEquals("", nomes);
	}

	
}
