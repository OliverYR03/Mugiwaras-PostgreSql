package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Clientes;


public interface ClientesRepositorio extends CrudRepository<Clientes, Integer> {

	@Query(value = "SELECT a FROM Clientes a WHERE a.nombre =?1")
	public List<Clientes> buscarClientesPorNombre(String nombre);
	
	
	@Query(value = "SELECT a FROM Clientes a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Clientes> buscarClienteLikeNombre(String nombre);
}
