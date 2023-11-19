package moding.ingeniero.modelo;

import java.util.Vector;

public class ContactoFacade {
    private Vector<Contacto> contactos;

    public ContactoFacade() {
        this.contactos = new Vector<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public Vector<Contacto> obtenerListaDeContactos() {
        return contactos;
    }

    public Contacto buscarContactoPorCorreo(String correoContacto) {
        for (Contacto contacto : contactos) {
            if (contacto.getCorreoContacto().equals(correoContacto)) {
                return contacto;
            }
        }
        return null; // Devuelve null si no se encuentra el contacto
    }

    public void setContactos(Vector<Contacto> contactos) {
        this.contactos = contactos;
    }
}
