package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Ordenes;

public interface OrdenesRepositorio extends CrudRepository<Ordenes, Integer> {
	@Query(value = "SELECT a FROM Ordenes a WHERE a.platos=?1")
	public List<Ordenes> buscarOrdenesPorIdcliente(Integer idcliente);
	
	@Query(value = "SELECT a FROM Ordenes a WHERE a.platos like CONCAT (?1, '%')")
	public List<Ordenes> buscarOrdenesLikeIdcliente(Integer idcliente);
}
