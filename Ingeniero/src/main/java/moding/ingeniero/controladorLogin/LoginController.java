package moding.ingeniero.controladorLogin;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("username agarrado: " + username + " password agarrado: " + password);
        for(Ingeniero ingenieros1: ingenieroRepository.findAll()){
            System.out.println("nombre: "+ingenieros1.getNombre()+"  correo " + ingenieros1.getCorreo() + " y contrasena: "+ingenieros1.getPassword());

            if(username.equals(ingenieros1.getCorreo()) && password.equals(ingenieros1.getPassword())){
                System.out.println("login exitoso con el correo: " + ingenieros1.getCorreo() );
                return "login exitoso";
            }
        }
        System.out.println("login no exitoso");
        return "login no exitoso";
    }

    @RequestMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("nuevoIngeniero", new Ingeniero());
        return "registro";
    }

    @PostMapping("/registro")
    @ResponseBody
    public Ingeniero guardarIngeniero(@RequestParam String email,@RequestParam String name, @RequestParam String password) {
        Ingeniero newInge = new Ingeniero(email, password, name);
        ingenieroRepository.save(newInge);
        System.out.println("Se guardó el ingeniero: " + newInge);
        return newInge;
    }

    @RequestMapping("/volver")
    public String volver() {
        return "inicio";
    }
}
