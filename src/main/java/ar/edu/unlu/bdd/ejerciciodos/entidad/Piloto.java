package ar.edu.unlu.bdd.ejerciciodos.entidad;

public class Piloto {
    private int idp;
    private String apenom;
    private String nacionalidad;
    private int pts;

    // Relación: pertenece a un equipo
    private Equipo equipo;

    public Piloto() {
    }

    public Piloto(int idp, String apenom, String nacionalidad) {
        this.idp = idp;
        this.apenom = apenom;
        this.nacionalidad = nacionalidad;
        this.pts = 0;
    }

    public Piloto(int idp, String apenom, String nacionalidad, int pts, int equipo) {
        this.idp = idp;
        this.apenom = apenom;
        this.nacionalidad = nacionalidad;
        this.pts = pts;
        // El equipo se asignará por separado
    }

    // Getters & Setters
    public int getIdp() {
        return idp;
    }

    public String getApenom() {
        return apenom;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // Setters adicionales
    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setApenom(String apenom) {
        this.apenom = apenom;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "idp=" + idp +
                ", apenom='" + apenom + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", pts=" + pts +
                ", equipo=" + (equipo != null ? equipo.getNombre() : "Sin equipo") +
                '}';
    }
}
