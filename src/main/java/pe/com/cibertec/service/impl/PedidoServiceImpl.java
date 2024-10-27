package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.PedidoEntity;
import pe.com.cibertec.repository.PedidoRepository;
import pe.com.cibertec.service.PedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    public PedidoEntity crearPedido(PedidoEntity pedido) {
    	return pedidoRepository.save(pedido);
    }

    @Override
    public List<PedidoEntity> listarPedido() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<PedidoEntity> buscarPedidoById(Integer idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public PedidoEntity actualizarPedido(PedidoEntity pedido) {
    	if (pedidoRepository.existsById(pedido.getIdPedido())) {
        return pedidoRepository.save(pedido);
    } else {
    	throw new IllegalArgumentException("El Pedido con ID " + pedido.getIdPedido() + " no existe.");
    }

    }
    

    public void eliminarPedidoById(Integer idPedido) {
        pedidoRepository.deleteById(idPedido); // Método que elimina el pedido usando el repositorio
    }

	@Override
	public void guardarPedido() {
		// TODO Auto-generated method stub
		
	}
}
