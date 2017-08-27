package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Carro;


public interface CarroRepository extends CrudRepository<Carro, Long>{

	public Carro findByMarca(String marca);	

	@Query("select c from Carro c where c.modelo like %?1%")
	public List<Carro> buscaCarro(String modelo);
}
