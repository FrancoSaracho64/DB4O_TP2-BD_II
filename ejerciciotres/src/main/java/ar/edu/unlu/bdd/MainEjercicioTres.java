package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.Menu;

public class MainEjercicioTres {
    public static void main(String[] args) {
        try {
            new Menu();
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}