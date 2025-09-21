package ar.edu.unlu.bdd.entidad;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_PRODUCTO")
public class Producto {
    @Id
    @Column(name = "CODIGO", nullable = false)
    private int codigo;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "STOCK", nullable = false)
    private int stock;
}
