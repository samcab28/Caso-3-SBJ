package moding.ingeniero.conexion;

import moding.ingeniero.modelo.*;
import moding.ingeniero.repositorio.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/menu")
public class MenuConexion {

    private final CultivoRepository cultivoRepository;
    private final SectorRepository sectorRepository;
    private final ContactoRepository contactoRepository;
    private final IngenieroRepository ingenieroRepository;
    private final InnovacionRepository innovacionRepository;

    MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
    ConexionCultivo conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
    ConexionSector conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
    ConexionInnovacion conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());

    public MenuConexion(CultivoRepository cultivoRepository, SectorRepository sectorRepository, ContactoRepository contactoRepository, IngenieroRepository ingenieroRepository, InnovacionRepository innovacionRepository) {
        this.cultivoRepository = cultivoRepository;
        this.sectorRepository = sectorRepository;
        this.contactoRepository = contactoRepository;
        this.ingenieroRepository = ingenieroRepository;
        this.innovacionRepository = innovacionRepository;
    }

    @GetMapping("/pagina1")
    public String pagina1(Model model) {
        Vector<Cultivo> cultivos = conexionCultivo.getCultivos();
        model.addAttribute("cultivos",cultivos);
        return "menuCultivo";
    }

    @GetMapping("/pagina2")
    public String pagina2(Model model) {
        Vector<Sector> sectores = conexionSector.getSectores();
        model.addAttribute("sectores", sectores);
        return "menuSector";
    }

    @GetMapping("/pagina3")
    public String pagina3(Model model) {
        List<Contacto> contactos = contactoRepository.findAll();
        model.addAttribute("contactos", contactos);
        return "menuContacto";
    }

    @GetMapping("/pagina4")
    public String pagina4(Model model) {
        List<Ingeniero> ingenieros = ingenieroRepository.findAll();
        model.addAttribute("ingenieros", ingenieros);
        return "menuIngeniero";
    }

    @GetMapping("/pagina5")
    public String pagina5(Model model) {
        Vector<Innovacion> innovaciones = conexionInnovacion.getInnovaciones();
        model.addAttribute("innovaciones", innovaciones);
        return "menuInnovacion";
    }

    @GetMapping("/pagina6")
    public String pagina6() {
        return "envioInfo";
    }

    @GetMapping("/volver")
    public String volver() {
        return "inicio";
    }




}
