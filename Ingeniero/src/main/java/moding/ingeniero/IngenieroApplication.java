package moding.ingeniero;

import moding.ingeniero.modelo.Contacto;
import moding.ingeniero.modelo.User;
import moding.ingeniero.repositorio.ContactoRepository;
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

    private final ContactoRepository contactoRepository;

    @Autowired
    public IngenieroApplication(UserRepository userRepository, ContactoRepository contactoRepository) {
        this.userRepository = userRepository;
        this.contactoRepository = contactoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (contactoRepository.findAll().isEmpty()) {
            Contacto newContacto = new Contacto("Samir","Cabrera","7122-3417","samircabrera2528@gmail.com","samcab28");
            contactoRepository.save(newContacto);
            System.out.println("nuevo contacto guardado: " + contactoRepository);
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
