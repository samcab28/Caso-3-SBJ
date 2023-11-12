package modagri.agricultor.controladorContacto;

import modagri.agricultor.modelo.Contacto;
import modagri.agricultor.repositorio.ContactoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class verDataContacto {
    private final ContactoRepository contactoRepository;


    public verDataContacto(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @GetMapping("/verContacto")
    public List<Contacto> getUsers(){
        return contactoRepository.findAll();
    }
}
