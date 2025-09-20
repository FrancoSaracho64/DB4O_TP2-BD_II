package ar.edu.unlu.bdd.ejerciciotres.menu;

import ar.edu.unlu.bdd.utils.CFZValidatorUtils;

public class Menu {
    public Menu() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("TP2 BD2 Ejercicio N°3");
            System.out.println("Seleccione la tabla con la que desea operar:");
            System.out.println("1 - x");
            System.out.println("2 - x");
            System.out.println("3 - Salir");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1:
                    // Implementar
                    break;
                case 2:
                    // Implementar
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 3);
    }

}
