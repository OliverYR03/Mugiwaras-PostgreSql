 package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import certus.edu.pe.modelo.*;
import certus.edu.pe.repositorio.PlatosRepositorio;

@Service
@Transactional
public class PlatosServicio {

	@Autowired
	private PlatosRepositorio repositorio;
	
	public PlatosServicio() {
		
	}
	
	public List<Platos> buscarTodo(){
		return (List<Platos>) repositorio.findAll();
	}
	
	public Platos crear(Platos platos) {
		return repositorio.save(platos);
	
	}
	
	public Platos actualizar(Platos platoActualizar) {
		
		Platos platoActual = repositorio.findById(platoActualizar.getIdplato()).get();
		
		platoActual.setIdplato(platoActualizar.getIdplato());
		platoActual.setNombre(platoActualizar.getNombre());
		platoActual.setDescripcion(platoActualizar.getDescripcion());
		platoActual.setPrecio(platoActualizar.getPrecio());
		platoActual.setTipoplato(platoActualizar.getTipoplato());
		platoActual.setImagen(platoActualizar.getImagen());
		
		Platos platoActualizado = repositorio.save(platoActual);
		return platoActualizado;
	}
	
	public Platos buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
	
		repositorio.deleteById(id);
	}
}

