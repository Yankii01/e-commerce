package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrarUsuario")  // Añade este método para manejar GET si deseas mostrar el formulario
    public String mostrarFormularioUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "registrarUsuario"; // Nombre de la vista para el formulario
    }
    
    @PostMapping("/listarUsuario")
    public String registrarUsuario(UsuarioEntity usuario) {
        usuarioService.crearUsuario(usuario);
        return "redirect:/listarUsuario"; // Redirigir a la lista de usuarios después de registrar
    }
    
    @GetMapping("listarUsuario")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuario());
        return "listarUsuario"; // Nombre de la vista para la lista de usuarios
    }
    
    

    
    // Nuevo método para cargar el producto y mostrar el formulario de modificación
    @GetMapping("/modificarUsuario/{idUsuario}")
    public String mostrarFormularioModificarUsuario(@PathVariable("idUsuario") Integer idUsuario, Model model) {
    	UsuarioEntity usuario = usuarioService.buscarUsuarioById(idUsuario)
    		    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        model.addAttribute("usuario", usuario);
        return "modificarUsuario"; // Nombre de la vista Thymeleaf para modificar el producto
    }

    // Método para actualizar el producto en la base de datos
    @PostMapping("/modificarUsuario")
    public String modificarUsuario(UsuarioEntity idUsuario) {
        usuarioService.actualizarUsuario(idUsuario);
        return "redirect:/listarUsuario";
    }
    
    @GetMapping("/listarUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioService.eliminarUsuarioById(idUsuario); // Asegúrate de tener este método en ProductoService
        return "redirect:/listarUsuario";
    }
    
 

}
