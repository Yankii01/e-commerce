package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VerClienteController {
    
    @GetMapping("/verCliente")
    public String cliente() {
        return "verCliente"; // Nombre del archivo HTML sin la extensión
    }
}
