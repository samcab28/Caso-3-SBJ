package dataBase;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import sector.Sector;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionSector {

    private static final String COLLECTION_NAME = "Sectores";

    private final MongoCollection<Document> collection;

    public ConexionSector(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void agregarSector(Sector sector) {

        String nombre = sector.getNombre();

        Document existingPerson = (Document) collection.find(Filters.and(Filters.eq("nombre",nombre))).first();


        // Crea un documento con los datos del contacto
        if(existingPerson == null){
            Document documentoSector = new Document("nombre", sector.getNombre())
                    .append("lluviaMediaAnual",sector.getLluviaMediaAnual())
                            .append("temperaturaMediaAnual",sector.getLluviaMediaAnual())
                                    .append("promedioLluvias",sector.getLluviaMediaAnual())
                                            .append("duracionPeriodoSeco",sector.getDuracionPeriodoSeco());

            // Inserta el documento en la colección "contactos"
            collection.insertOne(documentoSector);
        }
        else{
            System.out.println("sector ya esta registrado");
        }

    }

    public void borrarSector(String nombre){

        Bson filtro = Filters.and(
                Filters.eq("nombre", nombre)
        );

        // Borrar la persona que cumple con el filtro
        DeleteResult result = collection.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            System.out.println("sector borrado con éxito de la base de datos.");
        } else {
            System.out.println("No se encontró ningun sector con el nombre especificados.");
        }
    }


}
