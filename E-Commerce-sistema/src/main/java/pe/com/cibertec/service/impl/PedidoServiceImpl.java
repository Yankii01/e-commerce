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
    public List<PedidoEntity> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<PedidoEntity> getPedidoById(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public PedidoEntity guardarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
