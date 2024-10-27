package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.model.BoletaEntity;
import pe.com.cibertec.service.BoletaService;

@Controller
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping("/registrarBoleta")
    public String mostrarFormularioBoleta(Model model) {
        model.addAttribute("boleta", new BoletaEntity());
        return "registrarBoleta";
    }

    @PostMapping("/listarBoleta")
    public String registrarBoleta(BoletaEntity boleta) {
        boletaService.crearBoleta(boleta);
        return "redirect:/listarBoleta";
    }

    @GetMapping("/listarBoleta")
    public String listarBoleta(Model model) {
        model.addAttribute("boletas", boletaService.listarBoleta());
        return "listarBoleta";
    }

    @GetMapping("/modificarBoleta/{idBoleta}")
    public String mostrarFormularioModificarBoleta(@PathVariable("idBoleta") Integer idBoleta, Model model) {
        BoletaEntity boleta = boletaService.buscarBoletaById(idBoleta)
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));
        model.addAttribute("boleta", boleta);
        return "modificarBoleta";
    }

    @PostMapping("/modificarBoleta")
    public String modificarBoleta(BoletaEntity idBoleta) {
        boletaService.actualizarBoleta(idBoleta);
        return "redirect:/listarBoleta";
    }

    
    
    @DeleteMapping("/eliminarBoleta/{idBoleta}")
    public ResponseEntity<Void> eliminarBoleta(@PathVariable Integer idBoleta) {
        boletaService.eliminarBoletaById(idBoleta);
        return ResponseEntity.noContent().build();
    }
}
