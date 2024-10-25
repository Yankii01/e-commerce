package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {
	@GetMapping("/registrarPedido") //aca se rutea la pagina
    public String pedido() {
        return "registrarPedido"; // Nombre del archivo HTML sin la extensión
    }
}
