package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Sucursal;
import ar.edu.unlu.bdd.vista.VistaSucursal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ControladorSucursal {
    private final EntityManagerFactory entityManagerFactory;

    public ControladorSucursal(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }

    public void iniciarVista() {
        new VistaSucursal(this);
    }

    public void alta(String nombre, String direccion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Sucursal sucursal = new Sucursal();
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            entityManager.getTransaction().begin();
            entityManager.persist(sucursal);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    public void baja(String nombre) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Sucursal sucursal = entityManager.find(Sucursal.class, nombre);
            entityManager.remove(sucursal);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    public void consulta(String nombre) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Sucursal sucursal = entityManager.find(Sucursal.class, nombre);

            if (sucursal == null) {
                System.out.println("No se encontró ninguna sucursal con el nombre: " + nombre);
            } else {
                System.out.println(sucursal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void modificacion(String nombre, String direccion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Sucursal sucursal = entityManager.find(Sucursal.class, nombre);
            if (sucursal == null) {
                System.out.println("No se encontró ninguna sucursal con el nombre: " + nombre);
            } else {
                sucursal.setDireccion(direccion);
                entityManager.getTransaction().commit();
                System.out.println("Dirección actualizada correctamente.");
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
