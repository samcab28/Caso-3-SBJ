package dataBase;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import contacto.Contacto;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionContacto {
    private static final String COLLECTION_NAME = "Contactos";

    private final MongoCollection<Document> collection;

    public ConexionContacto(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void agregarContacto(Contacto contacto) {

        String nombre = contacto.getNombre();

        Document existingPerson = (Document) collection.find(Filters.and(Filters.eq("nombre",nombre))).first();


        // Crea un documento con los datos del contacto
        if(existingPerson == null){
            Document documentoContacto = new Document("nombre", contacto.getNombre())
                    .append("telefono", contacto.getTelefono())
                    .append("correo", contacto.getCorreo())
                    .append("usuarioTelegram", contacto.getUsuarioTelegram());

            // Inserta el documento en la colección "contactos"
            collection.insertOne(documentoContacto);
        }
        else{
            System.out.println("contacto ya esta registrado");
        }

    }

    public void borrarContacto(String nombre){

        Bson filtro = Filters.and(
                Filters.eq("nombre", nombre)
        );

        // Borrar la persona que cumple con el filtro
        DeleteResult result = collection.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            System.out.println("Persona borrada con éxito de la base de datos.");
        } else {
            System.out.println("No se encontró ninguna persona con el nombre y la edad especificados.");
        }
    }


}
