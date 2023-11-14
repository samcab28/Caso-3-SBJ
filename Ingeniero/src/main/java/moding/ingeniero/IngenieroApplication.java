package moding.ingeniero;

import moding.ingeniero.modelo.*;
import moding.ingeniero.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@SpringBootApplication
public class IngenieroApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    private final ContactoRepository contactoRepository;

    private final SectorRepository sectorRepository;

    private final CultivoRepository cultivoRepository;

    private final ZonaRepository zonaRepository;

    private final IngenieroRepository ingenieroRepository;

    @Autowired
    public IngenieroApplication(UserRepository userRepository, ContactoRepository contactoRepository, SectorRepository sectorRepository, CultivoRepository cultivoRepository, ZonaRepository zonaRepository, IngenieroRepository ingenieroRepository) {
        this.userRepository = userRepository;
        this.contactoRepository = contactoRepository;
        this.sectorRepository = sectorRepository;
        this.cultivoRepository = cultivoRepository;
        this.zonaRepository = zonaRepository;
        this.ingenieroRepository = ingenieroRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        contactoRepository.save(new Contacto("Juan", "Pérez", "12345678", "juan@gmail.com", "@juan_telegram"));
        contactoRepository.save(new Contacto("María", "López", "23456789", "maria@gmail.com", "@maria_telegram"));
        contactoRepository.save(new Contacto("Ana", "Gómez", "34567890", "ana@gmail.com", "@ana_telegram"));
        contactoRepository.save(new Contacto("Carlos", "Rodríguez", "45678901", "carlos@gmail.com", "@carlos_telegram"));
        contactoRepository.save(new Contacto("Laura", "Fernández", "56789012", "laura@gmail.com", "@laura_telegram"));

        // Contacto 6-10
        contactoRepository.save(new Contacto("Pedro", "Martínez", "67890123", "pedro@gmail.com", "@pedro_telegram"));
        contactoRepository.save(new Contacto("Isabel", "Hernández", "78901234", "isabel@gmail.com", "@isabel_telegram"));
        contactoRepository.save(new Contacto("Miguel", "González", "89012345", "miguel@gmail.com", "@miguel_telegram"));
        contactoRepository.save(new Contacto("Sofía", "Díaz", "90123456", "sofia@gmail.com", "@sofia_telegram"));
        contactoRepository.save(new Contacto("Antonio", "Suárez", "01234567", "antonio@gmail.com", "@antonio_telegram"));

        // Contacto 11-15
        contactoRepository.save(new Contacto("Elena", "Ramírez", "98765432", "elena@gmail.com", "@elena_telegram"));
        contactoRepository.save(new Contacto("Javier", "Pérez", "87654321", "javier@gmail.com", "@javier_telegram"));
        contactoRepository.save(new Contacto("Carmen", "Gutiérrez", "76543210", "carmen@gmail.com", "@carmen_telegram"));
        contactoRepository.save(new Contacto("Hugo", "Ortega", "65432109", "hugo@gmail.com", "@hugo_telegram"));
        contactoRepository.save(new Contacto("Luisa", "Morales", "54321098", "luisa@gmail.com", "@luisa_telegram"));

        // Contacto 16-20
        contactoRepository.save(new Contacto("Fernando", "García", "43210987", "fernando@gmail.com", "@fernando_telegram"));
        contactoRepository.save(new Contacto("Beatriz", "Mendoza", "32109876", "beatriz@gmail.com", "@beatriz_telegram"));
        contactoRepository.save(new Contacto("Diego", "Cruz", "21098765", "diego@gmail.com", "@diego_telegram"));
        contactoRepository.save(new Contacto("Lucía", "Silva", "10987654", "lucia@gmail.com", "@lucia_telegram"));
        contactoRepository.save(new Contacto("Ricardo", "Reyes", "09876543", "ricardo@gmail.com", "@ricardo_telegram"));

    }


}
