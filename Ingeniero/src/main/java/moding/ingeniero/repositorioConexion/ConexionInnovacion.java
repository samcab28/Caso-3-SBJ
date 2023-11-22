package moding.ingeniero.repositorioConexion;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import moding.ingeniero.modelo.Innovacion;
import org.bson.Document;

import java.util.Vector;

public class ConexionInnovacion {

    private static Vector<Innovacion> listaInnovaciones = new Vector<>();
    private static final String COLLECTION_NAME = "innovacion";

    private static ConexionInnovacion instance; // Singleton instance
    private final MongoCollection<Document> collection;

    // Private constructor to prevent instantiation
    private ConexionInnovacion(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    // Singleton instance retrieval method
    public static synchronized ConexionInnovacion getInstance(MongoDatabase mongoDatabase) {
        if (instance == null) {
            instance = new ConexionInnovacion(mongoDatabase);
            instance.cargarInnovaciones(); // Cargar innovaciones al obtener la instancia
        }
        return instance;
    }

    // Getters
    public static Vector<Innovacion> getInnovaciones() {
        return listaInnovaciones;
    }

    public Innovacion getInnovacion(String nombreInnovacion) {
        for (Innovacion innovacion : listaInnovaciones) {
            if (nombreInnovacion.equals(innovacion.getNombreInnovacion())) {
                return innovacion;
            }
        }
        return null;
    }

    // Métodos
    public void agregarInnovacion(Innovacion innovacionNueva) {
        listaInnovaciones.add(innovacionNueva);
        Document document = new Document("nombre", innovacionNueva.getNombreInnovacion())
                .append("linkPagina", innovacionNueva.getLinkPaginaInnovacion())
                .append("descripcion", innovacionNueva.getDescripcionInnovacion())
                .append("costo", innovacionNueva.getCostoInnovacion());

        collection.insertOne(document);
    }

    public void cargarInnovaciones() {
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Innovacion innovacion = new Innovacion(
                    documento.getString("nombre"),
                    documento.getString("linkPagina"),
                    documento.getString("descripcion"),
                    documento.getDouble("costo")
            );

            listaInnovaciones.add(innovacion);
        }
    }

    public void eliminarInnovacion(String nombreInnovacion) {
        Document filter = new Document("nombre", nombreInnovacion);
        collection.deleteOne(filter);

        int indexInnovacion = 0;

        for (Innovacion innovacion : listaInnovaciones) {
            if (innovacion.getNombreInnovacion().equals(nombreInnovacion)) {
                listaInnovaciones.remove(indexInnovacion);
                break; // Se rompe el bucle ya que se ha eliminado la innovación
            }

            indexInnovacion++;
        }
    }
}
