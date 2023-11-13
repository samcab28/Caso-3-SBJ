package moding.ingeniero.controladorLogin;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    private final IngenieroRepository ingenieroRepository;

    @Autowired
    public LoginController(IngenieroRepository ingenieroRepository){
        this.ingenieroRepository = ingenieroRepository;
    }

    @RequestMapping("/")
    public String inicio(Model model){
        return "inicio";
    }

    @RequestMapping("/registro")
    public String registro(Model model) {
        // Agrega un nuevo objeto Ingeniero al modelo para ser utilizado en el formulario de registro
        model.addAttribute("nuevoIngeniero", new Ingeniero());
        return "registro";
    }

    @PostMapping("/registro")
    @ResponseBody
    public Ingeniero guardarIngeniero(@ModelAttribute Ingeniero nuevoIngeniero) {
        Ingeniero newIngeniero = ingenieroRepository.save(nuevoIngeniero);
        System.out.println("Se guardó el ingeniero: " + newIngeniero);
        return newIngeniero;
    }
}

