package dataBase;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import zona.Zona;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionZona {

    private static final String COLLECTION_NAME = "Zonas";

    private final MongoCollection<Document> collection;

    public ConexionZona(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void agregarZona(Zona zona) {

        String nombre = zona.getNombre();

        Document existingPerson = (Document) collection.find(Filters.and(Filters.eq("nombre",nombre))).first();


        // Crea un documento con los datos del contacto
        if(existingPerson == null){
            Document documentoZona = new Document("nombre", zona.getNombre())
                    .append("largo",zona.getLargo())
                    .append("ancho", zona.getAncho())
                    .append("cultivo",zona.getNombreCultivo())
                    .append("sector",zona.getNombreSector());
            // Inserta el documento en la colección "contactos" collection.insertOne(documentoContacto);
            collection.insertOne(documentoZona);
        }
        else{
            System.out.println("zona ya esta registrado");
        }

    }

    public void borrarSector(String nombre){

        Bson filtro = Filters.and(
                Filters.eq("nombre", nombre)
        );

        // Borrar la persona que cumple con el filtro
        DeleteResult result = collection.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            System.out.println("zona borrada con éxito de la base de datos.");
        } else {
            System.out.println("No se encontró ninguna zona con el nombre especificado");
        }
    }


}
