package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {
		@GetMapping("/registrarProductos")
		public String productos() {
			return "registrarProductos";
		}
}
