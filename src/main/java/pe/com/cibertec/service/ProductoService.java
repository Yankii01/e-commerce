package pe.com.cibertec.service;

import pe.com.cibertec.model.ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    ProductoEntity crearProducto(ProductoEntity producto);
    List<ProductoEntity> listarProductos();
    Optional<ProductoEntity> buscarProductoById(Integer idProducto);
    ProductoEntity actualizarProducto(ProductoEntity producto);
    void eliminarProductoById(Integer idProducto);
    void guardarProducto();
    
}

