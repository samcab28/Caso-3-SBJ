package modagri.agricultor.conexion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServletHTML {

    @GetMapping("/sendStr")
    @ResponseBody
    public String manejarSolicitud(@RequestParam(name = "mensaje", required = false) String mensaje) {
        System.out.println("Texto recibido desde HTML: " + mensaje);
        return "Hola, esta es la respuesta desde el servidor Java (Spring Boot)";
    }
}
