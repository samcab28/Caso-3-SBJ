package dataBase;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import contacto.Contacto;
import cultivo.Cultivo;
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

    public void agregarCultivo(Cultivo cultivo){
        String nombre = cultivo.getNombre();

        Document existingPerson = (Document) collection.find(Filters.and(Filters.eq("nombre",nombre))).first();


        // Crea un documento con los datos del contacto
        if(existingPerson == null){
            Document documentoCultivo =new Document("nombre",cultivo.getNombre()).append("tempMinima", cultivo.getTempMinima())
                    .append("tempMaxima", cultivo.getTempMaxima())
                    .append("cantidadAgua",cultivo.getCantidadAgua())
                    .append("diasMinCosecha",cultivo.getDiasMinCosecha())
                    .append("diasMaxCosecha",cultivo.getDiasMaxCosecha());

            // Inserta el documento en la colección "contactos"
            collection.insertOne(documentoCultivo);
        }
        else{
            System.out.println("cultivo ya esta registrado");
        }
    }

    public void borrarCultivo(String nombre){

        Bson filtro = Filters.and(
                Filters.eq("nombre", nombre)
        );

        // Borrar la persona que cumple con el filtro
        DeleteResult result = collection.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            System.out.println("cultivo borrado con éxito de la base de datos.");
        } else {
            System.out.println("No se encontró ningun cultivo especificados.");
        }
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
                    documento.getInteger("diasMaxCosecha")
            );
            listaCultivos.add(cultivo);
        }
    }


}
