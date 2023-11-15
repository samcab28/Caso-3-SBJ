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


    }


}
