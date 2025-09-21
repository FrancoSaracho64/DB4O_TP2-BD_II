package ar.edu.unlu.bdd.entidad;

import javax.persistence.*;

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

    public Empleado(int dni, String descripcion, String nombre, String apellido) {
        this.dni = dni;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(int dni) {
        this.dni = dni;
    }

    public Empleado(int dni, String  nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
