package pe.com.cibertec.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import pe.com.cibertec.model.PedidoEntity;
import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.service.DetallePedidoService;
import pe.com.cibertec.service.PedidoService;


@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private DetallePedidoService detallePedidoService;


    @GetMapping("/registrarPedido")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new PedidoEntity());
        return "registrarPedido";
    }

    @PostMapping("/listarPedido")
    public String registrarPedido(PedidoEntity pedido) {
        pedidoService.crearPedido(pedido);
        return "redirect:/listarPedido";
    }

    @GetMapping("/listarPedido")
    public String listarPedido(Model model) {
        model.addAttribute("pedido", pedidoService.listarPedido());
        return "listarPedido";
    }

    @GetMapping("/modificarPedido/{idPedido}")
    public String mostrarFormularioModificarPedido(@PathVariable("idPedido") Integer idPedido, Model model) {
        PedidoEntity pedido = pedidoService.buscarPedidoById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        model.addAttribute("pedido", pedido);
        return "modificarPedido";
    }

    @PostMapping("/modificarPedido")
    public String modificarPedido(PedidoEntity pedido) {
        pedidoService.actualizarPedido(pedido);
        return "redirect:/listarPedido";
    }

    
    @DeleteMapping("/eliminarPedido/{idPedido}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer idPedido) {
        pedidoService.eliminarPedidoById(idPedido); // Método que elimina el pedido
        return ResponseEntity.noContent().build(); // Respuesta 204 No Content
    }
    
    


    
    
 
}
