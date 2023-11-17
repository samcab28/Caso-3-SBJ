package moding.ingeniero.conexion;

import moding.ingeniero.controller.IngenieroController;
import moding.ingeniero.modelo.Ingeniero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginConexion {

    private final IngenieroController ingenieroController;

    @Autowired
    public LoginConexion(IngenieroController ingenieroController) {
        this.ingenieroController = ingenieroController;
    }


    //funcion para hacer el registro
    @GetMapping("/registro")
    public String GuardarInge() {
        return "registro"; // Esto asume que tu página HTML se llama login2.html y está en la carpeta templates o static
    }

    @PostMapping(path = "/registro", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> create(@ModelAttribute Ingeniero ingeniero){
        System.out.println("Recibido: " + ingeniero.getNombre());
        ingenieroController.agregarIngeniero(ingeniero);
        return new ResponseEntity<>("Feliz de crear el producto: " + ingeniero.getNombre(), HttpStatus.CREATED);
    }

    @GetMapping("/volver")
    public String volverLogin(){
        return "inicio";
    }



    //funcion para hacer el login
    @GetMapping("/")
    public String ShowInicioForm(){
        return "inicio";
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String handleLogin(@RequestParam String username, @RequestParam String password){
        if(ingenieroController.comprobarIngeniero(username,password)){
            return "menuPrincipal";
        }
        return "inicio";
    }


    @GetMapping("/volverMenu")
    public String volverLoginMenu() {
        return "menuPrincipal"; // Redirige a la página de inicio
    }

    /*
    @GetMapping("/{phrase}")
    public ResponseEntity<String> searchPhrase(@PathVariable("phrase") String pInputPhrase){
        ResponseEntity<String> result = new ResponseEntity<String>("Enviaste esta frase: " + pInputPhrase, HttpStatus.ACCEPTED);
        return result;
    }*/
}
