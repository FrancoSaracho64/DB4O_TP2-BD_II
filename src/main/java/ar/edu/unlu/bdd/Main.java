package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.menu;
import ar.edu.unlu.bdd.utils.Utildb;

public class Main {
    public static void main(String[] args) {
        try {
            Utildb.initEmbebido();
            new menu();
        } finally {
            Utildb.close();
            System.out.println("Programa finalizado.");
        }
    }
}