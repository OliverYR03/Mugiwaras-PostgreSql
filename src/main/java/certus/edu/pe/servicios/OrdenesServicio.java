package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Ordenes;
import certus.edu.pe.repositorio.OrdenesRepositorio;
import javax.transaction.Transactional;


@Service
@Transactional
public class OrdenesServicio {

	@Autowired
	private OrdenesRepositorio repositorio;
	
	public OrdenesServicio() {
		
	}
	
	public List<Ordenes> buscarTodo(){
		return (List<Ordenes>) repositorio.findAll();
	}
	

	public Ordenes crear (Ordenes ordenes) {
		return repositorio.save(ordenes);
	}
	

	public Ordenes actualizar(Ordenes ordenesActualizar) {
		Ordenes ordenesActual = repositorio.findById(ordenesActualizar.getIdorden()).get();
		
		ordenesActual.setIdorden(ordenesActualizar.getIdorden());
		ordenesActual.setIdcliente(ordenesActualizar.getIdcliente());
		ordenesActual.setFecha(ordenesActualizar.getFecha());
		ordenesActual.setPlatos(ordenesActualizar.getPlatos());
		ordenesActual.setTotal(ordenesActualizar.getTotal());
		
		Ordenes ordenesActualizado = repositorio.save(ordenesActual);
		return ordenesActualizado;
	}
	
	public Ordenes buscarporId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
}
