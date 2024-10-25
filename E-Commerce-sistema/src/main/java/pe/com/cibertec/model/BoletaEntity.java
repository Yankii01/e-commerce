package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false) // Clave foránea hacia PedidoEntity
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Clave foránea hacia UsuarioEntity
    private UsuarioEntity usuario;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total_cobrar", nullable = false)
    private Double totalCobrar;
}