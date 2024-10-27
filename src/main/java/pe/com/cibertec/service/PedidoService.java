package pe.com.cibertec.service;

import pe.com.cibertec.model.PedidoEntity;


import java.util.List;
import java.util.Optional;

public interface PedidoService {
	PedidoEntity crearPedido(PedidoEntity pedido);
    List<PedidoEntity> listarPedido();
    Optional<PedidoEntity> buscarPedidoById(Integer idPedido);
    PedidoEntity actualizarPedido(PedidoEntity pedido);
    void eliminarPedidoById(Integer idPedido);
    void guardarPedido();
}



