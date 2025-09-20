package ar.edu.unlu.bdd.utils;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class UtilDB {
    private static ObjectContainer db = null;

    public static void initEmbebido(String dataBaseName) {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dataBaseName + ".db");
    }

    public static ObjectContainer getDb() {
        return db;
    }

    public static void close() {
        System.out.println("Database close!");
        db.close();
    }
}
