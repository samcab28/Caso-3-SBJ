package moding.ingeniero.controller;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class IngenieroController {

    private final IngenieroRepository ingenieroRepository;

    @Autowired
    public IngenieroController(IngenieroRepository ingenieroRepository) {
        this.ingenieroRepository = ingenieroRepository;
    }

    public void agregar(Ingeniero ingeniero) {
        ingenieroRepository.save(ingeniero);
    }

    public boolean comprobar(String username, String password){
        for(Ingeniero ingenieroVerificar: ingenieroRepository.findAll()){
            if(username.equals(ingenieroVerificar.getCorreo()) && password.equals(ingenieroVerificar.getPassword())){
                System.out.println("login exitoso con el correo: " + ingenieroVerificar.getCorreo() );
                return true;
            }
        }
        System.out.println("login no exitoso");
        return false;
    }
}
