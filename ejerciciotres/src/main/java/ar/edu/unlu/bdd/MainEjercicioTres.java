package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.menu.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainEjercicioTres {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("firebirdPU");

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            new Menu(emf);
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}