package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorEmpleado;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaEmpleado {
    private ControladorEmpleado controlador;

    public VistaEmpleado(ControladorEmpleado controlador) {
        this.controlador = controlador;
        Listado.listarMenu("EMPLEADO");
        int op = CFZValidatorUtils.solicitarNumeroPorTeclado();
        gestionarOpcion(op);
    }

    private void gestionarOpcion(int opcion){
        int dni = 0;
        String nom, ape, sucursal;

        switch (opcion){
            case 1:
                dni = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese DNI: ");
                nom = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese Nombre: ");
                ape = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese Apellido: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");

                controlador.alta(dni, nom, ape, sucursal);
                break;

            case 2:
                dni = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese DNI: ");

                controlador.baja(dni);
                break;

            case 3:
                dni = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese DNI: ");
                nom = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese nuevo nombre: ");
                ape = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese nuevo apellido: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese nuevo sucursal: ");

                controlador.modificar(dni, nom, ape, sucursal);
                break;

            case 4:
                dni = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese DNI (0 = TODOS): ");

                controlador.consulta(dni);
                break;

            case 5: break;
            default: break;
        }

    }

}
