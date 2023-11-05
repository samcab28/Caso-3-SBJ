package dataBase;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDataBaseConnection {
    private static MongoDataBaseConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private MongoDataBaseConnection() {
        // Cambia la URL de conexión a tu configuración de MongoDB Atlas
        mongoClient = MongoClients.create("mongodb+srv://samircabrera2528:Samir1234@cluster0.jxgqi5n.mongodb.net/?retryWrites=true&w=majority");
        database = (MongoDatabase) mongoClient.getDatabase("Caso3-SBJ-DataBase");
    }

    public static MongoDataBaseConnection getInstance() {
        if (instance == null) {
            instance = new MongoDataBaseConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

}


//KGJvE7nqNWYPy9CV