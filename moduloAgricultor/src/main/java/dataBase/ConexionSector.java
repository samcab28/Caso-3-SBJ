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

import java.util.List;

public class ConexionSector {

    private static final String COLLECTION_NAME = "Sectores";

    private final MongoCollection<Document> collection;

    public ConexionSector(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void obtenerTodosLosSectores(List<Sector> listaSectores) {
        // Realiza una consulta para obtener todos los documentos de the collection
        FindIterable<Document> documentos = collection.find();

        // Itera a través de los documentos and create Sector objects from them
        MongoCursor<Document> cursor = documentos.iterator();
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Sector sector = new Sector(
                    documento.getString("nombre"),
                    getIntegerValue(documento, "lluviaMediaAnual"),
                    getIntegerValue(documento, "temperaturaMediaAnual"),
                    getIntegerValue(documento, "promedioLluvias"),
                    getIntegerValue(documento, "duracionPeriodoSeco")
            );
            listaSectores.add(sector);
        }
    }


    private Integer getIntegerValue(Document document, String key) {
        if (document.containsKey(key) && document.get(key) != null) {
            return document.getInteger(key);
        }
        return 0; // Return a default value (you can change it to suit your needs)
    }



}

