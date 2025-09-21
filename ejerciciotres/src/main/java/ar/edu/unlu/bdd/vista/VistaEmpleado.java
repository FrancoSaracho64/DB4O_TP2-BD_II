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
        switch (opcion){
            case 1:
                int dni = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese DNI: ");
                String nom = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese Nombre: ");
                String ape = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese Apellido: ");
                String sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");

                controlador.alta(dni, nom, ape, sucursal);
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5: break;
            default: break;
        }

    }

}
