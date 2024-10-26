package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.ClienteEntity;
import pe.com.cibertec.repository.ClienteRepository;
import pe.com.cibertec.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public ClienteEntity crearCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<ClienteEntity> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteEntity> buscarClienteById(Integer idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public ClienteEntity actualizarCliente(ClienteEntity cliente) {
    	if (clienteRepository.existsById(cliente.getIdCliente())) {
    		return clienteRepository.save(cliente);
    	} else {
    		throw new IllegalArgumentException("El Cliente con ID " + cliente.getIdCliente() + "no existe.");
    	}
        
    }

    @Override
    public void eliminarClienteById(Integer idCliente) {
    	if (clienteRepository.existsById(idCliente)) {
    		clienteRepository.deleteById(idCliente);
    	} else {
        throw new IllegalArgumentException("El Cliente con ID " + idCliente + "no existe.");
    }
}
    @Override
	public void guardarCliente() {
		// TODO Auto-generated method stub
    
}
}
