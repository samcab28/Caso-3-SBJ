package modagri.agricultor.conexion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Navegacion {
	
    @GetMapping("/pagina15")
    public String pagina15(Model model) {
        return "pagina15";
    }
    
    @GetMapping("/pagina14")
    public String pagina14(Model model) {
        return "pagina14";
    }
    
    @GetMapping("/test")
	public String test(Model model) {
	    return "test";
	}
    
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}
