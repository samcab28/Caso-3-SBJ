package moding.ingeniero.repositorio;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import moding.ingeniero.modelo.Ingeniero;
import org.bson.Document;

import java.util.Iterator;
import java.util.UUID;
import java.util.Vector;

public class ConexionIngeniero {

    private static Vector<Ingeniero> listaIngenieros = new Vector<>();
    private static final String COLLECTION_NAME = "ingeniero";

    private static ConexionIngeniero instance; // Singleton instance
    private final MongoCollection<Document> collection;

    // Private constructor to prevent instantiation
    public ConexionIngeniero(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    // Singleton instance retrieval method
    public static synchronized ConexionIngeniero getInstance(MongoDatabase mongoDatabase) {
        if (instance == null) {
            instance = new ConexionIngeniero(mongoDatabase);
            instance.cargarIngenieros(); // Cargar ingenieros al obtener la instancia
        }
        return instance;
    }

    // Getters
    public static Vector<Ingeniero> getIngenieros() {
        return listaIngenieros;
    }

    public Ingeniero getIngeniero(String correoIngeniero) {
        for (Ingeniero ingeniero : listaIngenieros) {
            if (correoIngeniero.equals(ingeniero.getCorreoIngeniero())) {
                return ingeniero;
            }
        }
        return null;
    }

    // Methods
    public void agregarIngeniero(Ingeniero ingenieroNuevo) {
        listaIngenieros.add(ingenieroNuevo);
        Document document = new Document("_id", UUID.randomUUID().toString())
                .append("correo", ingenieroNuevo.getCorreoIngeniero())
                .append("password", ingenieroNuevo.getPasswordIngeniero())
                .append("nombre", ingenieroNuevo.getNombreIngeniero());

        collection.insertOne(document);
    }

    public void cargarIngenieros() {
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Ingeniero ingeniero = new Ingeniero(
                    documento.getString("correo"),
                    documento.getString("password"),
                    documento.getString("nombre")
            );

            listaIngenieros.add(ingeniero);
        }
    }

    public void eliminarIngeniero(String correoIngeniero) {
        Document filter = new Document("correo", correoIngeniero);
        collection.deleteOne(filter);
        int indexIngeniero = 0;

        for (Ingeniero ingeniero : listaIngenieros) {
            if (ingeniero.getCorreoIngeniero().equals(correoIngeniero)) {
                listaIngenieros.remove(indexIngeniero);
                break; // No need to continue once the element is removed
            }

            indexIngeniero++;
        }
    }


}
