package moding.ingeniero.controller;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.ConexionIngeniero;
import moding.ingeniero.repositorio.MongoDataBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngenieroController {


    MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
    ConexionIngeniero conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());


    public boolean agregarIngeniero(Ingeniero ingeniero) {
        // Verifica si ya existe un ingeniero con el mismo correo
        if (conexionIngeniero.getIngeniero(ingeniero.getCorreo()) != null) {
            System.out.println("El ingeniero ya existe con el correo: " + ingeniero.getCorreo());
            return false; // No se agrega el ingeniero
        } else {
            conexionIngeniero.agregarIngeniero(ingeniero);
            System.out.println("Ingeniero agregado con éxito");
            return true; // Ingeniero agregado con éxito
        }
    }

    public boolean comprobarIngeniero(String correo, String password) {
        Ingeniero ingenieroVerificar = conexionIngeniero.getIngeniero(correo);

        if (ingenieroVerificar != null && password.equals(ingenieroVerificar.getPassword())) {
            System.out.println("Login exitoso con el correo: " + ingenieroVerificar.getCorreo());
            return true;
        } else {
            System.out.println("Login no exitoso");
            return false;
        }
    }
}
