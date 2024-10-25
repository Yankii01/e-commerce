package pe.com.cibertec.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import pe.com.cibertec.model.BoletaEntity;
import pe.com.cibertec.repository.BoletaRepository;


@Data
@Service
public class BoletaService {
	
	@Autowired
	BoletaRepository boletaRepository;
	
	public List<BoletaEntity> getBoletaEntity(){
		return boletaRepository.findAll();
	}
	
	public Optional<BoletaEntity> getBoletaEntity(Integer id){
		return boletaRepository.findById(id);
	}
	
	public void saveOrUpdate(BoletaEntity boletaentity) {
		boletaRepository.save(boletaentity);
	}
	
	public void delete(Integer id) {
		boletaRepository.deleteById(id);
	}
	
}
