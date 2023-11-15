package moding.ingeniero.conexion;


import moding.ingeniero.controller.InformacionController;
import moding.ingeniero.modelo.Ingeniero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnvioInfoConexion {

    private final InformacionController informacionController;

    @Autowired
    public EnvioInfoConexion(InformacionController informacionController) {
        this.informacionController = informacionController;
    }

    //funcion para el envio de informacion
    @GetMapping("/envioInformacion")
    public String envioInformacion(){
        return "envioInfo";
    }

    @PostMapping(path = "/envioInformacion", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> envioInformacion(@RequestParam String asunto, @RequestParam String mensaje) {
        informacionController.cargaDatosEnvioInformacion(asunto, mensaje);
        return ResponseEntity.status(HttpStatus.OK).body("Mensaje enviado correctamente");
    }



    @GetMapping("/volverEnvioInformacion")
    public String volverLogin(){
        return "inicio";
    }
}
