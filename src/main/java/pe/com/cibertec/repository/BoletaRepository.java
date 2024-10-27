package pe.com.cibertec.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.BoletaEntity;

@Repository
public interface BoletaRepository extends JpaRepository <BoletaEntity, Integer>{

}
