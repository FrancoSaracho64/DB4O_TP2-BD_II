package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaEquipo {
    public VistaEquipo(ControladorEquipo controladorEquipo) {
        int opc;
        do {
            Listado.listarMenu("Equipo");
            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1: {
                    // ID
                    Integer id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID del equipo: ");
                    // Nombre
                    String nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre del equipo: ");
                    // País
                    String pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el país del equipo: ");
                    // Temporadas
                    Integer temporadas = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese la cantidad de temporadas: ");

                    controladorEquipo.alta(id, nombre, pais, temporadas);
                    break;
                }
                case 2: {
                    controladorEquipo.baja(CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID del equipo: "));
                    break;
                }
                case 3: {
                    // ID
                    Integer id = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID del equipo: ");
                    // Nombre
                    String nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre del equipo: ");
                    // País
                    String pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el país del equipo: ");
                    // Temporadas
                    Integer temporadas = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese la cantidad de temporadas: ");

                    controladorEquipo.modificacion(id, nombre, pais, temporadas);
                    break;
                }
                case 4: {
                    controladorEquipo.consulta(CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID del equipo (0 para ver todos): "));
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
}
