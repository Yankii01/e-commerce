package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.ClienteEntity;
import pe.com.cibertec.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<ClienteEntity> getClienteEntity(){
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Optional<ClienteEntity> getClienteEntity(Integer id){
        return clienteRepository.findById(id);
    }

    // Guardar o actualizar un cliente
    public void saveOrUpdate(ClienteEntity clienteEntity) {
        clienteRepository.save(clienteEntity);
    }

    // Eliminar un cliente por su ID
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
