package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/registrarProductos")
    public String mostrarFormularioProducto(Model model) {
        model.addAttribute("producto", new ProductoEntity());
        return "registrarProductos";
    }

    @PostMapping("/listarProductos")
    public String registrarProducto(ProductoEntity producto) {
        productoService.crearProducto(producto);
        return "redirect:/listarProductos";
    }

    @GetMapping("listarProductos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "listarProductos";
    }
    
    
    
    // Nuevo método para cargar el producto y mostrar el formulario de modificación
    @GetMapping("/modificarProducto/{idProducto}")
    public String mostrarFormularioModificarProducto(@PathVariable("idProducto") Integer idProducto, Model model) {
    	ProductoEntity producto = productoService.buscarProductoById(idProducto)
    		    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        model.addAttribute("producto", producto);
        return "modificarProducto"; // Nombre de la vista Thymeleaf para modificar el producto
    }

    // Método para actualizar el producto en la base de datos
    @PostMapping("/modificarProducto")
    public String modificarProducto(ProductoEntity idProducto) {
        productoService.actualizarProducto(idProducto);
        return "redirect:/listarProductos";
    }
    
    @GetMapping("/listarProductos/{idProducto}")
    public String eliminarProducto(@PathVariable Integer idProducto) {
        productoService.eliminarProductoById(idProducto); // Asegúrate de tener este método en ProductoService
        return "redirect:/listarProductos";
    }
    
}
