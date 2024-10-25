package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	 @GetMapping("/login") //aca se rutea la pagina
	    public String usuario() {
	        return "Login"; // Nombre del archivo HTML sin la extensión
	    }
}