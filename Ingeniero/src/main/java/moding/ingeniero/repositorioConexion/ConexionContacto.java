package moding.ingeniero.repositorioConexion;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import moding.ingeniero.modelo.contacto.Contacto;
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
        listaContactos.clear();

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

    public void modificarContacto(
            String correoContacto,
            String nuevoNombre,
            String nuevoApellido,
            String nuevoTelefono,
            String nuevoCorreo,
            String nuevoUsuarioTelegram
    ){
        Document filtro = new Document("correo", correoContacto);

        // Crear un documento con los campos a modificar
        Document update = new Document();

        if (!nuevoNombre.isEmpty()) {
            update.append("nombre", nuevoNombre);
            System.out.println("Se modificó nombre a: " + nuevoNombre);
        }

        if (!nuevoApellido.isEmpty()) {
            update.append("apellido", nuevoApellido);
            System.out.println("Se modificó apellido a: " + nuevoApellido);
        }

        if (!nuevoApellido.isEmpty()) {
            update.append("apellido", nuevoApellido);
            System.out.println("Se modificó apellido a: " + nuevoApellido);
        }

        if (!nuevoTelefono.isEmpty()) {
            update.append("telefono", nuevoTelefono);
            System.out.println("Se modificó telefono a: " + nuevoTelefono);
        }

        if (!correoContacto.isEmpty()) {
            update.append("correo", nuevoCorreo);
            System.out.println("Se modificó correo a: " + nuevoCorreo);
        }

        if (!nuevoUsuarioTelegram.isEmpty()) {
            update.append("usuarioTelegram", nuevoUsuarioTelegram);
            System.out.println("Se modificó usuario Telegram a: " + nuevoUsuarioTelegram);
        }

        collection.updateOne(filtro, new Document("$set", update));

        cargarContactos();
    }
}
