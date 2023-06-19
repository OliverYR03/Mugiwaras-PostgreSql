package certus.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import certus.edu.pe.model.exceptions.ResourceNotFoundException;
import certus.edu.pe.modelo.Personal;
import certus.edu.pe.servicios.PersonalSerivicio;

@Controller
@RequestMapping("/personal")
public class PersonalWebController {

	@Autowired
	private PersonalSerivicio servicio;
	
	@RequestMapping("/listarPersonal")
	public String listarPersonal(Model model) {
		List<Personal> listaPersonal = servicio.buscarTodo();
		System.out.println("LISTA DE PERSONAL: " + listaPersonal);
		model.addAttribute("listaPersonal", listaPersonal);
		return "/moduloPersonal/listarPersonal";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoPersonal (Model model) {
		Personal personal = new Personal();
		model.addAttribute("personal", personal);
		return "/moduloPersonal/nuevoPersonal";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String crearPersonal(@ModelAttribute("personal") Personal personal) {
		servicio.crear(personal);
		return "redirect:/personal/listarPersonal";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPersonal(@PathVariable(name="id") int id) throws ResourceNotFoundException {
		ModelAndView mav= new ModelAndView("/moduloPersonal/editarPersonal");
		Personal personal = servicio.buscarPorId(id);
		if (personal == null) {
            throw new ResourceNotFoundException("Personal not found for id: " + id);
        }
		mav.addObject("personal", personal);
		return mav;
		
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarPersonal(@PathVariable(name = "id") int id)  throws ResourceNotFoundException {
		Personal personal = servicio.buscarPorId(id);
	       if (personal == null) {
	           throw new ResourceNotFoundException("Personal not found for id: " + id);
	       }
		servicio.borrarPorId(id);
		return "redirect:/personal/listarPersonal";
	}
	
}
