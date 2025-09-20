package ar.edu.unlu.bdd.ejerciciodos.controlador;

import ar.edu.unlu.bdd.ejerciciodos.entidad.Equipo;
import ar.edu.unlu.bdd.ejerciciodos.vista.VistaEquipo;
import ar.edu.unlu.bdd.utils.UtilDB;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class ControladorEquipo {
    private ObjectContainer db;

    public ControladorEquipo() {
        this.db = UtilDB.getDb();
    }

    public void iniciarVista() {
        new VistaEquipo(this);
    }

    public void alta(int ide, String nombre, String pais, int temporadas) {
        try {
            // Verificar si ya existe un equipo con ese ID
            Equipo equipoExistente = buscarPorId(ide);
            if (equipoExistente != null) {
                System.out.println("Ya existe un equipo con el ID: " + ide);
                return;
            }

            Equipo equipo = new Equipo(ide, nombre, pais, temporadas);
            db.store(equipo);
            db.commit();
            System.out.println("Equipo creado exitosamente: " + equipo.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void baja(Integer id) {
        try {
            Equipo equipo = buscarPorId(id);
            if (equipo != null) {
                db.delete(equipo);
                db.commit();
                System.out.println("Equipo eliminado exitosamente: " + equipo.getNombre());
            } else {
                System.out.println("No se encontró un equipo con el ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificacion(Integer id, String nombre, String pais, Integer temporadas) {
        try {
            Equipo equipo = buscarPorId(id);
            if (equipo != null) {
                equipo.setNombre(nombre);
                equipo.setPais(pais);
                equipo.setTemporadasCompitidas(temporadas);
                db.store(equipo);
                db.commit();
                System.out.println("Equipo modificado exitosamente: " + equipo.getNombre());
            } else {
                System.out.println("No se encontró un equipo con el ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consulta(Integer id) {
        try {
            if (id == 0) {
                // Consultar todos los equipos
                ObjectSet<Equipo> result = db.query(Equipo.class);
                if (result.isEmpty()) {
                    System.out.println("No hay equipos registrados.");
                } else {
                    System.out.println("=== TODOS LOS EQUIPOS ===");
                    for (Equipo equipo : result) {
                        System.out.println(equipo.toString());
                    }
                }
            } else {
                // Consultar equipo específico
                Equipo equipo = buscarPorId(id);
                if (equipo != null) {
                    System.out.println("=== EQUIPO ENCONTRADO ===");
                    System.out.println(equipo.toString());
                } else {
                    System.out.println("No se encontró un equipo con el ID: " + id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Equipo buscarPorId(Integer id) {
        Query query = db.query();
        query.constrain(Equipo.class);
        query.descend("ide").constrain(id);
        ObjectSet<Equipo> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }
}
