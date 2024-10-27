package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrabajadorVistaController {

    @GetMapping("/trabajadorVista")
    public String trabajadorVista() {
        return "trabajadorVista"; // Nombre de la vista HTML sin la extensión
    }

    @GetMapping("/crearPedido")
    public String crearPedido() {
        // Lógica para crear pedido, si es necesario
        return "crearPedido"; // Crear una vista crearPedido.html si tienes una página específica
    }

    @GetMapping("/verBoletas")
    public String verBoletas() {
        // Lógica para ver boletas
        return "verBoletas"; // Crear una vista verBoletas.html si tienes una página específica
    }

    @GetMapping("/verPedidos")
    public String verPedidos() {
        // Lógica para ver pedidos
        return "verPedidos"; // Crear una vista verPedidos.html si tienes una página específica
    }
    
    @GetMapping("/generarFactura")
    public String generarFactura() {
        // Lógica para generar factura
        return "generarFactura"; // Crear una vista generarFactura.html si tienes una página específica
    }
}