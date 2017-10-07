package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	public Cliente findByNome(String nome);	

	@Query("select c from Cliente c where c.nome like %?1%")
	public List<Cliente> buscaCliente(String nome);
}
