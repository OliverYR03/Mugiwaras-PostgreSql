package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.*;

public interface PlatosRepositorio extends CrudRepository<Platos, Integer>{
	
		@Query(value = "SELECT a FROM Platos a WHERE a.nombre=?1")
		public List<Platos> buscarPlatosPorNombre(String nombre);
		
		@Query(value = "SELECT a FROM Platos a WHERE a.nombre like CONCAT (?1, '%')")
		public List<Platos> buscarPlatosLikeNombre(String nombre);
		

}
