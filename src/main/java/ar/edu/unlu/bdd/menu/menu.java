package ar.edu.unlu.bdd.menu;

import ar.edu.unlu.bdd.entidad.Cliente;
import ar.edu.unlu.bdd.entidad.Factura;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.UtilCliente;
import ar.edu.unlu.bdd.utils.UtilFactura;

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
            System.out.println("3 - Borrar");
            System.out.println("4 - Volver");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1: {
                    int id;
                    String descr;

                    id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID cliente: ");
                    descr = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese descr: ");

                    UtilCliente.insert(new Cliente(id, descr));
                    break;
                }
                case 2: {
                    int id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID: ");
                    System.out.println(UtilCliente.findFirst(new Cliente(id)));
                    break;
                }
                case 3: {
                    int id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID: ");
                    UtilCliente.delete(new Cliente(id));
                    break;
                }
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 4);
    }

    public void operarFactura() {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println(" - Factura -");
            System.out.println("Seleccione la acción que desea realziar sobre la tabla:");
            System.out.println("1 - Alta");
            System.out.println("2 - Consulta");
            System.out.println("3 - Borrar");
            System.out.println("4 - Volver");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1: {
                    int id, nro;
                    double monto;

                    nro = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el numero de factura: ");
                    monto = CFZValidatorUtils.solicitarDoublePorTeclado("Ingrese el monto de la factura: ");
                    id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el id cliente: ");

                    UtilFactura.insert(new Factura(nro, id, monto));
                    break;
                }
                case 2: {
                    int nro = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el numero de factura: ");
                    System.out.println(UtilFactura.findFirst(new Factura(nro)));
                    break;
                }
                case 3: {
                    int nro = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el numero de factura: ");
                    UtilFactura.delete(new Factura(nro));
                    break;
                }
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 4);
    }
}
