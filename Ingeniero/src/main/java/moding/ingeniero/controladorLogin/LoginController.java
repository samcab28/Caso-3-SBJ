package moding.ingeniero.controladorLogin;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

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

    @PostMapping("/")
    @ResponseBody
    public String procesarLogin(@RequestParam String username, @RequestParam String password) {
        List<Ingeniero> ingenieros = ingenieroRepository.findByCorreoAndPassword(username, password);
        for(Ingeniero ingenieros1: ingenieroRepository.findAll()){
            System.out.println("nombre: "+ingenieros1.getNombre()+"  correo " + ingenieros1.getCorreo() + " y contrasena: "+ingenieros1.getPassword());

            if(username == ingenieros1.getCorreo() & password == ingenieros1.getPassword()){
                System.out.println("login exitoso con el correo: " + ingenieros1.getCorreo() );
                return "login exitoso";
            }
        }
        System.out.println("login no exitoso");
        return "login exitoso";
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
