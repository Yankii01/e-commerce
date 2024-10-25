package pe.com.cibertec.repository;
import pe.com.cibertec.model.ClienteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Integer>{

}
