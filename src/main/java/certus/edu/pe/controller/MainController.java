package certus.edu.pe.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("/home")
		public String welcome(Model model, HttpServletRequest request) {
			return "/index";
		}
	}

