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

import certus.edu.pe.modelo.Ordenes;
import certus.edu.pe.servicios.OrdenesServicio;

@Controller
@RequestMapping("/ordenes")
public class OrdenesWebController {
	
	@Autowired //Esta es una inyeeccion de dependencia a la capa de servicio
	private OrdenesServicio servicio;
	
	@RequestMapping("/listarOrdenes")
	public String listarOrdenes(Model model) {
		List<Ordenes> listaOrdenes = servicio.buscarTodo();
		System.out.println("LISTA DE ORDENES" + listaOrdenes);
		model.addAttribute("listaOrdenes",listaOrdenes);
		return "/moduloOrdenes/listarOrdenes";
	}
	
	@RequestMapping("nuevo")
	public String nuevoOrdenes(Model model) {
		Ordenes ordenes = new Ordenes();
		model.addAttribute("ordenes", ordenes);
		return "/moduloOrdenes/nuevoOrdenes";
	}
	
	@RequestMapping(value="/guardar",method= RequestMethod.POST)
	public String crearOrdenes(@ModelAttribute("ordenes")Ordenes ordenes) {
		servicio.crear(ordenes);
		return "redirect:/ordenes/listarOrdenes";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarOrdenes(@PathVariable(name="id") int id) {
		ModelAndView mav= new ModelAndView("/moduloOrdenes/editarOrdenes");
		Ordenes ordenes = servicio.buscarporId(id);
		mav.addObject("ordenes", ordenes);
		return mav;
		
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarOrdenes(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/ordenes/listarOrdenes";
	}
}
