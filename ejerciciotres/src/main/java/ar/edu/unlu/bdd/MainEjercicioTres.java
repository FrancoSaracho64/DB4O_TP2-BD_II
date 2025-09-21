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
            em.createNativeQuery("SELECT 1 FROM RDB$DATABASE").getSingleResult(); // consulta mínima a Firebird
            em.getTransaction().commit();


            new Menu();
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}