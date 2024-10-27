package pe.com.cibertec.service;

import pe.com.cibertec.model.ProductoEntity;

import java.util.List;

public interface DetallePedidoService {
	  void agregarProductoAlCarrito(String nombre, double precio, String imagen);
	    void vaciarCarrito();
	    List<ProductoEntity> obtenerCarrito();
	    void eliminarDelCarrito(ProductoEntity producto);
	    void incrementarCantidad(ProductoEntity producto);
	    void decrementarCantidad(ProductoEntity producto);
}
