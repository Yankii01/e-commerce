package pe.com.cibertec.service;

import pe.com.cibertec.model.BoletaEntity;
import java.util.List;
import java.util.Optional;

public interface BoletaService {
	BoletaEntity crearBoleta(BoletaEntity boleta);
    List<BoletaEntity> listarBoleta();
    Optional<BoletaEntity> buscarBoletaById(Integer idBoleta);
    BoletaEntity actualizarBoleta(BoletaEntity boleta);
    void eliminarBoletaById(Integer idBoleta);
    void guardarBoleta();
}
