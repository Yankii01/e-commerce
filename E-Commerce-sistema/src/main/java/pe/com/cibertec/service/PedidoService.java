package pe.com.cibertec.service;

import pe.com.cibertec.model.PedidoEntity;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<PedidoEntity> listarPedidos();
    Optional<PedidoEntity> getPedidoById(Integer id);
    PedidoEntity guardarPedido(PedidoEntity pedido);
    void eliminarPedido(Integer id);
}
