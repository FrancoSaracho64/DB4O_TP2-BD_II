package ar.edu.unlu.bdd.utils;

import ar.edu.unlu.bdd.entidad.Cliente;
import com.db4o.ObjectSet;

import static ar.edu.unlu.bdd.utils.Utildb.getDb;

/**
 * Esta clase encapsula las operaciones para persistir a clientes
 * dentro de b.d. db4o
 * Tambien permite ejecutar db4o y conectarse a su contenedor de objetos
 * en forma embebida o bien ejecutar servidor o bien ejecutar cliente
 *
 * @author G. Cherencio
 * @version 1.0
 */
public class UtilCliente {


    public static void insert(Cliente nuevo) {
        try {
            Cliente found = findFirst(new Cliente(nuevo.getId()));
            if (found != null && found.getId() == nuevo.getId())
                found.setDescr(nuevo.getDescr());
            else found = nuevo;
            Utildb.getDb().store(found);
            Utildb.getDb().commit();
            System.out.println("\nCliente registrado!");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void delete(Cliente aborrar) {
        ObjectSet<Cliente> os = find(aborrar);
        if (os != null) {
            while (os.hasNext()) {
                try {
                    Cliente found = os.next();
                    getDb().delete(found);
                    getDb().commit();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public static Cliente findFirst(Cliente c) {
        Cliente found = null;
        try {
            ObjectSet<Cliente> os = getDb().queryByExample(c);
            while (found == null && os.hasNext()) {
                found = os.next();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return found;
    }

    public static ObjectSet<Cliente> find(Cliente c) {
        ObjectSet<Cliente> os = null;
        try {
            os = getDb().queryByExample(c);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return os;
    }

    public static StringBuilder list(Cliente c) {
        return list(find(c));
    }

    public static StringBuilder list(ObjectSet<Cliente> os) {
        StringBuilder sb = new StringBuilder();
        try {
            Cliente found = null;
            while (os.hasNext()) {
                found = os.next();
                sb.append(found.toString() + "\n================\n");
                System.out.println("list(os)!=" + sb.toString());
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb;
    }

}