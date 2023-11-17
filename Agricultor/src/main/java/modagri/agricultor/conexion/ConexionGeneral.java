package modagri.agricultor.conexion;

import modagri.agricultor.almacenamiento.Innovacion;
import modagri.agricultor.dataBase.ConexionInnovacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import modagri.agricultor.almacenamiento.Cultivo;
import modagri.agricultor.almacenamiento.Sector;
import modagri.agricultor.dataBase.ConexionCultivo;
import modagri.agricultor.dataBase.ConexionSector;
import modagri.agricultor.dataBase.MongoDataBaseConnection;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;


@Controller
public class ConexionGeneral {

    MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
    private final Random random = new Random();

    @GetMapping("/")
    public String paginaInicio(Model model) {
        ConexionInnovacion conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());
        Vector<Innovacion> innovacionesAleatorias = conexionInnovacion.getInnovaciones();
        List<Innovacion> innovaciones = shuffleList(innovacionesAleatorias.stream().limit(4).collect(Collectors.toList()));
        model.addAttribute("innovaciones", innovaciones);
        return "inicio";
    }

    private <T> List<T> shuffleList(List<T> list) {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed + random.nextInt()));
        return list;
    }

    @GetMapping("/calculo")
    public String paginaCalculo(Model model){
        ConexionCultivo conexionCultivo = ConexionCultivo.getInstance(mongoDB.getDatabase());
        ConexionSector conexionSector = ConexionSector.getInstance(mongoDB.getDatabase());
        ConexionInnovacion conexionInnovacion = ConexionInnovacion.getInstance(mongoDB.getDatabase());

        Vector<Sector> sectores = conexionSector.getSectores();
        Vector<Cultivo> cultivos = conexionCultivo.getCultivos();
        Vector<Innovacion> innovaciones = conexionInnovacion.getInnovaciones();

        model.addAttribute("cultivos",cultivos);
        model.addAttribute("sectores",sectores);
        model.addAttribute("innovaciones",innovaciones);

        return "calculo";
    }

    @GetMapping("/resultado")
    public String paginaResultado(Model model){
        return "resultado";
    }


    @GetMapping("/contacto")
    public String paginaContacto(){
        return "contacto";
    }

    @GetMapping("/volverMenu")
    public String volver() {
        return "redirect:/";
    }

}
