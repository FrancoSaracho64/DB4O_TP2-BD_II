package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Empleado;
import ar.edu.unlu.bdd.vista.VistaEmpleado;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionRequiredException;

public class ControladorEmpleado {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public ControladorEmpleado(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void iniciarVista() {
        new VistaEmpleado(this);
    }

    public void alta(int dni, String nom, String ape, String sucu){
        Empleado e = new Empleado(dni, nom, ape, sucu);
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            em.persist(e);
            emt.commit();
            System.out.println("\nEmpleado creado correctamente!\n");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en persistiendo Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }

    }

    public void baja(){

    }

    public void modificar(){

    }

    public void consulta(){

    }

    public static void salir() {
        if ( em != null ) em.close();
    }


}
