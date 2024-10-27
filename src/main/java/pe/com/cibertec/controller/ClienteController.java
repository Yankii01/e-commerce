package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.model.ClienteEntity;
import pe.com.cibertec.service.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/registrarCliente")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        return "registrarCliente";
    }

    @PostMapping("/listarCliente")
    public String registrarCliente(ClienteEntity cliente) {
        clienteService.crearCliente(cliente);
        return "redirect:/listarCliente";
    }

    @GetMapping("listarCliente")
    public String listarCliente(Model model) {
        model.addAttribute("cliente", clienteService.listarCliente());
        return "listarCliente";
    }

    @GetMapping("/modificarCliente/{idCliente}")
    public String mostrarFormularioModificarCliente(@PathVariable("idCliente") Integer idCliente, Model model) {
        ClienteEntity cliente = clienteService.buscarClienteById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @PostMapping("/modificarCliente")
    public String modificarCliente(ClienteEntity idCliente) {
        clienteService.actualizarCliente(idCliente);
        return "redirect:/listarCliente";
    }

    @DeleteMapping("/eliminarCliente/{idCliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer idCliente) {
        clienteService.eliminarClienteById(idCliente);
        return ResponseEntity.noContent().build();
    }
}
