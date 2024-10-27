package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.cibertec.model.UsuarioEntity;

public interface UsuarioService {
	
	 UsuarioEntity crearUsuario(UsuarioEntity usuario);
	    List<UsuarioEntity> listarUsuario();
	    Optional<UsuarioEntity> buscarUsuarioById(Integer Idusuario);
	    UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
	    void guardarUsuario();
		void eliminarUsuarioId(Integer idUsuario);
		UsuarioEntity registrarUsuario(UsuarioEntity usuario);
	    UsuarioEntity encontrarPorEmail(String email);
		
}



