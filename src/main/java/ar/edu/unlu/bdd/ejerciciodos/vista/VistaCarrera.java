package ar.edu.unlu.bdd.ejerciciodos.vista;

import ar.edu.unlu.bdd.ejerciciodos.controlador.ControladorCarrera;
import ar.edu.unlu.bdd.ejerciciodos.utils.Listado;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;


public class VistaCarrera {
    private ControladorCarrera controlador;

    public VistaCarrera(ControladorCarrera controladorCarrera) {
        this.controlador = controladorCarrera;
        Listado.listarMenu("Carrera");
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

            default:
                Listado.listarMenu("Carrera");
                break;
        }

    }

    private void gestionarAlta() {
        int idCarrera, vueltas;
        String circuito, pais, fecha;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado("Nombre del circuito: ");
        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado("Cantidad de vueltas: ");
        pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Pais: ");
        fecha = CFZValidatorUtils.solicitarFechaPorTeclado();

        controlador.alta(idCarrera, circuito, pais, vueltas, fecha);
    }

    private void gestionarBorrar() {
        int idCarrera;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");

        controlador.baja(idCarrera);
    }

    private void gestionarModificar() {
        int idCarrera, vueltas;
        String circuito, pais, fecha;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado("Nombre del circuito: ");
        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado("Cantidad de vueltas: ");
        pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Pais: ");
        fecha = CFZValidatorUtils.solicitarFechaPorTeclado();

        controlador.modificacion(idCarrera, circuito, pais, vueltas, fecha);
    }


    private void gestionarConsulta() {
        int idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera (0 para ver todas): ");

        controlador.consulta(idCarrera);
    }

    private void salir() {
        System.out.println("Saliendo del módulo de carreras...");
    }

}
