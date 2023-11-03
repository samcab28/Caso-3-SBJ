package dataBase;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import contacto.Contacto;
import org.bson.Document;

public class ConexionContacto {
    private static final String COLLECTION_NAME = "Contactos";

    private final MongoCollection<Document> collection;

    public ConexionContacto(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void agregarContacto(Contacto contacto) {
        // Crea un documento con los datos del contacto
        Document documentoContacto = new Document("nombre", contacto.getNombre())
                .append("telefono", contacto.getTelefono())
                .append("correo", contacto.getCorreo())
                .append("usuarioTelegram", contacto.getUsuarioTelegram());

        // Inserta el documento en la colección "contactos"
        collection.insertOne(documentoContacto);
    }

}
