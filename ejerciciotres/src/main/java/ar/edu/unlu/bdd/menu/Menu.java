package ar.edu.unlu.bdd.menu;

import ar.edu.unlu.bdd.controlador.ControladorEmpleado;
import ar.edu.unlu.bdd.controlador.ControladorProducto;
import ar.edu.unlu.bdd.controlador.ControladorSucursal;
import ar.edu.unlu.bdd.controlador.ControladorVenta;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;

import javax.persistence.EntityManagerFactory;

public class Menu {
    public Menu(EntityManagerFactory emf) {
        int opc;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("TP2 BD2 Ejercicio N°3");
            System.out.println("Seleccione la tabla con la que desea operar:");
            System.out.println("1 - Empleado");
            System.out.println("2 - Producto");
            System.out.println("3 - Sucursal");
            System.out.println("4 - Productos a vender");
            System.out.println("5 - Salir");

            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opción: ");

            switch (opc) {
                case 1:
                    operarEmpleados(emf);
                    break;
                case 2:
                    operarProductos(emf);
                    break;
                case 3:
                    operarSucursales(emf);
                    break;
                case 4:
                    operarProductosAVender(emf);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opc != 3);
    }

    private void operarProductosAVender(EntityManagerFactory emf) {
        ControladorVenta controller = new ControladorVenta(emf);
        controller.iniciarVista();
    }

    private void operarSucursales(EntityManagerFactory emf) {
        ControladorSucursal controller = new ControladorSucursal(emf);
        controller.iniciarVista();
    }

    private void operarProductos(EntityManagerFactory emf) {
        ControladorProducto controller = new ControladorProducto(emf);
        controller.iniciarVista();
    }

    private void operarEmpleados(EntityManagerFactory emf) {
        ControladorEmpleado controller = new ControladorEmpleado(emf);
        controller.iniciarVista();
    }
}
