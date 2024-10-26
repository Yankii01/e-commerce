package pe.com.cibertec.service;

import pe.com.cibertec.model.ClienteEntity;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
	ClienteEntity crearCliente(ClienteEntity cliente);
    List<ClienteEntity> listarCliente();
    Optional<ClienteEntity> buscarClienteById(Integer idCliente);
    ClienteEntity actualizarCliente(ClienteEntity cliente);
    void eliminarClienteById(Integer idCliente);
    void guardarCliente();
}
