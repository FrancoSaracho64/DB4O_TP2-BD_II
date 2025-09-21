package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.entidad.Carrera;
import ar.edu.unlu.bdd.entidad.CompiteEn;
import ar.edu.unlu.bdd.entidad.Piloto;
import ar.edu.unlu.bdd.vista.VistaCompiteEn;
import ar.edu.unlu.bdd.utils.UtilDB;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class ControladorCompiteEn {
    private ObjectContainer db;

    public ControladorCompiteEn() {
        this.db = UtilDB.getDb();
    }

    public void iniciarVista() {
        new VistaCompiteEn(this);
    }

    public void alta(int idCarrera, int idPiloto, int arranque, int fin, int pts, boolean safety) {
        try {
            // Buscar los objetos reales en la base de datos
            Carrera carrera = buscarCarreraPorId(idCarrera);
            Piloto piloto = buscarPilotoPorId(idPiloto);

            if (carrera == null) {
                System.out.println("No se encontró la carrera con ID: " + idCarrera);
                return;
            }

            if (piloto == null) {
                System.out.println("No se encontró el piloto con ID: " + idPiloto);
                return;
            }

            // Verificar si ya existe esta participación
            CompiteEn participacionExistente = buscarParticipacion(piloto, carrera);
            if (participacionExistente != null) {
                System.out.println("Ya existe una participación de este piloto en esta carrera");
                return;
            }

            CompiteEn compite = new CompiteEn(piloto, carrera, arranque, fin, safety, pts);
            db.store(compite);
            db.commit();
            System.out.println("Participación creada exitosamente: " + piloto.getApenom() + " en " + carrera.getCircuito());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void baja(int carrera, int piloto) {
        try {
            Carrera carreraObj = buscarCarreraPorId(carrera);
            Piloto pilotoObj = buscarPilotoPorId(piloto);

            if (carreraObj == null || pilotoObj == null) {
                System.out.println("No se encontró la carrera o el piloto especificado");
                return;
            }

            CompiteEn participacion = buscarParticipacion(pilotoObj, carreraObj);
            if (participacion != null) {
                db.delete(participacion);
                db.commit();
                System.out.println("Participación eliminada exitosamente");
            } else {
                System.out.println("No se encontró la participación especificada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificacion(int idCarrera, int idPiloto, int arranque, int fin, int pts, boolean safety) {
        try {
            // Buscar los objetos reales en la base de datos
            Carrera carrera = buscarCarreraPorId(idCarrera);
            Piloto piloto = buscarPilotoPorId(idPiloto);

            if (carrera == null) {
                System.out.println("No se encontró la carrera con ID: " + idCarrera);
                return;
            }

            if (piloto == null) {
                System.out.println("No se encontró el piloto con ID: " + idPiloto);
                return;
            }

            CompiteEn participacion = buscarParticipacion(piloto, carrera);
            if (participacion != null) {
                participacion.setPosArranque(arranque);
                participacion.setPosFinal(fin);
                participacion.setPtsObtenidos(pts);
                participacion.setSafetyCar(safety);
                db.store(participacion);
                db.commit();
                System.out.println("Participación modificada exitosamente: " + piloto.getApenom() + " en " + carrera.getCircuito());
            } else {
                System.out.println("No se encontró la participación a modificar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consulta(int carrera, int piloto) {
        try {
            if (carrera == 0 && piloto == 0) {
                // Consultar todas las participaciones
                ObjectSet<CompiteEn> result = db.query(CompiteEn.class);
                if (result.isEmpty()) {
                    System.out.println("No se encontraron participaciones");
                } else {
                    System.out.println("=== TODAS LAS PARTICIPACIONES ===");
                    for (CompiteEn participacion : result) {
                        System.out.println(participacion.toString());
                    }
                }
            } else {
                // Consultar participación específica
                Carrera carreraObj = buscarCarreraPorId(carrera);
                Piloto pilotoObj = buscarPilotoPorId(piloto);

                if (carreraObj == null || pilotoObj == null) {
                    System.out.println("No se encontró la carrera o el piloto especificado");
                    return;
                }

                CompiteEn participacion = buscarParticipacion(pilotoObj, carreraObj);
                if (participacion != null) {
                    System.out.println("=== PARTICIPACIÓN ENCONTRADA ===");
                    System.out.println(participacion.toString());
                } else {
                    System.out.println("No se encontró la participación especificada");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private CompiteEn buscarParticipacion(Piloto piloto, Carrera carrera) {
        Query query = db.query();
        query.constrain(CompiteEn.class);
        query.descend("piloto").descend("idp").constrain(piloto.getIdp());
        query.descend("carrera").descend("idc").constrain(carrera.getIdc());
        ObjectSet<CompiteEn> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }

    private Piloto buscarPilotoPorId(int idp) {
        Query query = db.query();
        query.constrain(Piloto.class);
        query.descend("idp").constrain(idp);
        ObjectSet<Piloto> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }

    private Carrera buscarCarreraPorId(int idc) {
        Query query = db.query();
        query.constrain(Carrera.class);
        query.descend("idc").constrain(idc);
        ObjectSet<Carrera> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }
}
