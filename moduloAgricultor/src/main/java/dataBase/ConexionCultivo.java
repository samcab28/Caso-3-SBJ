package dataBase;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import almacenamiento.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ConexionCultivo {

    private static final String COLLECTION_NAME = "Cultivos";

    private final MongoCollection<Document> collection;
    public ConexionCultivo(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void obtenerTodosLosCultivos(List<Cultivo> listaCultivos) {
        // Realiza una consulta para obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Itera a través de los documentos y crea objetos Cultivo a partir de ellos
        MongoCursor<Document> cursor = documentos.iterator();
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Cultivo cultivo = new Cultivo(
                    documento.getString("nombre"),
                    documento.getDouble("tempMinima").floatValue(),
                    documento.getDouble("tempMaxima").floatValue(),
                    documento.getDouble("cantidadAgua").floatValue(),
                    documento.getInteger("diasMinCosecha"),
                    documento.getInteger("diasMaxCosecha"),
                    documento.getDouble("precioUnidad").floatValue()
            );
            listaCultivos.add(cultivo);
        }
    }

}
