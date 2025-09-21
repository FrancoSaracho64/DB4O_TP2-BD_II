package ar.edu.unlu.bdd.entidad;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_VENDE")
public class Vende {
    @Id
    @Column(name = "CODIGO", nullable = false)
    private int codigo;

    @Id
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;
}
