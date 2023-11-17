package moding.ingeniero.conexion;

import moding.ingeniero.modelo.*;
import moding.ingeniero.repositorio.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuConexion {

    private final CultivoRepository cultivoRepository;
    private final SectorRepository sectorRepository;
    private final ContactoRepository contactoRepository;
    private final IngenieroRepository ingenieroRepository;
    private final InnovacionRepository innovacionRepository;

    public MenuConexion(CultivoRepository cultivoRepository, SectorRepository sectorRepository, ContactoRepository contactoRepository, IngenieroRepository ingenieroRepository, InnovacionRepository innovacionRepository) {
        this.cultivoRepository = cultivoRepository;
        this.sectorRepository = sectorRepository;
        this.contactoRepository = contactoRepository;
        this.ingenieroRepository = ingenieroRepository;
        this.innovacionRepository = innovacionRepository;
    }

    @GetMapping("/pagina1")
    public String pagina1(Model model) {
        List<Cultivo> cultivos = cultivoRepository.findAll();
        model.addAttribute("cultivos", cultivos);
        return "menuCultivo";
    }

    @GetMapping("/pagina2")
    public String pagina2(Model model) {
        List<Sector> sectores = sectorRepository.findAll();
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
        List<Innovacion> innovaciones = innovacionRepository.findAll();
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



    //puebas de agricultores por ahora

    @GetMapping("/pagina11")
    public String pagina11(Model model) {
        List<Innovacion> innovaciones = innovacionRepository.findAll();
        model.addAttribute("innovaciones", innovaciones);
        return "pagina11";
    }

    @GetMapping("/pagina12")
    public String pagina12(Model model) {
        List<Cultivo> cultivos = cultivoRepository.findAll();
        List<Sector> sectores = sectorRepository.findAll();
        List<Innovacion> innovaciones = innovacionRepository.findAll();

        model.addAttribute("cultivos", cultivos);
        model.addAttribute("sectores", sectores);
        model.addAttribute("innovaciones", innovaciones);

        return "pagina12";
    }

    @GetMapping("/pagina13")
    public String pagina13(Model model) {
        return "pagina13";
    }

    @GetMapping("/pagina14")
    public String pagina14(Model model) {
        return "pagina14";
    }
}
