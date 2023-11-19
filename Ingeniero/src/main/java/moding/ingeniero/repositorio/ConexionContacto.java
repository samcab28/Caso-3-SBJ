package moding.ingeniero.repositorio;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import moding.ingeniero.modelo.Contacto;
import org.bson.Document;

import java.util.Vector;

public class ConexionContacto {

    private static Vector<Contacto> listaContactos = new Vector<>();
    private static final String COLLECTION_NAME = "contacto";

    private static ConexionContacto instance; // Singleton instance
    private final MongoCollection<Document> collection;

    // Private constructor to prevent instantiation
    public ConexionContacto(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    // Singleton instance retrieval method
    public static synchronized ConexionContacto getInstance(MongoDatabase mongoDatabase) {
        if (instance == null) {
            instance = new ConexionContacto(mongoDatabase);
            instance.cargarContactos(); // Cargar contactos al obtener la instancia
        }
        return instance;
    }

    // Getters
    public static Vector<Contacto> getContactos() {
        return listaContactos;
    }

    public Contacto getContacto(String correoContacto) {
        for (Contacto contacto : listaContactos) {
            if (correoContacto.equals(contacto.getCorreoContacto())) {
                return contacto;
            }
        }
        return null;
    }

    // Methods
    public void agregarContacto(Contacto contactoNuevo) {
        listaContactos.add(contactoNuevo);
        Document document = new Document("nombre", contactoNuevo.getNombreContacto())
                .append("apellido", contactoNuevo.getApellidoContacto())
                .append("telefono", contactoNuevo.getTelefonoContacto())
                .append("correo", contactoNuevo.getCorreoContacto())
                .append("usuarioTelegram", contactoNuevo.getUsuarioTelegramContacto());

        collection.insertOne(document);
    }

    public void cargarContactos() {
        FindIterable<Document> documentos = collection.find();
        MongoCursor<Document> cursor = documentos.iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Contacto contacto = new Contacto(
                    documento.getString("nombre"),
                    documento.getString("apellido"),
                    documento.getString("telefono"),
                    documento.getString("correo"),
                    documento.getString("usuarioTelegram")
            );

            listaContactos.add(contacto);
        }
    }

    public void eliminarContacto(String correoContacto) {
        Document filter = new Document("correo", correoContacto);
        collection.deleteOne(filter);

        int indexContacto = 0;

        for (Contacto contacto : listaContactos) {
            if (contacto.getCorreoContacto().equals(correoContacto)) {
                listaContactos.remove(indexContacto);
                break; // No need to continue once the element is removed
            }

            indexContacto++;
        }
    }
}
