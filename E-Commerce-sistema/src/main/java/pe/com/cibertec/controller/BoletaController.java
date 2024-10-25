package pe.com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.model.BoletaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.com.cibertec.service.BoletaService;

@Controller
public class BoletaController {
    
    @Autowired
    private BoletaService boletaService;

    @GetMapping("/verBoleta")
    public String crearBoletaForm(Model model) {
        // Agregar lógica para crear boleta
        return "verBoleta"; // Devolver el nombre de la vista
    }

    // Save - Update boleta
    @PostMapping("/verBoleta")
    public String saveUpdate(@ModelAttribute BoletaEntity boletaEntity) {
        boletaService.saveOrUpdate(boletaEntity);    
        return "redirect:/verBoleta"; // Redirige a la vista de ver boletas después de guardar
    }
    
    // Buscar Boleta por ID
    @GetMapping("/{boletaEntityId}")
    public Optional<BoletaEntity> getBId(@PathVariable("boletaEntityId") Integer boletaEntity) {
        return boletaService.getBoletaEntity(boletaEntity);
    }
    
    // Delete Boleta
    @DeleteMapping("/{boletaEntityId}")
    public void delete(@PathVariable("boletaEntityId") Integer boletaEntity) {
        boletaService.delete(boletaEntity);    
    }
}
