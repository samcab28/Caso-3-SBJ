package moding.ingeniero.manejoVentana;

import moding.ingeniero.modelo.contacto.Contacto;
import moding.ingeniero.modelo.cultivo.Cultivo;
import moding.ingeniero.modelo.ingeniero.Ingeniero;
import moding.ingeniero.modelo.innovacion.Innovacion;
import moding.ingeniero.modelo.sector.Sector;
import moding.ingeniero.repositorioConexion.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Vector;

@Controller
@RequestMapping("/menu")
public class MenuConexion {

    MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
    ConexionCultivo conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
    ConexionSector conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
    ConexionInnovacion conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
    ConexionIngeniero conexionIngeniero = ConexionIngeniero.getInstance(mongoDB.getDatabase());
    ConexionContacto conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
    
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
        Vector<Contacto> contactos = conexionContacto.getContactos();
        model.addAttribute("contactos", contactos);
        return "menuContacto";
    }

    @GetMapping("/pagina4")
    public String pagina4(Model model) {
        Vector<Ingeniero> ingenieros = conexionIngeniero.getIngenieros();
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
