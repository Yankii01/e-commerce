package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.repository.ProductoRepository;
import pe.com.cibertec.service.ProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> buscarProductoById(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity producto) {
        if (productoRepository.existsById(producto.getIdProducto())) {
            return productoRepository.save(producto);
        } else {
            throw new IllegalArgumentException("El producto con ID " + producto.getIdProducto() + " no existe.");
        }
    }

    @Override
    public void eliminarProductoById(Integer idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
        } else {
            throw new IllegalArgumentException("El producto con ID " + idProducto + " no existe.");
        }
    }
    
    
  
	@Override
	public void guardarProducto() {
		// TODO Auto-generated method stub
		
	}
}
