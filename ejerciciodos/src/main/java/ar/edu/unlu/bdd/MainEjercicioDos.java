package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.Menu;
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