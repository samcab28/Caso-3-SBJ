package dataBase;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseConnection {
    private static MongoDatabaseConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private MongoDatabaseConnection() {
        // Cambia la URL de conexión a tu configuración de MongoDB Atlas
        mongoClient = MongoClients.create("mongodb+srv://ConexionConJava :iQbzhJlzFopbkBWA@cluster0.jxgqi5n.mongodb.net/?retryWrites=true&w=majority");
        database = (MongoDatabase) mongoClient.getDatabase("miBaseDeDatos");
    }

    public static MongoDatabaseConnection getInstance() {
        if (instance == null) {
            instance = new MongoDatabaseConnection();
        }
        return instance;
    }


}


//iQbzhJlzFopbkBWA

//"mongodb+srv://ConexionConJava :iQbzhJlzFopbkBWA@cluster0.jxgqi5n.mongodb.net/?retryWrites=true&w=majority"v