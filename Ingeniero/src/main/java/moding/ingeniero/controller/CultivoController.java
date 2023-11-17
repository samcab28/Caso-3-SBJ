package moding.ingeniero.controller;

import moding.ingeniero.modelo.Cultivo;
import moding.ingeniero.repositorio.CultivoRepository;

import java.util.List;
import java.util.Optional;

public class CultivoController {

    private final CultivoRepository cultivoRepository;


    public CultivoController(CultivoRepository cultivoRepository) {
        this.cultivoRepository = cultivoRepository;
    }

    public void eliminarCultivo(String nombreCultivo) {
        // Buscar el cultivo por nombre
        Optional<Cultivo> cultivoOptional = cultivoRepository.findByNombre(nombreCultivo);

        // Si existe, eliminarlo
        cultivoOptional.ifPresent(cultivo -> {
            cultivoRepository.delete(cultivo);

            // Puedes imprimir los cultivos restantes si es necesario
            List<Cultivo> listaCultivosRestantes = cultivoRepository.findAll();
            for (Cultivo c : listaCultivosRestantes) {
                System.out.println(c.getNombre());
            }
        });
    }
}
