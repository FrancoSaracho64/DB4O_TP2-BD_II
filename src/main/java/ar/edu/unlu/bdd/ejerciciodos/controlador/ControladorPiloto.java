package ar.edu.unlu.bdd.ejerciciodos.controlador;

import ar.edu.unlu.bdd.ejerciciodos.entidad.Equipo;
import ar.edu.unlu.bdd.ejerciciodos.entidad.Piloto;
import ar.edu.unlu.bdd.ejerciciodos.vista.VistaPiloto;
import ar.edu.unlu.bdd.utils.UtilDB;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class ControladorPiloto {
    private ObjectContainer db;
    private VistaPiloto v;

    public ControladorPiloto() {
        this.db = UtilDB.getDb();
    }

    public void iniciarVista() {
        this.v = new VistaPiloto(this);
        v.menuVistaPiloto();
    }

    // Alta
    public void alta(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        try {
            // Verificar si ya existe un piloto con ese ID
            Piloto pilotoExistente = buscarPorId(idp);
            if (pilotoExistente != null) {
                System.out.println("Ya existe un piloto con el ID: " + idp);
                return;
            }

            Piloto piloto = new Piloto(idp, apeNom, nacionalidad, puntos, equipo);

            // Asignar equipo si se proporciona
            if (equipo > 0) {
                Equipo equipoObj = buscarEquipoPorId(equipo);
                if (equipoObj != null) {
                    piloto.setEquipo(equipoObj);
                    equipoObj.addPiloto(piloto);
                } else {
                    System.out.println("No se encontró el equipo con ID: " + equipo);
                }
            }

            db.store(piloto);
            db.commit();
            System.out.println("Piloto creado exitosamente: " + piloto.getApenom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Baja
    public void baja(int idp) {
        try {
            Piloto piloto = buscarPorId(idp);
            if (piloto != null) {
                db.delete(piloto);
                db.commit();
                System.out.println("Piloto eliminado exitosamente: " + piloto.getApenom());
            } else {
                System.out.println("No se encontró un piloto con el ID: " + idp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Modificacion
    public void modificacion(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        try {
            Piloto piloto = buscarPorId(idp);
            if (piloto != null) {
                piloto.setApenom(apeNom);
                piloto.setNacionalidad(nacionalidad);
                piloto.setPts(puntos);

                // Asignar nuevo equipo si se proporciona
                if (equipo > 0) {
                    Equipo equipoObj = buscarEquipoPorId(equipo);
                    if (equipoObj != null) {
                        piloto.setEquipo(equipoObj);
                        equipoObj.addPiloto(piloto);
                    } else {
                        System.out.println("No se encontró el equipo con ID: " + equipo);
                    }
                }

                db.store(piloto);
                db.commit();
                System.out.println("Piloto modificado exitosamente: " + piloto.getApenom());
            } else {
                System.out.println("No se encontró un piloto con el ID: " + idp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Consulta
    public void consulta(int id) {
        String retornoConsulta = "";
        try {
            if (id == 0) {
                // Consultar todos los pilotos
                ObjectSet<Piloto> result = db.query(Piloto.class);
                if (result.isEmpty()) {
                    retornoConsulta = "La tabla de pilotos está vacía...";
                } else {
                    retornoConsulta = "=== TODOS LOS PILOTOS ===\n";
                    for (Piloto piloto : result) {
                        retornoConsulta += piloto.toString() + "\n";
                    }
                }
            } else {
                // Consultar piloto específico
                Piloto piloto = buscarPorId(id);
                if (piloto != null) {
                    retornoConsulta = "=== PILOTO ENCONTRADO ===\n" + piloto.toString();
                } else {
                    retornoConsulta = "No se encontró el Piloto buscado...";
                }
            }
            v.mostrarConsulta(retornoConsulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Piloto buscarPorId(int idp) {
        Query query = db.query();
        query.constrain(Piloto.class);
        query.descend("idp").constrain(idp);
        ObjectSet<Piloto> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }

    private Equipo buscarEquipoPorId(int ide) {
        Query query = db.query();
        query.constrain(Equipo.class);
        query.descend("ide").constrain(ide);
        ObjectSet<Equipo> result = query.execute();
        return result.hasNext() ? result.next() : null;
    }
}
