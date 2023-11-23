package moding.ingeniero.controller;


import moding.ingeniero.controller.modificacionRequest.ModificacionContactoRequest;
import moding.ingeniero.modelo.contacto.Contacto;
import moding.ingeniero.repositorioConexion.ConexionContacto;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
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

    @PostMapping("/modificarContacto")
    public ResponseEntity<String> agregarContacto(@RequestBody ModificacionContactoRequest request){
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
        try{
            conexionContacto.modificarContacto(request.getCorreoContacto(), request.getNuevoNombre(), request.getNuevoApellido(), request.getNuevoTelefono(), request.getCorreoContacto(), request.getNuevoUsuarioTelegram());
            System.out.println("se ha modificado el contacto de correo: " + request.getCorreoContacto());
            return ResponseEntity.ok("Contacto modificado exitosamente");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el Contacto");
        }
    }
}
