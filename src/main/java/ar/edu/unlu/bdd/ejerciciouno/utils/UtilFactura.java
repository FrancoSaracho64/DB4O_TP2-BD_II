package ar.edu.unlu.bdd.ejerciciouno.utils;

import ar.edu.unlu.bdd.ejerciciouno.entidad.Factura;
import com.db4o.ObjectSet;

import static ar.edu.unlu.bdd.utils.UtilDB.getDb;

public class UtilFactura {

    public static void insert(Factura nuevo) {
        try {
            Factura found = findFirst(new Factura(nuevo.getNro()));
            if (found != null && found.getId() == nuevo.getId())
                found.setImporte(nuevo.getImporte());
            else found = nuevo;
            getDb().store(found);
            getDb().commit();
            System.out.println("\nFactura registrada!");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void delete(Factura aborrar) {
        ObjectSet<Factura> os = find(aborrar);
        if (os != null) {
            while (os.hasNext()) {
                try {
                    Factura found = os.next();
                    getDb().delete(found);
                    getDb().commit();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public static Factura findFirst(Factura f) {
        Factura found = null;
        try {
            ObjectSet<Factura> os = getDb().queryByExample(f);
            while (found == null && os.hasNext()) {
                found = os.next();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return found;
    }

    public static ObjectSet<Factura> find(Factura f) {
        ObjectSet<Factura> os = null;
        try {
            os = getDb().queryByExample(f);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return os;
    }

    public static StringBuilder list(Factura f) {
        return list(find(f));
    }

    public static StringBuilder list(ObjectSet<Factura> os) {
        StringBuilder sb = new StringBuilder();
        try {
            Factura found = null;
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
