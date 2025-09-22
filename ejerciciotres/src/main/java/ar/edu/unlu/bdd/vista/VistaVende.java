package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorVende;
import ar.edu.unlu.bdd.utils.CFZValidatorUtils;
import ar.edu.unlu.bdd.utils.Listado;

public class VistaVende {
    private ControladorVende controlador;

    public VistaVende(ControladorVende controlador) {
        this.controlador = controlador;
        Listado.listarMenu("PRODUCTOS A VENDER");
        int op = CFZValidatorUtils.solicitarNumeroPorTeclado();
        gestionarOpcion(op);
    }

    private void gestionarOpcion(int op) {
        int codigo = 0, stock;
        Double precio;
        String sucursal;

        switch (op){
            case 1:
                codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese codigo producto: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");
                precio = CFZValidatorUtils.solicitarDoublePorTeclado("Ingrese precio: ");
                stock = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese stock: ");

                controlador.alta(codigo, sucursal, precio, stock);
                break;

            case 2:
                codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese codigo producto: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");

                controlador.baja(codigo, sucursal);
                break;

            case 3:
                codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese codigo producto: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");
                precio = CFZValidatorUtils.solicitarDoublePorTeclado("Ingrese precio: ");
                stock = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese stock: ");

                controlador.modificar(codigo, sucursal, stock, precio);
                break;

            case 4:
                codigo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese codigo producto: ");
                sucursal = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese sucursal: ");

                controlador.consulta(codigo, sucursal);
                break;

            case 5: break;
            default: break;
        }
    }


}
