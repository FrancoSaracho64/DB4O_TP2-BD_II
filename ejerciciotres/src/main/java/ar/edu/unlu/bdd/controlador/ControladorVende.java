package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Empleado;
import ar.edu.unlu.bdd.entidad.Vende;
import ar.edu.unlu.bdd.entidad.VendeId;
import ar.edu.unlu.bdd.vista.VistaVende;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ControladorVende {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public ControladorVende(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void iniciarVista() {
        new VistaVende(this);
    }


    public void alta(int codigo, String sucu, Double precio, int stock){
        Vende v = new Vende(codigo, sucu, stock, precio);
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            em.persist(v);
            emt.commit();
            System.out.println("\nRegistrado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en persistiendo Vende, error: "+ex.getMessage());
        }
        finally {
            salir();
        }

    }

    public void baja(int codigo, String sucu){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            VendeId vid = new VendeId(codigo, sucu);
            Vende v = em.find(Vende.class, vid);

            em.remove(v);
            emt.commit();
            System.out.println("\nBorrado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en persistiendo Vende, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public void modificar(int codigo, String sucu, int stock, Double precio){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();

        emt.begin();
        try {
            VendeId vid = new VendeId(codigo, sucu);
            Vende v = em.find(Vende.class, vid);

            v.setPrecio(precio);
            v.setStock(stock);

            emt.commit();
            System.out.println("\nModificado correctamente!");
        }
        catch(Exception ex) {
            System.out.println("Main:Error en modificando Empleado, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public void consulta(int codigo, String sucu){
        em = emf.createEntityManager();
        EntityTransaction emt = em.getTransaction();
        Query query;

        emt.begin();
        try {
            if(!sucu.equalsIgnoreCase("TODOS")) {
                query = em.createQuery("FROM Vende v WHERE v.Codigo = :codigo AND v.Nombre = :nombre", Empleado.class);
                query.setParameter("codigo", codigo);
                query.setParameter("nombre", sucu);
            }
            else query = em.createQuery("FROM Vende v", Vende.class);

            List<Vende> vendeList = query.getResultList();

            if (vendeList.isEmpty()) {
                System.out.println("No hay empleados.");
            } else {
                for (Vende v : vendeList) {
                    System.out.println(v);
                }
            }

            emt.commit();
        }
        catch(Exception ex) {
            System.out.println("Main:Error en consultando Vende, error: "+ex.getMessage());
        }
        finally {
            salir();
        }
    }

    public static void salir() {
        if ( em != null ) em.close();
    }
}
