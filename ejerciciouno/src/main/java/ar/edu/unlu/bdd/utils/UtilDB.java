package ar.edu.unlu.bdd.utils;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class UtilDB {
    private static ObjectContainer db;

    public static ObjectContainer getDb() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd_ej1.db");
        }
        return db;
    }

    public static void initEmbebido(String dbName) {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName + ".db");
        }
    }

    public static void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    public static void closeDb() {
        if (db != null) {
            db.close();
            db = null;
        }
    }
}
