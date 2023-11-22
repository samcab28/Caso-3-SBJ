package moding.ingeniero.controller;

import moding.ingeniero.controller.modificacionRequest.ModificacionIngenieroRequest;
import moding.ingeniero.controller.modificacionRequest.ModificacionSectorRequest;
import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorioConexion.ConexionIngeniero;
import moding.ingeniero.repositorioConexion.ConexionSector;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/modificarIngeniero")
    public ResponseEntity<String> modificarIngeniero(@RequestBody ModificacionIngenieroRequest request) {

        mongoDB = MongoDataBaseConnection.getInstance();
        conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());

        try{
            conexionIngeniero.modificarIngeniero(request.getCorreoIngeniero(), request.getNuevoCorreoIngeniero(),request.getNuevoPasswordIngeniero(),request.getNuevoNombreIngeniero());

            System.out.println("se ha modificado el ingeniero de correo: " +request.getCorreoIngeniero());
            return ResponseEntity.ok("Ingeniero modificado exitosamente");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el Ingeniero");
        }
    }
}