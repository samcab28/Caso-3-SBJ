package modagri.agricultor.dataBase;

import java.util.Vector;

import modagri.agricultor.almacenamiento.Sector;
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
    public Vector<Sector> getSectores(){
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
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Sector sector = new Sector(
                    documento.getString("nombre"),
                    documento.getInteger("lluviaMediaAnual"),
                    documento.getInteger("temperaturaMedia"),
                    documento.getInteger("promedioLluvias"),
                    documento.getInteger("duracionPeriodoSeco"));

            //System.out.println(cultivo.getNombre());
            listaSectores.add(sector);
        }
    }
}
