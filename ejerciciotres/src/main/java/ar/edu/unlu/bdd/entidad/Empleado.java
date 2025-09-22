package ar.edu.unlu.bdd.entidad;

import javax.persistence.*;

@Entity
@Table(name="TBL_EMPLEADO")
public class Empleado {
    @Id
    @Column(name = "DNI", nullable = false)
    private int dni;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;

    @Column(name = "NOMBRE_SUCURSAL", nullable = false, length = 100)
    private String sucursal;

    public Empleado(int dni, String nombre, String apellido, String sucursal) {
        this.dni = dni;
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(int dni) {
        this.dni = dni;
    }

    public Empleado(){

    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
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


    @Override
    public String toString(){
        return "DNI=" + dni + ", NOMBRE= " + nombre + ", APELLIDO= " + apellido + ", SUCURSAL=" + sucursal;
    }

}
