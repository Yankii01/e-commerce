package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "login"; // Asegúrate de que esta vista exista
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, @RequestParam String contraseña, Model model) {
        UsuarioEntity usuario = usuarioService.encontrarPorEmail(email);
        if (usuario != null && contraseña.equals(usuario.getContraseña())) {
            // Autenticación exitosa
            return "redirect:/"; // Redirigir a la página principal
        }
        model.addAttribute("error", "Credenciales inválidas");
        return "login"; // Regresar al formulario de login
    }
}