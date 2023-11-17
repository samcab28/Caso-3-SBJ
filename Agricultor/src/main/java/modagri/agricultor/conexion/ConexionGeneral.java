package modagri.agricultor.conexion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConexionGeneral {

    @GetMapping("/")
    public String paginaInicio(){
        return "inicio";
    }



    @GetMapping("/calculo")
    public String paginaCalculo(){
        return "calculo";
    }

    @GetMapping("/resultado")
    public String paginaResultado(){
        return "resultado";
    }


    @GetMapping("/contacto")
    public String paginaContacto(){
        return "contacto";
    }

    @GetMapping("/volverMenu")
    public String volver() {
        return "inicio";
    }

}
