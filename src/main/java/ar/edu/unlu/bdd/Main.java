package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.entidad.Cliente;
import ar.edu.unlu.bdd.utils.UtilCliente;
import ar.edu.unlu.bdd.utils.Utildb;
import com.db4o.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Utildb.initEmbebido();
        ObjectContainer db = Utildb.getDb();
        try {

            //Util.insert(new Cliente(1, "JCROMERO"));
            UtilCliente.list(new Cliente(2, "JCROMERO"));

            System.out.println("Datos guardados correctamente.");
        } finally {
            db.close(); // cerrar conexión siempre
        }
    }
}