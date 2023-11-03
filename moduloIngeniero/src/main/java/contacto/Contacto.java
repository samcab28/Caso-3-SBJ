package contacto;

import java.util.ArrayList;
import java.util.List;

// Clase Contacto que representa un contacto
public class Contacto {
    private String nombre;
    private long telefono;
    private String correo;
    private String usuarioTelegram;

    public Contacto(String nombre, long telefono, String correo, String usuarioTelegram) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.usuarioTelegram = usuarioTelegram;
    }

    // Métodos getter y setter para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuarioTelegram() {
        return usuarioTelegram;
    }

    public void setUsuarioTelegram(String usuarioTelegram) {
        this.usuarioTelegram = usuarioTelegram;
    }
}
