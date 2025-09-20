package ar.edu.unlu.bdd.ejerciciodos.entidad;

import java.util.ArrayList;
import java.util.List;

// ------------------ EQUIPO ------------------
public class Equipo {
    private int ide;
    private String nombre;
    private String pais;
    private int temporadasCompitidas;

    // Relación: un equipo tiene muchos pilotos
    private List<Piloto> pilotos = new ArrayList<>();

    public Equipo() {
    }

    public Equipo(int ide, String nombre, String pais, int temporadasCompitidas) {
        this.ide = ide;
        this.nombre = nombre;
        this.pais = pais;
        this.temporadasCompitidas = temporadasCompitidas;
    }

    public void addPiloto(Piloto piloto) {
        pilotos.add(piloto);
        piloto.setEquipo(this);
    }

    // Getters & Setters
    public int getIde() {
        return ide;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getTemporadasCompitidas() {
        return temporadasCompitidas;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    // Setters
    public void setIde(int ide) {
        this.ide = ide;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTemporadasCompitidas(int temporadasCompitidas) {
        this.temporadasCompitidas = temporadasCompitidas;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "ide=" + ide +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", temporadasCompitidas=" + temporadasCompitidas +
                ", pilotos=" + pilotos.size() +
                '}';
    }
}
