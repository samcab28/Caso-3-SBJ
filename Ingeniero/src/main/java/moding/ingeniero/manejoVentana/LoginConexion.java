package moding.ingeniero.manejoVentana;

import moding.ingeniero.controller.IngenieroController;
import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorioConexion.ConexionIngeniero;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginConexion {

    private final IngenieroController ingenieroController;
    MongoDataBaseConnection mongoDB;
    private ConexionIngeniero conexionIngeniero;
    private boolean resultadoLoginExitoso = false;
    @Autowired
    public LoginConexion(IngenieroController ingenieroController) {
        this.ingenieroController = ingenieroController;
    }


    //funcion para hacer el registro
    @GetMapping("/registro")
    public String GuardarInge() {
        return "registro";
    }

    @GetMapping("/volver")
    public String volverLogin(){
        return "inicio";
    }


    @GetMapping("/")
    public String ShowInicioForm(){
        return "inicio";
    }

    @GetMapping("/volverMenu")
    public String volverLoginMenu() {
        return "menuPrincipal";
    }

    @PostMapping("/loginIngeniero")
    public String loginIngeniero(@RequestBody Ingeniero ingeniero) {
        // Obtener la instancia de la conexión a la base de datos (mongoDB y conexionIngeniero)
        mongoDB = MongoDataBaseConnection.getInstance();
        conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());

        try {
            // Lógica de autenticación
            resultadoLoginExitoso = conexionIngeniero.loginIngeniero(ingeniero.getPasswordIngeniero(), ingeniero.getCorreoIngeniero());

            if (resultadoLoginExitoso) {
                System.out.println("login ok");
                return "menuPrincipal";
            } else {
                System.out.println("login error");
                return "inicio";
            }
        } catch (Exception e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
            return "inicio";
        }
    }



}