package modagri.agricultor;

import modagri.agricultor.almacenamiento.Cultivo;
import modagri.agricultor.almacenamiento.Sector;
import modagri.agricultor.dataBase.ConexionCultivo;
import modagri.agricultor.dataBase.ConexionSector;
import modagri.agricultor.dataBase.MongoDataBaseConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.util.Vector;

@SpringBootApplication
@Controller
public class AgricultorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AgricultorApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}