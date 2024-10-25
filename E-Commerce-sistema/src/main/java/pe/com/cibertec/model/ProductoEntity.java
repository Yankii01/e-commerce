package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto; // Clave primaria

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado; // PENDIENTE, COMPLETADO, CANCELADO

    @Column(name = "precio", nullable = false)
    private Double precio; // Precio del producto
}