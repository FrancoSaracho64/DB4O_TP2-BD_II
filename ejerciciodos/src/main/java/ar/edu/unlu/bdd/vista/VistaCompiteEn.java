package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorCompiteEn;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaCompiteEn {
    ControladorCompiteEn controlador;

    public VistaCompiteEn(ControladorCompiteEn controladorCompiteEn) {
        Listado.listarMenu("Participación");
        this.controlador = controladorCompiteEn;
        seleccionarOpcion();
    }

    private void seleccionarOpcion() {
        int opcion;

        opcion = CFZValidatorUtils.solicitarNumeroPorTeclado();

        switch (opcion) {
            case 1: {
                gestionarAlta();
                break;
            }

            case 2: {
                gestionarBorrar();
                break;
            }

            case 3: {
                gestionarModificar();
                break;
            }

            case 4: {
                gestionarConsulta();
                break;
            }

            case 0: /* o salir */ {
                salir();
                break;
            }

            default: {
                Listado.listarMenu("Participación");
                break;
            }
        }
    }

    private void gestionarAlta() {
        int idCarrera;
        int idPiloto;
        int pts, arranque, fin;
        boolean safety;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
        idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");
        arranque = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion arranque: ");
        fin = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion final: ");
        pts = CFZValidatorUtils.solicitarNumeroPorTeclado("Puntos obtenidos: ");
        safety = CFZValidatorUtils.solicitarNumeroPorTeclado("Safety Car (1=Si, 0=No): ") == 1;

        controlador.alta(idCarrera, idPiloto, arranque, fin, pts, safety);
    }

    private void gestionarBorrar() {
        int idCarrera;
        int idPiloto;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
        idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");

        controlador.baja(idCarrera, idPiloto);
    }

    private void gestionarModificar() {
        int idCarrera;
        int idPiloto;
        int pts, arranque, fin;
        boolean safety;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
        idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");
        arranque = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion arranque: ");
        fin = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion final: ");
        pts = CFZValidatorUtils.solicitarNumeroPorTeclado("Puntos obtenidos: ");
        safety = CFZValidatorUtils.solicitarNumeroPorTeclado("Safety Car (1=Si, 0=No): ") == 1;

        controlador.modificacion(idCarrera, idPiloto, arranque, fin, pts, safety);
    }


    private void gestionarConsulta() {
        int idCarrera;
        int idPiloto;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera (0 para ver todas): ");
        idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto (0 para ver todas): ");

        controlador.consulta(idCarrera, idPiloto);
    }

    private void salir() {
        System.out.println("Saliendo del módulo de participaciones...");
    }

}
