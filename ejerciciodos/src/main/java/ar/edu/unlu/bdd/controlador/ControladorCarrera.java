package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Carrera;
import ar.edu.unlu.bdd.vista.VistaCarrera;
import ar.edu.unlu.bdd.utils.UtilDB;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class ControladorCarrera {
    private ObjectContainer db;

    public ControladorCarrera() {
        this.db = UtilDB.getDb();
    }

    public void iniciarVista() {
        new VistaCarrera(this);
    }

    public void alta(int idc, String circuito, String pais, int vueltas, String fecha) {
        try {
            // Verificar si ya existe una carrera con ese ID
            Carrera carreraExistente = buscarPorId(idc);
            if (carreraExistente != null) {
                System.out.println("Ya existe una carrera con el ID: " + idc);
                return;
            }

            Carrera carrera = new Carrera(idc, circuito, pais, fecha, vueltas);
            db.store(carrera);
            db.commit();
            System.out.println("Carrera creada exitosamente: " + carrera.getCircuito());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void baja(int idc) {
        try {
            Carrera carrera = buscarPorId(idc);
            if (carrera != null) {
                db.delete(carrera);
                db.commit();
                System.out.println("Carrera eliminada exitosamente: " + carrera.getCircuito());
            } else {
                System.out.println("No se encontró una carrera con el ID: " + idc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificacion(int idc, String circuito, String pais, int vueltas, String fecha) {
        try {
            Carrera carrera = buscarPorId(idc);
            if (carrera != null) {
                carrera.setCircuito(circuito);
                carrera.setPais(pais);
                carrera.setCantVueltas(vueltas);
                carrera.setFecha(fecha);
                db.store(carrera);
                db.commit();
                System.out.println("Carrera modificada exitosamente: " + carrera.getCircuito());
            } else {
                System.out.println("No se encontró una carrera con el ID: " + idc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consulta(int idc) {
        try {
            if (idc == 0) {
                // Consultar todas las carreras
                ObjectSet<Carrera> result = db.query(Carrera.class);
                if (result.isEmpty()) {
                    System.out.println("No hay carreras registradas.");
                } else {
                    System.out.println("=== TODAS LAS CARRERAS ===");
                    for (Carrera carrera : result) {
                        System.out.println(carrera.toString());
                    }
                }
            } else {
                // Consultar carrera específica
                Carrera carrera = buscarPorId(idc);
                if (carrera != null) {
                    System.out.println("=== CARRERA ENCONTRADA ===");
                    System.out.println(carrera.toString());
                } else {
                    System.out.println("No se encontró una carrera con el ID: " + idc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Carrera buscarPorId(int idc) {
        Query query = db.query();
        query.constrain(Carrera.class);
        query.descend("idc").constrain(idc);
        ObjectSet<Carrera> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }
}
