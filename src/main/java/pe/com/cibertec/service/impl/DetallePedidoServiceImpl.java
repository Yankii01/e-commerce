package pe.com.cibertec.service.impl;

import org.springframework.stereotype.Service;
import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.service.DetallePedidoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private List<ProductoEntity> carrito = new ArrayList<>();

    @Override
    public void agregarProductoAlCarrito(String nombre, double precio, String imagen) {
        // Crear un nuevo objeto ProductoEntity y agregarlo al carrito
        ProductoEntity nuevoProducto = new ProductoEntity(); // Asegúrate de que esta línea sea correcta
        carrito.add(nuevoProducto);
    }

    @Override
    public void vaciarCarrito() {
        carrito.clear();
    }

    @Override
    public List<ProductoEntity> obtenerCarrito() {
        return carrito;
    }

    @Override
    public void eliminarDelCarrito(ProductoEntity producto) {
        carrito.remove(producto);
    }

    @Override
    public void incrementarCantidad(ProductoEntity producto) {
        for (ProductoEntity p : carrito) {
            if (p.getNombre().equals(producto.getNombre())) {
                p.setCantidad(p.getCantidad() + 1);
                break;
            }
        }
    }

    @Override
    public void decrementarCantidad(ProductoEntity producto) {
        for (ProductoEntity p : carrito) {
            if (p.getNombre().equals(producto.getNombre()) && p.getCantidad() > 1) {
                p.setCantidad(p.getCantidad() - 1);
                break;
            }
        }
    }
}
