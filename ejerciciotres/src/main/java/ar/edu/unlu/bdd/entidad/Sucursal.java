package ar.edu.unlu.bdd.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_SUCURSAL")
public class Sucursal {
    @Id
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 100)
    private String direccion;

}
