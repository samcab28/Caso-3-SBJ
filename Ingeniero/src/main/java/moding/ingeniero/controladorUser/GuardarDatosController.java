package moding.ingeniero.controladorUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import moding.ingeniero.modelo.User;
import moding.ingeniero.repositorio.UserRepository;

@Controller
public class GuardarDatosController {

    private final UserRepository userRepository;

    @Autowired
    public GuardarDatosController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/guardarUsuario")
    @ResponseBody
    public User guardarUsuario(@RequestBody User user) {
        User newUser = userRepository.save(user);
        System.out.println("Nuevo usuario guardado: " + newUser);
        return newUser;
    }

    @RequestMapping("/guardar")
    public String mostrarPagina(Model model) {
        // Puedes agregar atributos al modelo si es necesario
        return "login2"; // Devuelve el nombre del archivo HTML sin la extensión
    }
}
