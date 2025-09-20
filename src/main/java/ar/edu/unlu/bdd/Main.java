package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.Menu;
import ar.edu.unlu.bdd.utils.Utildb;

public class Main {
    public static void main(String[] args) {
        try {
            Utildb.initEmbebido();
            new Menu();
        } finally {
            Utildb.close();
            System.out.println("Programa finalizado.");
        }
    }
}