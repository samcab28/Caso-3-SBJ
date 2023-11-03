package contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoFacade {
    private List<Contacto> contactos;

    public ContactoFacade() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public List<Contacto> obtenerListaDeContactos() {
        return contactos;
    }
}