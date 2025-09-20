package entidades;

public class Factura {
    private Integer nro;
    private Integer id;
    private Double importe;

    public Factura(Integer nro, Integer id, Double importe) {
        this.nro = nro;
        this.id = id;
        this.importe = importe;
    }

    public Factura() {
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
