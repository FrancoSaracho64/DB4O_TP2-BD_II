package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Producto;
import ar.edu.unlu.bdd.vista.VistaProducto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ControladorProducto {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private VistaProducto v;

    public ControladorProducto(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void iniciarVista() {
        this.v = new VistaProducto(this);
        v.menuVistaProducto();
    }

    // Alta
    public void alta(int codigo, String descripcion, int stock) {
        Producto p = new Producto(codigo, descripcion, stock);
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {
            entityManager.persist(p);
            entityTransaction.commit();
            System.out.println("\nProducto dado de alta correctamente [" + p.getDescripcion() + "].");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            salir();
        }
    }

    //Baja
    public void baja(int codigo) {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {
            Producto p = entityManager.find(Producto.class, codigo);
            if (p != null) {
                entityManager.remove(p);
                entityTransaction.commit();
                System.out.println("\nProducto dado de baja correctamente:\n\n" + p);
            } else {
                System.out.println("\nNo se encontró un producto con el código: " + codigo);
                entityTransaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            salir();
        }
    }

    //Modificacion
    public void modificacion(int codigo, String nuevaDescripcion, int nuevoStock) {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {
            Producto p = entityManager.find(Producto.class, codigo);
            if (p != null) {
                p.setDescripcion(nuevaDescripcion);
                p.setStock(nuevoStock);
                entityManager.merge(p);

                entityTransaction.commit();
                System.out.println("\nProducto modificado correctamente:\n\n" + p);
            } else {
                System.out.println("\nNo se encontró un producto con el código: " + codigo);
                entityTransaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            salir();
        }
    }

    //Consulta
    public void consulta(int codigo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            if (codigo == 0) {
                // Traer todas los productos
                List<Producto> productos = entityManager
                        .createQuery("SELECT p FROM Producto p", Producto.class)
                        .getResultList();

                if (productos.isEmpty()) {
                    System.out.println("\nNo hay productos creados.");
                } else {
                    System.out.println("\n");
                    for (Producto p : productos) {
                        System.out.println(p.toString() + "\n");
                    }
                }
            } else {
                // Buscar por PK
                Producto producto = entityManager.find(Producto.class, codigo);
                if (producto == null) {
                    System.out.println("\nNo se encontró un producto con el código: " + codigo);
                } else {
                    System.out.println(producto + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void salir() {
        if ( entityManager != null ) entityManager.close();
    }
}
