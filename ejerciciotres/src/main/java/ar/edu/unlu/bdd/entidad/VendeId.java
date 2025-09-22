package ar.edu.unlu.bdd.entidad;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import java.io.Serializable;

@Embeddable
public class VendeId implements Serializable {
    private int codigo;
    private String nombre;


    public VendeId() {

    }

    public VendeId(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo +
                ", nombre='" + nombre;
    }
}
