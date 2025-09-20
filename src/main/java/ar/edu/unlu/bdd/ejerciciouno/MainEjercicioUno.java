package ar.edu.unlu.bdd.ejerciciouno;

import ar.edu.unlu.bdd.ejerciciouno.menu.Menu;
import ar.edu.unlu.bdd.utils.UtilDB;

public class MainEjercicioUno {
    public static void main(String[] args) {
        try {
            UtilDB.initEmbebido("bd_ej1");
            new Menu();
        } finally {
            UtilDB.close();
            System.out.println("Programa finalizado.");
        }
    }
}