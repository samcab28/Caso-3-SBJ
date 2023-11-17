package moding.ingeniero;

import moding.ingeniero.modelo.*;
import moding.ingeniero.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class IngenieroApplication implements CommandLineRunner {

    private final ContactoRepository contactoRepository;

    private final SectorRepository sectorRepository;

    private final CultivoRepository cultivoRepository;

    private final ZonaRepository zonaRepository;

    private final IngenieroRepository ingenieroRepository;

    private final InnovacionRepository innovacionRepository;

    @Autowired
    public IngenieroApplication(ContactoRepository contactoRepository, SectorRepository sectorRepository, CultivoRepository cultivoRepository, ZonaRepository zonaRepository, IngenieroRepository ingenieroRepository, InnovacionRepository innovacionRepository) {
        this.contactoRepository = contactoRepository;
        this.sectorRepository = sectorRepository;
        this.cultivoRepository = cultivoRepository;
        this.zonaRepository = zonaRepository;
        this.ingenieroRepository = ingenieroRepository;
        this.innovacionRepository = innovacionRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }

}
