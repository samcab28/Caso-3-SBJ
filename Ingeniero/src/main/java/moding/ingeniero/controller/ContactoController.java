package moding.ingeniero.controller;


import moding.ingeniero.modelo.Contacto;
import moding.ingeniero.modelo.Cultivo;
import moding.ingeniero.repositorio.ConexionContacto;
import moding.ingeniero.repositorio.MongoDataBaseConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactoController {

    MongoDataBaseConnection mongoDB;

    private ConexionContacto conexionContacto;

    @PostMapping("/agregarContacto")
    public ResponseEntity<String> agregarContacto(@RequestBody Contacto contacto){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
        try{
            conexionContacto.agregarContacto(contacto);
            System.out.println("contacto agregado: " + contacto.getNombreContacto());
            return ResponseEntity.ok("Contacto agregado exitosamente");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el Contacto");
        }
    }

    @PostMapping("/eliminarContacto")
    public ResponseEntity<String> eliminarCultivo(@RequestBody Contacto contacto){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
        try{
            conexionContacto.eliminarContacto(contacto.getNombreContacto());
            System.out.println("se elimino el contacto: " + contacto.getNombreContacto());
            return ResponseEntity.ok("Contacto eliminado exitosamente");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el Contacto");
        }
    }
}
