package moding.ingeniero.repositorioConexion;

import java.util.Vector;

import moding.ingeniero.modelo.Sector;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConexionSector {

    private static Vector<Sector> listaSectores = new Vector<Sector>();
    private static final String COLLECTION_NAME = "sector";

    private static ConexionSector instance; // Singleton instance
    private final MongoCollection<Document> collection;

    // Private constructor to prevent instantiation
    public ConexionSector(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    // Singleton instance retrieval method
    public static synchronized ConexionSector getInstance(MongoDatabase mongoDatabase) {
        if (instance == null) {
            instance = new ConexionSector(mongoDatabase);
            instance.cargarSectores(); // Cargar sectores al obtener la instancia
        }
        return instance;
    }



    // Getters
    public static Vector<Sector> getSectores(){
        return listaSectores;
    }

    public Sector getSector(String nombreSector) {
        for (Sector sector : listaSectores) {
            if (sector.getNombre().equals(nombreSector)) {
                return sector;
            }
        }
        return null;
    }

    // Metods
    public void cargarSectores() {
        listaSectores.clear();
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Sector sector = new Sector(
                    documento.getString("nombre"),
                    getIntegerFromDocument(documento, "lluviaMediaAnual"),
                    getIntegerFromDocument(documento, "temperaturaMedia"),
                    getIntegerFromDocument(documento, "promedioLluvias"),
                    getIntegerFromDocument(documento, "duracionPeriodoSeco"));

            //System.out.println(cultivo.getNombre());
            listaSectores.add(sector);
        }
    }

    private int getIntegerFromDocument(Document document, String fieldName) {
        Number number = (Number) document.get(fieldName);
        return (number != null) ? number.intValue() : 0; // or handle null as needed
    }


    public void agregarSector(Sector sectorNuevo) {
        listaSectores.add(sectorNuevo);
        Document document = new Document("nombre", sectorNuevo.getNombre())
                .append("lluviaMediaAnual", sectorNuevo.getLluviaMediaAnual())
                .append("temperaturaMedia", sectorNuevo.getTemperaturaMedia())
                .append("promedioLluvias", sectorNuevo.getPromedioLluvias())
                .append("duracionPeriodoSeco", sectorNuevo.getDuracionPeriodoSeco());

        collection.insertOne(document);
    }

    public void eliminarSector(String sectorBorrado){
        Document filter = new Document("nombre", sectorBorrado);
        collection.deleteOne(filter);

        int indexCultivo = 0;

        for (Sector sector : listaSectores) {
            if (sector.getNombre().equals(sectorBorrado)) {
                listaSectores.remove(indexCultivo);
            }

            indexCultivo++;
        }

        for (Sector sector : listaSectores) {
            System.out.println(sector.getNombre());
        }
    }

    public void modificarSector(
            String nombreActual,
            String nuevoNombre,
            String lluviaMediaAnual,
            String temperaturaMedia,
            String promedioLluvias,
            String duracionPeriodoSeco) {

        // Crear un filtro para identificar el sector que se va a modificar
        Document filtro = new Document("nombre", nombreActual);

        // Crear un documento con los campos a modificar
        Document update = new Document();

        if (!nuevoNombre.isEmpty()) {
            update.append("nombre", nuevoNombre);
            System.out.println("Se modificó nombre de: " + nombreActual + " a: " + nuevoNombre);
        }
        if (!lluviaMediaAnual.isEmpty()) {
            update.append("lluviaMediaAnual", Integer.parseInt(lluviaMediaAnual));
            System.out.println("Se modificó lluviaMediaAnual a: " + lluviaMediaAnual);
        }
        if (!temperaturaMedia.isEmpty()) {
            update.append("temperaturaMedia", Integer.parseInt(temperaturaMedia));
            System.out.println("Se modificó temperaturaMedia a: " + temperaturaMedia);
        }
        if (!promedioLluvias.isEmpty()) {
            update.append("promedioLluvias", Integer.parseInt(promedioLluvias));
            System.out.println("Se modificó promedioLluvias a: " + promedioLluvias);
        }
        if (!duracionPeriodoSeco.isEmpty()) {
            update.append("duracionPeriodoSeco", Integer.parseInt(duracionPeriodoSeco));
            System.out.println("Se modificó duracionPeriodoSeco a: " + duracionPeriodoSeco);
        }

        // Realizar la actualización en la base de datos
        collection.updateOne(filtro, new Document("$set", update));
        cargarSectores();
    }

}
