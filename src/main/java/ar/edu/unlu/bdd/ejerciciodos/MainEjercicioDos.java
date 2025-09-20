package ar.edu.unlu.bdd.ejerciciodos;

import ar.edu.unlu.bdd.ejerciciodos.menu.Menu;
import ar.edu.unlu.bdd.utils.UtilDB;

public class MainEjercicioDos {
    public static void main(String[] args) {
        try {
            UtilDB.initEmbebido("bd_ej2");
            new Menu();
        } finally {
            UtilDB.close();
            System.out.println("Programa finalizado.");
        }
    }
}