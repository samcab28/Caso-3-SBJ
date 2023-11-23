package moding.ingeniero.controller;

import moding.ingeniero.controller.modificacionRequest.ModificacionSectorRequest;
import moding.ingeniero.modelo.sector.Sector;
import moding.ingeniero.repositorioConexion.ConexionSector;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectorController {

    MongoDataBaseConnection mongoDB;
    private ConexionSector conexionSector;

    @PostMapping("/agregarSector")
    public ResponseEntity<String> agregarSector(@RequestBody Sector sector){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
        try{
            conexionSector.agregarSector(sector);
            System.out.println("nuevo sector agregado de nombre: " + sector.getNombre());
            return ResponseEntity.ok("Cultivo agregado exitosamente");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el el sector");
        }

    }



    @PostMapping("/eliminarSector")
    public ResponseEntity<String> eliminarSector(@RequestBody Sector sector){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
        try{
            conexionSector.eliminarSector(sector.getNombre());
            System.out.println("sector eliminado de nombre: " + sector.getNombre());
            return ResponseEntity.ok("Sector eliminado exitosamente");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el el sector");
        }
    }
    
    @PostMapping("/modificarSector")
    public ResponseEntity<String> modificarSector(@RequestBody ModificacionSectorRequest request) {
    	
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
        try {
        	conexionSector.modificarSector(request.getNombre(), request.getNuevoNombre(), request.getNuevaLluviaMediaAnual(),
                request.getNuevaLluviaMediaAnual(), request.getNuevoPromedioLluvias(), request.getNuevaDuracionPeriodoSeco());
        		
            	System.out.println("Se ha modificado el sector: " + request.getNombre());
            return ResponseEntity.ok("Sector modificado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el sector");
        }
    }
}
