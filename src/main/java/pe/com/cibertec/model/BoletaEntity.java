package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "tb_boleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private Integer idBoleta; // Clave primaria


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total_cobrar", nullable = false)
    private Double totalCobrar;

	public Integer getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Integer idBoleta) {
		this.idBoleta = idBoleta;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotalCobrar() {
		return totalCobrar;
	}

	public void setTotalCobrar(Double totalCobrar) {
		this.totalCobrar = totalCobrar;
	}




}