package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Inyecta el repositorio
    
    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        
        return usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioEntity encontrarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return usuarioRepository.findAll(); // Retorna la lista de usuarios
    }

    @Override
    public Optional<UsuarioEntity> buscarUsuarioById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("El usuario con ID " + usuario.getIdUsuario() + " no existe.");
        }
    }

    @Override
    @Transactional
    public void eliminarUsuarioId(Integer idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            throw new EntityNotFoundException("El usuario con ID " + idUsuario + " no existe.");
        }
        usuarioRepository.deleteById(idUsuario);
    }


    @Override
    public void guardarUsuario() {
        // Implementación pendiente
    }




}
