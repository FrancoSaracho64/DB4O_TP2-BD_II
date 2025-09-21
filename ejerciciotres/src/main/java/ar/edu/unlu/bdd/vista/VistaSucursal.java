package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorSucursal;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaSucursal {
    public VistaSucursal(ControladorSucursal controladorSucursal) {
        int opc = 0;
        do {
            Listado.listarMenu("Sucursal");
            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opción: ");
            switch (opc) {
                case 1: {
                    inputAlta(controladorSucursal);
                    break;
                }
                case 2: {
                    inputBaja(controladorSucursal);
                    break;
                }
                case 3: {
                    inputModificacion(controladorSucursal);
                    break;
                }
                case 4: {
                    inputConsulta(controladorSucursal);
                    break;
                }
                case 5: {
                    System.out.println("Saliendo...");
                    break;
                }
                default: System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
    }


    private void inputAlta(ControladorSucursal controladorSucursal) {
        String nombre;
        String direccion;

        // Entrada nombre
        while (true) {
            nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre de la sucursal: ");
            if (!nombre.isEmpty() && nombre.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada direccion
        while (true) {
            direccion = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la dirección de la sucursal: ");
            if (!direccion.isEmpty() && direccion.length() <= 100) break;
            else System.out.println("La dirección no puede estar vacía y debe tener menos de 100 caracteres.");
        }
        controladorSucursal.alta(nombre, direccion);

    }

    private void inputBaja(ControladorSucursal controladorPiloto) {
        String nombre;
        // Entrada nombre
        while (true) {
            nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre de la sucursal: ");
            if (!nombre.isEmpty() && nombre.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }
        controladorPiloto.baja(nombre);
    }

    private void inputModificacion(ControladorSucursal controladorPiloto) {
        String nombre = "";
        String direccion = "";

        // Entrada nombre
        while (true) {
            nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre de la sucursal: ");
            if (!nombre.isEmpty() && nombre.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada NACIONALIDAD
        while (true) {
            direccion = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la Nacionalidad del Piloto: ");
            if (!direccion.isEmpty() && direccion.length() <= 100) break;
            else System.out.println("La nacionalidad no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        controladorPiloto.modificacion(nombre, direccion);

    }

    private void inputConsulta(ControladorSucursal controladorPiloto) {
        String nombre;
        // Entrada nombre
        while (true) {
            nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre de la sucursal ('todas' para ver todas) ");
            if (!nombre.isEmpty() && nombre.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }
        controladorPiloto.consulta(nombre);

    }

    public void mostrarConsulta(String mensaje) {
        System.out.println("\n----------------------------------------------");
        System.out.println(mensaje);
        System.out.println("\n----------------------------------------------");
    }
}
