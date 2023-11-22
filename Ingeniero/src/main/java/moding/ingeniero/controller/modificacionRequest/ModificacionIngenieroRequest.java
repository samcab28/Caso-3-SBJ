package moding.ingeniero.controller.modificacionRequest;

public class ModificacionIngenieroRequest {

    private String correoIngeniero;

    private String nuevoCorreoIngeniero;

    private String nuevoPasswordIngeniero;

    private String nuevoNombreIngeniero;

    public String getCorreoIngeniero() {
        return correoIngeniero;
    }

    public void setCorreoIngeniero(String correoIngeniero) {
        this.correoIngeniero = correoIngeniero;
    }

    public String getNuevoCorreoIngeniero() {
        return nuevoCorreoIngeniero;
    }

    public void setNuevoCorreoIngeniero(String nuevoCorreoIngeniero) {
        this.nuevoCorreoIngeniero = nuevoCorreoIngeniero;
    }

    public String getNuevoNombreIngeniero() {
        return nuevoNombreIngeniero;
    }

    public void setNuevoNombreIngeniero(String nuevoNombreIngeniero) {
        this.nuevoNombreIngeniero = nuevoNombreIngeniero;
    }

    public String getNuevoPasswordIngeniero() {
        return nuevoPasswordIngeniero;
    }

    public void setNuevoPasswordIngeniero(String nuevoPasswordIngeniero) {
        this.nuevoPasswordIngeniero = nuevoPasswordIngeniero;
    }
}
