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
import certus.edu.pe.modelo.*;
@Controller
@RequestMapping("/platos")
public class PlatosWebController {

	@Autowired //
	private PlatosServicio servicio;
	
	@RequestMapping("/listarPlato")
	public String listarPlatos(Model model) {
		List<Platos> listaPlatos = servicio.buscarTodo();
		System.out.println("LISTA DE PLATOS: " + listaPlatos);
		model.addAttribute("listaPlatos", listaPlatos);
		return "/moduloPlatos/listarPlato";
		
	}

	@RequestMapping("/nuevo")
	public String nuevoPlato (Model model) {
		Platos platos = new Platos();
		model.addAttribute("plato", platos);
		return "/moduloPlatos/nuevoPlato";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String crearPlato(@ModelAttribute("plato") Platos platos) {
		servicio.crear(platos);
		return "redirect:/platos/listarPlato";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarPlato(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/platos/listarPlato";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPlato(@PathVariable(name="id") int id) {
		ModelAndView mav= new ModelAndView("/moduloPlatos/editarPlato");
		Platos platos = servicio.buscarPorId(id);
		mav.addObject("platos", platos);
		return mav;
		
	}
}

