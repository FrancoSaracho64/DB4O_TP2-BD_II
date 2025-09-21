package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorProducto;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaProducto {

    private final ControladorProducto controladorProducto;

    public VistaProducto(ControladorProducto controladorProducto) {
        this.controladorProducto = controladorProducto;
    }

    public void menuVistaProducto() {
        int opc = 0;
        do {
            Listado.listarMenu("Producto");
            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");
            switch (opc) {
                case 1:
                    inputAlta(controladorProducto);
                    break;
                case 2:
                    inputBaja(controladorProducto);
                    break;
                case 3:
                    inputModificacion(controladorProducto);
                    break;
                case 4:
                    inputConsulta(controladorProducto);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opc != 5);
    }

    private void inputAlta(ControladorProducto controladorProducto) {

        int codigo = 0;
        String descripcion = "";
        int stock = 0;

        // En alta el CODIGO es generado automaticamente

        // Entrada DESCRIPCIÓN
        while (true) {
            descripcion = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la Descripción del Producto: ");
            if (!descripcion.isEmpty() && descripcion.length() <= 100) break;
            else System.out.println("La descripción no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //El valor de STOCK se gestiona automaticamente

        controladorProducto.alta(codigo, descripcion, stock);
    }

    private void inputBaja(ControladorProducto controladorProducto) {
        int codigo = 0;

        // Entrada CODIGO
        while (true) {
            codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese Código del Producto: ");
            if (codigo > 0) break;
            else System.out.println("El Código debe ser positivo.");
        }

        controladorProducto.baja(codigo);
    }

    private void inputModificacion(ControladorProducto controladorProducto) {
        int codigo = 0;
        String descripcion = "";
        int stock = 0;

        //  ++ Busqueda del Producto

        // Entrada CODIGO
        while (true) {
            codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese Código del Producto: ");
            if (codigo > 0) break;
            else System.out.println("El Código debe ser positivo.");
        }

        //  ++ Modificacion del Producto

        // Entrada DESCRIPCIÓN
        while (true) {
            descripcion = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la Descripción del Producto: ");
            if (!descripcion.isEmpty() && descripcion.length() <= 100) break;
            else System.out.println("La descripción no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //En el alta hardcodear a 0
        //El valor de STOCK se gestiona automaticamente

        controladorProducto.modificacion(codigo, descripcion, stock);
    }

    private void inputConsulta(ControladorProducto controladorProducto) {
        int codigo = 0;

        // Entrada CODIGO
        while (true) {
            codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese Código del Producto: ");
            if (codigo > 0) break;
            else System.out.println("El Código debe ser positivo.");
        }

        controladorProducto.consulta(codigo);
    }

    public void mostrarConsulta(String mensaje) {
        System.out.println("\n----------------------------------------------");
        System.out.println(mensaje);
        System.out.println("\n----------------------------------------------");
    }
}