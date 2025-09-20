package ar.edu.unlu.bdd.ejerciciodos.entidad;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int idc;
    private String circuito;
    private String pais;
    private String fecha;
    private int cantVueltas;

    // Relación: una carrera tiene competidores
    private List<CompiteEn> participantes = new ArrayList<>();

    // Relación: un ganador
    private Piloto ganador;

    public Carrera() {
    }

    public Carrera(int idc, String circuito, String pais, String fecha, int cantVueltas) {
        this.idc = idc;
        this.circuito = circuito;
        this.pais = pais;
        this.fecha = fecha;
        this.cantVueltas = cantVueltas;
    }

    public void addParticipante(CompiteEn compiteEn) {
        participantes.add(compiteEn);
    }

    public void setGanador(Piloto ganador) {
        this.ganador = ganador;
    }

    // Getters
    public int getIdc() {
        return idc;
    }

    public String getCircuito() {
        return circuito;
    }

    public String getPais() {
        return pais;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantVueltas() {
        return cantVueltas;
    }

    public List<CompiteEn> getParticipantes() {
        return participantes;
    }

    public Piloto getGanador() {
        return ganador;
    }

    // Setters
    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantVueltas(int cantVueltas) {
        this.cantVueltas = cantVueltas;
    }

    public void setParticipantes(List<CompiteEn> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idc=" + idc +
                ", circuito='" + circuito + '\'' +
                ", pais='" + pais + '\'' +
                ", fecha=" + fecha +
                ", cantVueltas=" + cantVueltas +
                ", ganador=" + (ganador != null ? ganador.getApenom() : "Sin ganador") +
                '}';
    }
}
