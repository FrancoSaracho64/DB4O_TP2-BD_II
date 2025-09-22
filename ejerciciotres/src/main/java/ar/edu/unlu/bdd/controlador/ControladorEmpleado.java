package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Empleado;
import ar.edu.unlu.bdd.entidad.Sucursal;
import ar.edu.unlu.bdd.vista.VistaEmpleado;

import javax.persistence.*;
import java.util.List;

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
            System.out.println("\nEmpleado creado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en persistiendo Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }

    }

    public void baja(int dni){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            Empleado e = em.find(Empleado.class, dni);
            em.remove(e);
            emt.commit();
            System.out.println("\nEmpleado borrado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en persistiendo Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public void modificar(int dni, String nom, String ape, String sucu){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            Empleado e = em.find(Empleado.class, dni);
            e.setNombre(nom);
            e.setApellido(ape);
            e.setSucursal(sucu);
            emt.commit();
            System.out.println("\nEmpleado modificado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en modificando Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public void consulta(int dni){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();
        Query query;

        emt.begin();
        try {
            if(dni != 0) {
                query = em.createQuery("FROM Empleado e WHERE e.dni = :dni", Empleado.class);
                query.setParameter("dni", dni);
            }
            else query = em.createQuery("FROM Empleado e", Empleado.class);

            List<Empleado> empleados = query.getResultList();

            if (empleados.isEmpty()) {
                System.out.println("No hay empleados.");
            } else {
                for (Empleado e : empleados) {
                    System.out.println(e);
                }
            }

            emt.commit();
        }
        catch(Exception ex) {
            System.out.println("Main:Error en consultando Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public static void salir() {
        if ( em != null ) em.close();
    }


}
