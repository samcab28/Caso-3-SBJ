package moding.ingeniero.controladorLogin;

import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GuardarRegistro {

    private final IngenieroRepository ingenieroRepository;

    @Autowired
    public GuardarRegistro(IngenieroRepository ingenieroRepository) {
        this.ingenieroRepository = ingenieroRepository;
    }


}
