package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.menu;
import ar.edu.unlu.bdd.utils.Utildb;
import com.db4o.ObjectContainer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ObjectContainer db = Utildb.getDb();
        try {
            Utildb.initEmbebido();
            new menu();
        } finally {
            db.close(); // cerrar conexión siempre
        }
    }
}