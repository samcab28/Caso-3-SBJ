package moding.ingeniero.controller.modificacionRequest;

public class ModificacionContactoRequest {

    private String correoContacto;
    private String nuevoNombre;
    private String nuevoApellido;
    private String nuevoTelefono;
    private String nuevoCorreo;
    private String nuevoUsuarioTelegram;

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getNuevoApellido() {
        return nuevoApellido;
    }

    public void setNuevoApellido(String nuevoApellido) {
        this.nuevoApellido = nuevoApellido;
    }

    public String getNuevoCorreo() {
        return nuevoCorreo;
    }

    public void setNuevoCorreo(String nuevoCorreo) {
        this.nuevoCorreo = nuevoCorreo;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public String getNuevoTelefono() {
        return nuevoTelefono;
    }

    public void setNuevoTelefono(String nuevoTelefono) {
        this.nuevoTelefono = nuevoTelefono;
    }

    public String getNuevoUsuarioTelegram() {
        return nuevoUsuarioTelegram;
    }

    public void setNuevoUsuarioTelegram(String nuevoUsuarioTelegram) {
        this.nuevoUsuarioTelegram = nuevoUsuarioTelegram;
    }
}
