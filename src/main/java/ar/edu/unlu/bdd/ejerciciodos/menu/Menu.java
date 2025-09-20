package ar.edu.unlu.bdd.ejerciciodos.menu;

import ar.edu.unlu.bdd.ejerciciodos.controlador.ControladorCarrera;
import ar.edu.unlu.bdd.ejerciciodos.controlador.ControladorCompiteEn;
import ar.edu.unlu.bdd.ejerciciodos.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.ejerciciodos.controlador.ControladorPiloto;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;

public class Menu {
    public Menu() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("TP2 BD2 Ejercicio N°2");
            System.out.println("Seleccione la tabla con la que desea operar:");
            System.out.println("1 - Pilotos");
            System.out.println("2 - Equipos");
            System.out.println("3 - Carreras");
            System.out.println("4 - Participaciones");
            System.out.println("5 - Salir");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1: {
                    operarPilotos();
                    break;
                }
                case 2: {
                    operarEquipos();
                    break;
                }
                case 3: {
                    operarCarreras();
                    break;
                }
                case 4: {
                    operarParticipaciones();
                    break;
                }
                case 5: {
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.out.println("Opción incorrecta.");
                    break;
                }
            }
        } while (opc != 5);
    }

    private void operarParticipaciones() {
        new ControladorCompiteEn().iniciarVista();
    }

    private void operarCarreras() {
        new ControladorCarrera().iniciarVista();
    }

    private void operarEquipos() {
        new ControladorEquipo().iniciarVista();
    }

    private void operarPilotos() {
        new ControladorPiloto().iniciarVista();
    }


}
