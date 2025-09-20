package ar.edu.unlu.bdd.ejerciciodos.entidad;

public class CompiteEn {
    private Piloto piloto;
    private Carrera carrera;
    private int posArranque;
    private int posFinal;
    private boolean safetyCar;
    private int ptsObtenidos;

    public CompiteEn() {
    }

    public CompiteEn(Piloto piloto, Carrera carrera, int posArranque, int posFinal, boolean safetyCar, int ptsObtenidos) {
        this.piloto = piloto;
        this.carrera = carrera;
        this.posArranque = posArranque;
        this.posFinal = posFinal;
        this.safetyCar = safetyCar;
        this.ptsObtenidos = ptsObtenidos;
    }

    // Getters
    public Piloto getPiloto() {
        return piloto;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getPosArranque() {
        return posArranque;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public boolean isSafetyCar() {
        return safetyCar;
    }

    public int getPtsObtenidos() {
        return ptsObtenidos;
    }

    // Setters
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setPosArranque(int posArranque) {
        this.posArranque = posArranque;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }

    public void setSafetyCar(boolean safetyCar) {
        this.safetyCar = safetyCar;
    }

    public void setPtsObtenidos(int ptsObtenidos) {
        this.ptsObtenidos = ptsObtenidos;
    }

    @Override
    public String toString() {
        return "CompiteEn{" +
                "piloto=" + (piloto != null ? piloto.getApenom() : "Sin piloto") +
                ", carrera=" + (carrera != null ? carrera.getCircuito() : "Sin carrera") +
                ", posArranque=" + posArranque +
                ", posFinal=" + posFinal +
                ", safetyCar=" + safetyCar +
                ", ptsObtenidos=" + ptsObtenidos +
                '}';
    }
}
