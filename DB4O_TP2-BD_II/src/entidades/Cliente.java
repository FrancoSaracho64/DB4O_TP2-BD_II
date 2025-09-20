package entidades;

public class Cliente {
    private Integer id;
    private String descr;

    public Cliente() {
    }

    public Cliente(Integer id, String descr) {
        this.id = id;
        this.descr = descr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
