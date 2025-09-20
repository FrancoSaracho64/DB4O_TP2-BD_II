package ar.edu.unlu.bdd.utils;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;

public class Utildb {
    private static ObjectContainer db = null;
    private static ObjectServer server = null;

    public static void initServer() {
        try{
            server = Db4oClientServer.openServer("mibase.db",8080);
            server.grantAccess("usuario","contrasenia");
            System.out.println("Server db4o running...");
            System.out.println("at localhost,port 8080,database mibase.db ...");
            System.out.println("Press any key to stop");
            System.in.read();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            server.close();
        }
    }
    public static void initEmbebido() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"mibase.db");
    }
    public static void initClient() {
        try{
            db = Db4oClientServer.openClient("localhost", 8080, "usuario", "contrasenia");
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    public static ObjectContainer getDb() { return db; }
    public static void close() {
        System.out.println("close!");
        db.close();
    }


}
