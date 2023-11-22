package moding.ingeniero.manejoVentana;

import moding.ingeniero.controller.InformacionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class EnvioInfoConexion {

    private final InformacionController informacionController;

    @Autowired
    public EnvioInfoConexion(InformacionController informacionController) {
        this.informacionController = informacionController;
    }

    @GetMapping("/envioInformacionForm")  // Cambiando la URL para evitar ambigüedad
    public String envioInformacionForm() {
        return "envioInfo";
    }

    @PostMapping(path = "/envioInformacion", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> envioInformacion(@RequestParam String asunto, @RequestParam String mensaje) {
        informacionController.cargaDatosEnvioInformacion(asunto, mensaje);
        return ResponseEntity.status(HttpStatus.OK).body("Mensaje enviado correctamente");
    }

    @GetMapping("/volverEnvioInformacion")
    public String volverLogin() {
        return "inicio";
    }
}
