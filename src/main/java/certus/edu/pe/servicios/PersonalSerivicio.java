package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Personal;
import certus.edu.pe.repositorio.PersonalRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonalSerivicio {
	
	@Autowired
	private PersonalRepositorio repositorio;
	
	public PersonalSerivicio() {
		
	}
	
	public List<Personal> buscarTodo(){
		return (List<Personal>) repositorio.findAll();
	}
	
	public Personal crear(Personal personal) {
		return repositorio.save(personal);
	}
	
	
public Personal actualizar(Personal personalActualizar) {
		
		Personal personalActual = repositorio.findById(personalActualizar.getIdpersonal()).get();
		
		personalActual.setIdpersonal(personalActualizar.getIdpersonal());
		personalActual.setNombre(personalActualizar.getNombre());
		personalActual.setDni(personalActualizar.getDni());
		personalActual.setCargo(personalActualizar.getCargo());
		personalActual.setImagen(personalActualizar.getImagen());
		
		Personal personalActualizado = repositorio.save(personalActual);
		return personalActualizado;
	}
	
	public Personal buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
	
		repositorio.deleteById(id);
	}
	

}
