package moding.ingeniero.controller;

import moding.ingeniero.modelo.Cultivo;
import moding.ingeniero.repositorio.ConexionCultivo;
import moding.ingeniero.repositorio.MongoDataBaseConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultivoController {
	
	MongoDataBaseConnection mongoDB; 
   
    //ConexionSector conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
    //ConexionInnovacion conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
    //ConexionIngeniero conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());
    //ConexionContacto conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
	

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

}
