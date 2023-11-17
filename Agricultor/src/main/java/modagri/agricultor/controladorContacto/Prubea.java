package modagri.agricultor.controladorContacto;

import modagri.agricultor.modelo.Contacto;
import modagri.agricultor.repositorio.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Prubea {


    @GetMapping("/pagina15")
    public String pagina15(Model model) {
        return "pagina15";
    }
}
