package certus.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import certus.edu.pe.servicios.*;
import certus.edu.pe.model.exceptions.ResourceNotFoundException;
import certus.edu.pe.modelo.*;
@Controller
@RequestMapping("/opiniones")
public class OpinionesWebController {

		@Autowired
		private OpinionesServicio servicio;
		
		@RequestMapping("/listarOpinion")
		public String listarOpiniones(Model model) {
			List<Opiniones> listaOpiniones = servicio.buscarTodo();
			System.out.println("LISTA DE OPINIONES:" + listaOpiniones);
			model.addAttribute("listaOpiniones", listaOpiniones);
			return "/moduloOpiniones/listarOpinion";
			
		}
		
		@RequestMapping("/nuevo")
		public String nuevoOpinion (Model model) {
			Opiniones opiniones = new Opiniones();
			model.addAttribute("opinion", opiniones);
			return "/moduloOpiniones/nuevoOpinion";
		}
		
		@RequestMapping(value="/guardar", method = RequestMethod.POST)
		public String crearOpinion(@ModelAttribute("opinion") Opiniones opiniones) {
			servicio.crear(opiniones);
			return "redirect:/opiniones/listarOpinion";
		}
		
		@RequestMapping(value="/eliminar/{id}")
		public String eliminarOpinion(@PathVariable(name="id") int id) throws ResourceNotFoundException {
			Opiniones opinion = servicio.buscarPorId(id);
			if (opinion == null) {
		           throw new ResourceNotFoundException("Opinion not found for id: " + id);
		       }
			servicio.borrarPorId(id);
			return "redirect:/opiniones/listarOpinion";
		}
		
		@RequestMapping(value = "/actualizar/{id}")
		public ModelAndView editarOpinion(@PathVariable(name="id") int id) throws ResourceNotFoundException {
			ModelAndView mav= new ModelAndView("/moduloOpiniones/editarOpinion");
			Opiniones opiniones = servicio.buscarPorId(id);
			if (opiniones == null) {
	            throw new ResourceNotFoundException("Opinion not found for id: " + id);
	        }
			mav.addObject("opiniones", opiniones);
			return mav;
			
		}
}


