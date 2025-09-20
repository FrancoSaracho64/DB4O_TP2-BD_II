package ar.edu.unlu.bdd.utils;

import ar.edu.unlu.bdd.entidad.Cliente;
import ar.edu.unlu.bdd.entidad.Factura;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.cs.Db4oClientServer;
import com.db4o.query.Query;

import static ar.edu.unlu.bdd.utils.Utildb.getDb;

public class UtilFactura {

    public static void insert(Factura nuevo) {
        try {
            Factura found = findFirst(new Factura(nuevo.getNro()));
            if ( found != null && found.getId() == nuevo.getId() )
                found.setImporte(nuevo.getImporte());
            else found = nuevo;
            getDb().store(found);
            getDb().commit();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void delete(Factura aborrar) {
        ObjectSet<Factura> os = find(aborrar);
        if ( os != null ) {
            while(os.hasNext()) {
                try {
                    Factura found = os.next();
                    getDb().delete(found);
                    getDb().commit();
                } catch(Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public static Factura findFirst(Factura f) {
        Factura found = null;
        try {
            ObjectSet<Factura> os = getDb().queryByExample(f);
            while(found == null && os.hasNext()) {
                found = os.next();
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return found;
    }

    public static ObjectSet<Factura> find(Factura f) {
        ObjectSet<Factura> os = null;
        try {
            os = getDb().queryByExample(f);
        } catch(Exception ex) {
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
            while(os.hasNext()) {
                found = os.next();
                sb.append(found.toString()+"\n================\n");
                System.out.println("list(os)!="+sb.toString());
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb;
    }


    public static void deleteAll() {
        try {
            ObjectSet<Object> os = getDb().queryByExample(new Object());
            while(os.hasNext()) {
                getDb().delete(os.next());
            }
            getDb().commit();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    /*public static StringBuilder listNotName(String nombre) {
        StringBuilder sb = new StringBuilder();
        try {
            Query query = getDb().query();
            query.constrain(Cliente.class);
            query.descend("nombre").constrain(nombre).not();
            ObjectSet<Cliente> os = query.execute();
            sb=list(os);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb;
    }
    public static StringBuilder listGtCodigo(int codigo) {
        StringBuilder sb = new StringBuilder();
        try {
            Query query = getDb().query();
            query.constrain(Cliente.class);
            query.descend("Id").constrain(codigo).greater();
            ObjectSet<Cliente> os = query.execute();
            sb=list(os);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb;
    }
    public static StringBuilder listGtCodigoAndLike(int codigo,String nombre) {
        StringBuilder sb = new StringBuilder();
        try {
            Query query = getDb().query();
            query.constrain(Cliente.class);
            query.descend("codigo").constrain(codigo).greater().and(
                    query.descend("nombre").constrain(nombre).like()
            );
            ObjectSet<Cliente> os = query.execute();
            sb=list(os);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb;
    }
     */

}
