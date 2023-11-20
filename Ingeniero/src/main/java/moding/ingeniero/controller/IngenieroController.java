package moding.ingeniero.controller;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.ConexionIngeniero;
import moding.ingeniero.repositorio.MongoDataBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Service
@RestController
public class IngenieroController {


    MongoDataBaseConnection mongoDB;
    private ConexionIngeniero conexionIngeniero;


/*
    public boolean agregarIngeniero(Ingeniero ingeniero) {
        // Verifica si ya existe un ingeniero con el mismo correo
        if (conexionIngeniero.getIngeniero(ingeniero.getCorreoIngeniero()) != null) {
            System.out.println("El ingeniero ya existe con el correo: " + ingeniero.getCorreoIngeniero());
            return false; // No se agrega el ingeniero
        } else {
            conexionIngeniero.agregarIngeniero(ingeniero);
            System.out.println("Ingeniero agregado con éxito");
            return true; // Ingeniero agregado con éxito
        }
    }*/

    public boolean comprobarIngeniero(String correo, String password) {
        Ingeniero ingenieroVerificar = conexionIngeniero.getIngeniero(correo);

        if (ingenieroVerificar != null && password.equals(ingenieroVerificar.getPasswordIngeniero())) {
            System.out.println("Login exitoso con el correo: " + ingenieroVerificar.getCorreoIngeniero());
            return true;
        } else {
            System.out.println("Login no exitoso");
            return false;
        }
    }

    @PostMapping("/agregarIngeniero")
    public ResponseEntity<Map<String, String>> agregarIngenieroHTML(@RequestBody Ingeniero ingeniero){
        mongoDB = MongoDataBaseConnection.getInstance();
        System.out.println("Ingreso al controlador de ingeniero: " + ingeniero.getNombreIngeniero());
        conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());
        try {
            conexionIngeniero.agregarIngeniero(ingeniero);
            System.out.println("Ingeniero agregado con éxito: " + ingeniero.getNombreIngeniero());
            System.out.println("correo: " + ingeniero.getCorreoIngeniero());
            System.out.println("contra: " + ingeniero.getPasswordIngeniero());

            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("mensaje", "Ingeniero agregado exitosamente");

            return ResponseEntity.ok(responseMap);
        } catch(Exception e) {
            e.printStackTrace();
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("mensaje", "Error al agregar el ingeniero");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }




    @PostMapping("/eliminarIngeniero")
    public ResponseEntity<String> eliminarIngenieroHTML(@RequestBody Ingeniero ingeniero){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());
        try{
            String ingenieroEliminar = ingeniero.getCorreoIngeniero();
            conexionIngeniero.eliminarIngeniero(ingenieroEliminar);
            System.out.println("borrado de ingeniero de correo: " + ingeniero.getCorreoIngeniero());
            return ResponseEntity.ok("Ingeniero borrado exitosamente");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el ingeniero");
        }
    }
}
