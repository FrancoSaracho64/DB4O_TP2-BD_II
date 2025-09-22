package ar.edu.unlu.bdd.entidad;

import javax.persistence.*;

@Entity
@Table(name="TBL_VENDE")
public class Vende {
    @EmbeddedId
    private VendeId id;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;

    public Vende(int codigo, String nombre, int stock, Double precio) {
        this.id = new VendeId(codigo, nombre);
        this.stock = stock;
        this.precio = precio;
    }

    public Vende() {
    }

    public VendeId getId() {
        return id;
    }

    public void setId(VendeId id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vende{" + id +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
