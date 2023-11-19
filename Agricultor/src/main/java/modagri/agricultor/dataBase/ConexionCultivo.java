package modagri.agricultor.dataBase;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import modagri.agricultor.almacenamiento.Cultivo;
import org.bson.Document;

import java.util.Vector;

public class ConexionCultivo {

    private static Vector<Cultivo> listaCultivos = new Vector<Cultivo>();
    private static final String COLLECTION_NAME = "cultivo";

    private static ConexionCultivo instance; // Singleton instance
    private final MongoCollection<Document> collection;

    // Private constructor to prevent instantiation
    public ConexionCultivo(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    // Singleton instance retrieval method
    public static synchronized ConexionCultivo getInstance(MongoDatabase mongoDatabase) {
        if (instance == null) {
            instance = new ConexionCultivo(mongoDatabase);
            instance.cargarCultivos(); // Cargar cultivos al obtener la instancia
        }
        return instance;
    }

    // Getters
    public Vector<Cultivo> getCultivos(){
        return listaCultivos;
    }

    public Cultivo getCultivo(String nombreCultivo) {
        for (Cultivo cultivo : listaCultivos) {
            if (nombreCultivo.equals(cultivo.getNombre())) {
                return cultivo;
            }
        }
        return null;
    }

    // Metods
    public void agregarCultivo(Cultivo cultivoNuevo) {
        listaCultivos.add(cultivoNuevo);
        Document document = new Document("nombre", cultivoNuevo.getNombre())
                .append("tempMinima", cultivoNuevo.getTempMinima())
                .append("tempMaxima", cultivoNuevo.getTempMaxima())
                .append("cantidadAgua", cultivoNuevo.getCantidadAgua())
                .append("diasMinCosecha", cultivoNuevo.getDiasMinCosecha())
                .append("diasMaxCosecha", cultivoNuevo.getDiasMaxCosecha())
                .append("precioUnidad", cultivoNuevo.getPrecioUnidad())
                .append("cantidadPorMetro2", cultivoNuevo.getCantidadPorMetro2());

        collection.insertOne(document);
    }

    public void cargarCultivos() {
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Cultivo cultivo = new Cultivo(
                    documento.getString("nombre"),
                    documento.getDouble("tempMinima").floatValue(),
                    documento.getDouble("tempMaxima").floatValue(),
                    documento.getDouble("cantidadAgua").floatValue(),
                    documento.getInteger("diasMinCosecha"),
                    documento.getInteger("diasMaxCosecha"),
                    documento.getDouble("precioUnidad").floatValue(),
                    documento.getInteger("cantidadPorMetro2")
            );

            //System.out.println(cultivo.getNombre());
            listaCultivos.add(cultivo);

        }
    }

    public void eliminarCultivo(String nombreCultivo) {
        Document filter = new Document("nombre", nombreCultivo);
        collection.deleteOne(filter);

        int indexCultivo = 0;

        for (Cultivo cultivo : listaCultivos) {
            if (cultivo.getNombre().equals(nombreCultivo)) {
                listaCultivos.remove(indexCultivo);
            }

            indexCultivo++;
        }

        for (Cultivo cultivo : listaCultivos) {
            System.out.println(cultivo.getNombre());

        }
    }
}
