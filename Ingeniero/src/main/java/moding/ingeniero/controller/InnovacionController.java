package moding.ingeniero.controller;

import moding.ingeniero.controller.modificacionRequest.ModificacionInnovacionRequest;
import moding.ingeniero.modelo.Innovacion;
import moding.ingeniero.repositorioConexion.ConexionInnovacion;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InnovacionController {

    MongoDataBaseConnection mongoDB;

    private ConexionInnovacion conexionInnovacion;

    @PostMapping("/agregarInnovacion")
    public ResponseEntity<String> agregarInnovacion(@RequestBody Innovacion innovacion){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
        try{
            conexionInnovacion.agregarInnovacion(innovacion);
            System.out.println("agregado de innovacion de nombre: " + innovacion.getNombreInnovacion());
            return ResponseEntity.ok("Innovacion agregada exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la innovacion");
        }
    }

    @PostMapping("/eliminarInnovacion")
    public ResponseEntity<String> eliminarInnovacion(@RequestBody Innovacion innovacion){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
        try{
            conexionInnovacion.eliminarInnovacion(innovacion.getNombreInnovacion());
            System.out.println("borrado de innovacion de nombre: " + innovacion.getNombreInnovacion());
            return ResponseEntity.ok("Innovacion eliminada exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la innovacion");
        }
    }

    @PostMapping("/modificarInnovacion")
    public ResponseEntity<String> modificarInnovacion(@RequestBody ModificacionInnovacionRequest request){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
        try{
            conexionInnovacion.modificarInnovacion(request.getNombreInnovacion(), request.getNuevoNombreInnovacion(), request.getNuevoLinkPaginaInnovacion(), request.getNuevaDescripcionInnovacion(), request.getNuevoCostoInnovacion());
            System.out.println("se ha modificado la innovacion de nombre: " + request.getNuevoNombreInnovacion());
            return ResponseEntity.ok("Innovacion modificada exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la innovacion");
        }
    }
}
