package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.model.UsuarioEntity;

public interface UsuarioService {
	UsuarioEntity crearUsuario(UsuarioEntity usuario);
    List<UsuarioEntity> listarUsuario();
    Optional<UsuarioEntity> buscarUsuarioById(Integer idUsuario);
    UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    void eliminarUsuarioById(Integer idUsuario);
    void guardarUsuario();
    
    UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    UsuarioEntity encontrarPorEmail(String email);
}



