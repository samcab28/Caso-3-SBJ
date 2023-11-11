package moding.ingeniero;

import moding.ingeniero.modelo.User;
import moding.ingeniero.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class IngenieroApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public IngenieroApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User newUser = new User("ben", "Farz");
            userRepository.save(newUser);
            System.out.println("New user saved: " + newUser);
        }

        System.out.println("All users in the database:");
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
    }

    @RequestMapping("/")
    public String mostrarPagina(Model model) {
        // Puedes agregar atributos al modelo si es necesario
        return "index"; // Devuelve el nombre del archivo HTML sin la extensión
    }
}
