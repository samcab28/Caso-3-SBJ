package moding.ingeniero.controller;

import moding.ingeniero.modelo.Sector;
import moding.ingeniero.repositorio.ConexionSector;
import moding.ingeniero.repositorio.MongoDataBaseConnection;
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
}
