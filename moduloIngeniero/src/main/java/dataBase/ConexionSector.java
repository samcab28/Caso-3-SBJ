package dataBase;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import sector.Sector;
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


    public void obtenerTodosLosSectores(List<Sector> listaSectores) {
        // Realiza una consulta para obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Itera a través de los documentos y crea objetos Sector a partir de ellos
        MongoCursor<Document> cursor = documentos.iterator();
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Sector sector = new Sector(
                    documento.getString("nombre"),
                    documento.getInteger("lluviaMediaAnual"),
                    documento.getDouble("temperaturaMedia"),
                    documento.getInteger("promedioLluvias"),
                    documento.getInteger("duracionPeriodoSeco")
            );
            listaSectores.add(sector);
        }
    }




}
