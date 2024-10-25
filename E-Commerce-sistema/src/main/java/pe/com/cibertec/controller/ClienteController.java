package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    
    @GetMapping("/registrarCliente")
    public String cliente() {
        return "registrarCliente"; // Nombre del archivo HTML sin la extensión
    }
}

