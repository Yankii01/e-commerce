package pe.com.cibertec.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {
	
	

    @Autowired
    private UsuarioService usuarioService;
    
    @DeleteMapping("/eliminarUsuario/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuarioEntity(@PathVariable Integer idUsuario) {
        // Asegúrate de que la lógica para eliminar el usuario esté aquí
        usuarioService.eliminarUsuarioId(idUsuario);
        return ResponseEntity.noContent().build(); // Devuelve una respuesta 204 No Content
    }


    @GetMapping("/registrarUsuario")  // Añade este método para manejar GET si deseas mostrar el formulario
    public String mostrarFormularioUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "registrarUsuario"; // Nombre de la vista para el formulario
    }
    
    @PostMapping("/listarUsuario")
    public String registrarUsuario(@ModelAttribute UsuarioEntity usuario) {
        usuarioService.crearUsuario(usuario);
        return "redirect:/login"; // Redirigir a la lista de usuarios después de registrar
    }
    
    @GetMapping("/listarUsuario")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuario());
        return "listarUsuario"; // nombre de la plantilla HTML
    }
    
    
    @GetMapping("/modificarUsuario/{idUsuario}")
    public String mostrarFormularioModificarUsuario(@PathVariable("idUsuario") Integer idUsuario, Model model) {
    	UsuarioEntity usuario = usuarioService.buscarUsuarioById(idUsuario)
    		    .orElseThrow(() -> new RuntimeException("usuario no encontrado"));

        model.addAttribute("usuario", usuario);
        return "modificarUsuario"; // Nombre de la vista Thymeleaf para modificar el producto
    }
    
    
    @PostMapping("/modificarUsuario")
    public String modificarUsuario(UsuarioEntity idUsuario) {
        usuarioService.actualizarUsuario(idUsuario);
        return "redirect:/listarUsuario";
    }
    

    @GetMapping("/eliminarUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioService.eliminarUsuarioId(idUsuario); // Asegúrate de tener este método en ProductoService
        return "redirect:/listarUsuario";
    }
    
    @GetMapping("/loginAdmin")
    public String loginAdmin(Model model) {
        model.addAttribute("admin", new Admin()); // Agrega un objeto admin vacío para el formulario
        return "loginAdministrativo"; // Muestra la vista loginAdministrativo.html
    }

    
  
}