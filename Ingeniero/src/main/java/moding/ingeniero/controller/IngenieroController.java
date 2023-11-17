package moding.ingeniero.controller;

import moding.ingeniero.modelo.Ingeniero;
import moding.ingeniero.repositorio.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngenieroController {

    private final IngenieroRepository ingenieroRepository;

    @Autowired
    public IngenieroController(IngenieroRepository ingenieroRepository) {
        this.ingenieroRepository = ingenieroRepository;
    }

    public boolean agregarIngeniero(Ingeniero ingeniero) {
        // Verifica si ya existe un ingeniero con el mismo correo
        if (ingenieroRepository.existsByCorreo(ingeniero.getCorreo())) {
            System.out.println("El ingeniero ya existe con el correo: " + ingeniero.getCorreo());
            return false; // No se agrega el ingeniero
        } else {
            ingenieroRepository.save(ingeniero);
            System.out.println("Ingeniero agregado con éxito");
            return true; // Ingeniero agregado con éxito
        }
    }

    public boolean comprobarIngeniero(String username, String password) {
        for (Ingeniero ingenieroVerificar : ingenieroRepository.findAll()) {
            if (username.equals(ingenieroVerificar.getCorreo()) && password.equals(ingenieroVerificar.getPassword())) {
                System.out.println("Login exitoso con el correo: " + ingenieroVerificar.getCorreo());
                return true;
            }
        }
        System.out.println("Login no exitoso");
        return false;
    }


}
