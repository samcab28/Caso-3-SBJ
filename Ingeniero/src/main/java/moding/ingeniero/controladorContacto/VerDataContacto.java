package moding.ingeniero.controladorContacto;

import moding.ingeniero.modelo.Contacto;
import moding.ingeniero.repositorio.ContactoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VerDataContacto {
    private final ContactoRepository contactoRepository;


    public VerDataContacto(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @GetMapping("/verContacto")
    public List<Contacto> getUsers(){
        return contactoRepository.findAll();
    }
}
