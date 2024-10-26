package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.BoletaEntity;
import pe.com.cibertec.repository.BoletaRepository;
import pe.com.cibertec.service.BoletaService;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaServiceImpl implements BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Override
    public BoletaEntity crearBoleta(BoletaEntity boleta) {
        return boletaRepository.save(boleta);
    }
    
    @Override
    public List<BoletaEntity> listarBoleta() {
        return boletaRepository.findAll();
    }

    @Override
    public Optional<BoletaEntity> buscarBoletaById(Integer idBoleta) {
        return boletaRepository.findById(idBoleta);
    }

    @Override
    public BoletaEntity actualizarBoleta(BoletaEntity boleta) {
    	if (boletaRepository.existsById(boleta.getIdBoleta())) {
    		return boletaRepository.save(boleta);
    	} else {
    		throw new IllegalArgumentException("La boleta con ID " + boleta.getIdBoleta() + " no existe.");
    	}
        
    }

    @Override
    public void eliminarBoletaById(Integer idBoleta) {
        if (boletaRepository.existsById(idBoleta)) {
            boletaRepository.deleteById(idBoleta);
        } else {
            throw new IllegalArgumentException("La Boleta con ID " + idBoleta + " no existe.");
        }
    }
    
    
  
	@Override
	public void guardarBoleta() {
		// TODO Auto-generated method stub
		
	}
}