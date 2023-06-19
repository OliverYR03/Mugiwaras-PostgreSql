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
import certus.edu.pe.modelo.Clientes;
import certus.edu.pe.servicios.ClientesServicio;


@Controller
@RequestMapping("/clientes")
public class ClientesWebController {

	@Autowired
	private ClientesServicio servicio;
	
	@RequestMapping("/listarCliente")
	public String listarClientes(Model model) {
		List<Clientes> listaClientes = servicio.buscarTodo();
		System.out.println("LISTA DE CLIENTES: " + listaClientes);
		model.addAttribute("listaClientes", listaClientes);
		return "/moduloClientes/listarCliente";
	}
	
	
	@RequestMapping("/nuevo")
	public String nuevoCliente (Model model) {
		Clientes clientes = new Clientes();
		model.addAttribute("cliente", clientes);
		return "/moduloClientes/nuevoCliente";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String crearCliente(@ModelAttribute("cliente") Clientes clientes) {
		servicio.crear(clientes);
		return "redirect:/clientes/listarCliente";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCliente(@PathVariable(name = "id") int id) throws ResourceNotFoundException {
		Clientes cliente = servicio.buscarPorId(id);
	    if (cliente == null) {
	        throw new ResourceNotFoundException("Cliente not found for id: " + id);
	    }
		servicio.borrarPorId(id);
		return "redirect:/clientes/listarCliente";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCliente(@PathVariable(name="id") int id) throws ResourceNotFoundException {
		ModelAndView mav= new ModelAndView("/moduloClientes/editarCliente");
		Clientes clientes = servicio.buscarPorId(id);
		if (clientes == null) {
            throw new ResourceNotFoundException("Cliente not found for id: " + id);
        }
		mav.addObject("clientes", clientes);
		return mav;
	}
	
	
	
}
