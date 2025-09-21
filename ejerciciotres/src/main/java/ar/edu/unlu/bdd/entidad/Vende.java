package ar.edu.unlu.bdd.entidad;

import javax.persistence.*;

@Entity
@Table(name="TBL_VENDE")
public class Vende {
    @Id
    @Column(name = "CODIGO", nullable = false)
    private int codigo;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;

    public Vende(int codigo, String nombre, int stock, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public Vende() {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
