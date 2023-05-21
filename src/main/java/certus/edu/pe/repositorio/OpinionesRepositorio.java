package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Opiniones;

public interface OpinionesRepositorio extends CrudRepository<Opiniones, Integer> {
	@Query(value = "SELECT a FROM Opiniones a WHERE a.fecha=?1")
	public List<Opiniones> buscarOpinionesPorIdCliente(Integer idcliente);
	
	@Query(value = "SELECT a FROM Opiniones a WHERE a.fecha like CONCAT (?1, '%')")
	public List<Opiniones> buscarOpinionesLikeIdCliente(Integer idcliente);

}
