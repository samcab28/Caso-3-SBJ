package moding.ingeniero.conexion;

import moding.ingeniero.controller.InformacionController;
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
        // Obtener los cultivos de la base de datos
        List<Cultivo> cultivos = cultivoRepository.findAll();

        // Agregar los cultivos al modelo
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


}

