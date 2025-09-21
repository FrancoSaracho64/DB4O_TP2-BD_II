package ar.edu.unlu.bdd.entidad;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_EMPLEADO")
public class Empleado {
    @Id
    @Column(name = "DNI", nullable = false)
    private int dni;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;
}
