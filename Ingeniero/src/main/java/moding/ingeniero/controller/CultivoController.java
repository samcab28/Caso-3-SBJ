package moding.ingeniero.controller;

import moding.ingeniero.controller.modificacionRequest.ModificacionCultivoRequest;
import moding.ingeniero.modelo.Cultivo;
import moding.ingeniero.repositorioConexion.ConexionCultivo;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultivoController {
	
	MongoDataBaseConnection mongoDB; 

    private ConexionCultivo conexionCultivo;

    @PostMapping("/agregarCultivo")
    public ResponseEntity<String> agregarCultivo(@RequestBody Cultivo cultivo) {
    	mongoDB = MongoDataBaseConnection.getInstance();
    	conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
        try {
            conexionCultivo.agregarCultivo(cultivo);
            System.out.println("Se ha agregado: " + cultivo.getNombre());
            return ResponseEntity.ok("Cultivo agregado exitosamente");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el cultivo");
        }
    }
    
    @PostMapping("/eliminarCultivo")
    public ResponseEntity<String> eliminarCultivo(@RequestBody Cultivo cultivo) {
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
        try {
            String nombreCultivo = cultivo.getNombre();
            conexionCultivo.eliminarCultivo(nombreCultivo);
            System.out.println("Se ha eliminado: " + nombreCultivo);
            return ResponseEntity.ok("Cultivo eliminado exitosamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el cultivo");
        }
    }
    
    @PostMapping("/modificarCultivo")
    public ResponseEntity<String> modificarCultivo(@RequestBody ModificacionCultivoRequest request) {
        
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());

        try {
            // Aquí deberías tener un método en tu conexión a la base de datos que maneje la modificación
            // Puedes ajustar este método según la estructura de tu aplicación
            conexionCultivo.modificarCultivo(request.getNombre(), request.getNuevoNombre(), request.getNuevaTempMinima(),
                request.getNuevaTempMaxima(), request.getNuevaCantidadAgua(), request.getNuevaDiasMinCosecha(),
                request.getNuevaDiasMaxCosecha(), request.getNuevoPrecioUnidad(), request.getNuevaCantidadPorMetro2());

            System.out.println("Se ha modificado el cultivo: " + request.getNombre());
            return ResponseEntity.ok("Cultivo modificado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el cultivo");
        }
    }
}
