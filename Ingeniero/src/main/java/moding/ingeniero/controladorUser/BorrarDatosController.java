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

import java.util.List;

@Controller
public class BorrarDatosController {

    private final UserRepository userRepository;

    @Autowired
    public BorrarDatosController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/borrarUsuario")
    @ResponseBody
    public String borrarUsuario(@RequestBody User user) {
        List<User> usersToDelete = userRepository.findAllByFirstNameAndLastName(user.getFirstName(), user.getLastName());

        if (!usersToDelete.isEmpty()) {
            userRepository.deleteAll(usersToDelete);
            System.out.println("Usuarios borrados: " + usersToDelete);
            return "Usuarios borrados correctamente";
        } else {
            System.out.println("No se encontraron usuarios para borrar.");
            return "No se encontraron usuarios para borrar.";
        }
    }


    @RequestMapping("/borrar")
    public String mostrarPagina(Model model) {
        // Puedes agregar atributos al modelo si es necesario
        return "login3"; // Devuelve el nombre del archivo HTML sin la extensión
    }
}
