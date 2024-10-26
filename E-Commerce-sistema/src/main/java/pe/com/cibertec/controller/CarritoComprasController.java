package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoComprasController {
	 @GetMapping("/carritodeCompras")
	    public String mostrarCarrito(Model model) {
	    	return "carritodeCompras";
	    }
}