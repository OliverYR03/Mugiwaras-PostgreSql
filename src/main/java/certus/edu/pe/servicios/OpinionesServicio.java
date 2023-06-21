package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.repositorio.OpinionesRepositorio;
import javax.transaction.Transactional;
import certus.edu.pe.modelo.*;

@Service
@Transactional
public class OpinionesServicio {

	@Autowired
	private OpinionesRepositorio repositorio;
	
	public OpinionesServicio() {
		
	}
	
	public List<Opiniones> buscarTodo(){
		return (List<Opiniones>) repositorio.findAll();
	}
	
	public Opiniones crear(Opiniones opiniones) {
		return repositorio.save(opiniones);
	}
	
	public Opiniones actualizar(Opiniones opinionActualizar) {
		
		Opiniones opinionActual = repositorio.findById(opinionActualizar.getIdopinion()).get();
		
		opinionActual.setIdopinion(opinionActualizar.getIdopinion());
		opinionActual.setPlatos(opinionActualizar.getPlatos());
		opinionActual.setClientess(opinionActualizar.getClientess());
		opinionActual.setCalificacion(opinionActualizar.getCalificacion());
		opinionActual.setComentario(opinionActualizar.getComentario());
		opinionActual.setFecha(opinionActualizar.getFecha());
		
		Opiniones opinionActualizada = repositorio.save(opinionActual);
		return opinionActualizada;
	}
	
	public Opiniones buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
}
