package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.model.PedidoEntity;
import pe.com.cibertec.service.PedidoService;
import pe.com.cibertec.service.ClienteService;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/registrarPedido")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new PedidoEntity());
        return "registrarPedido";
    }

    @PostMapping("/listarPedidos")
    public String registrarPedido(PedidoEntity pedido) {
        pedidoService.guardarPedido(pedido);
        return "redirect:/listarPedidos";
    }

    @GetMapping("/listarPedidos")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "listarPedidos";
    }

    @GetMapping("/modificarPedido/{idPedido}")
    public String mostrarFormularioModificarPedido(@PathVariable("idPedido") Integer idPedido, Model model) {
        PedidoEntity pedido = pedidoService.getPedidoById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        model.addAttribute("pedido", pedido);
        return "modificarPedido";
    }

    @PostMapping("/modificarPedido")
    public String modificarPedido(PedidoEntity pedido) {
        pedidoService.guardarPedido(pedido);
        return "redirect:/listarPedidos";
    }

    @GetMapping("/listarPedidos/{idPedido}")
    public String eliminarPedido(@PathVariable Integer idPedido) {
        pedidoService.eliminarPedido(idPedido);
        return "redirect:/listarPedidos";
    }
}
