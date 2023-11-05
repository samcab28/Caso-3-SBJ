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

public class ConexionZona {

    private static final String COLLECTION_NAME = "Zonas";

    private final MongoCollection<Document> collection;

    public ConexionZona(MongoDatabase mongoDatabase) {
        // Obtén una referencia a la colección "contactos" desde la instancia de MongoDatabase
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public void obtenerTodosLasZonas(List<Zona> listaZonas, CultivoFacade cultivoFacade, SectorFacade sectorFacade) {
        // Realiza una consulta para obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Itera a través de los documentos y crea objetos Zona a partir de ellos
        MongoCursor<Document> cursor = documentos.iterator();
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            String nombre = documento.getString("nombre");
            float largo = documento.getDouble("largo").floatValue();
            float ancho = documento.getDouble("ancho").floatValue();
            String nombreCultivo = documento.getString("cultivo");
            String nombreSector = documento.getString("sector");

            // Verifica si el cultivo y el sector existen en las listas de cultivos y sectores disponibles
            Cultivo cultivo = cultivoFacade.buscarCultivoPorNombre(nombreCultivo);
            Sector sector = sectorFacade.buscarSectorPorNombre(nombreSector);

            if (cultivo == null) {
                System.out.println("El cultivo '" + nombreCultivo + "' no existe en la lista de cultivos disponibles.");
                continue;
            }

            if (sector == null) {
                System.out.println("El sector '" + nombreSector + "' no existe en la lista de sectores disponibles.");
                continue;
            }

            Zona zona = new Zona(nombre, largo, ancho, cultivo, sector);
            listaZonas.add(zona);
        }
    }

}

