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
        MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();

        ConexionCultivo conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
        ConexionSector conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());

        Vector<Sector> sectores = conexionSector.getSectores();
        Vector<Cultivo> cultivos = conexionCultivo.getCultivos();

        for (Cultivo cultivo : cultivos) {
            System.out.println(cultivo.getNombre() + " : " + cultivo.getPrecioUnidad() + " se siembra: " + cultivo.getCantidadPorMetro2() + " por m2");
        }

        for (Sector sector : sectores) {
            System.out.println(sector.getNombre() + " : " + sector.getTemperaturaMedia());
        }
    }
}