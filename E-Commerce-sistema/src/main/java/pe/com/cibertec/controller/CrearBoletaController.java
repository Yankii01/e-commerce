package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrearBoletaController {

    // Método para mostrar el formulario de creación de boleta
    @GetMapping("/crearBoleta")
    public String mostrarCrearBoleta(Model model) {
        // Agregar cualquier atributo necesario al modelo
        return "crearBoleta"; // Devuelve la vista para crear boleta
    }
}
