package ar.edu.unlu.bdd.menu;

import ar.edu.unlu.bdd.utils.CFZValidatorUtils;

public class menu {
    public menu() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("TP2 BD2 Ejercicio N°1");
            System.out.println("Seleccione la tabla con la que desea operar:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Factura");
            System.out.println("3 - Salir");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1:
                    operarCliente();
                    break;
                case 2:
                    operarFactura();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 3);
    }

    public void operarCliente() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println(" - Cliente -");
            System.out.println("Seleccione la acción que desea realziar sobre la tabla:");
            System.out.println("1 - Alta");
            System.out.println("2 - Consulta");
            System.out.println("3 - Volver");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 3);
    }

    public void operarFactura() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println(" - Factura -");
            System.out.println("Seleccione la acción que desea realziar sobre la tabla:");
            System.out.println("1 - Alta");
            System.out.println("2 - Consulta");
            System.out.println("3 - Volver");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 3);
    }
}
