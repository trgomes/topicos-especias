package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Cliente;


public interface CarroRepository extends CrudRepository<Carro, Long>{

	public Carro findByMarca(String marca);	
	
	@Transactional
	@Query("select c from Carro c where c.modelo like %?1%")
	public List<Carro> buscaCarro(String modelo);
	
	@Transactional
	@Query("Select c.cliente FROM Carro c where c.modelo like %?1%")
	public List<Cliente> getByModelo(String modelo);
}
