package ar.edu.unlu.bdd.ejerciciotres;

import ar.edu.unlu.bdd.ejerciciotres.menu.Menu;

public class MainEjercicioTres {
    public static void main(String[] args) {
        try {
            new Menu();
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}