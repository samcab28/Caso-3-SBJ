package moding.ingeniero.modelo;

import java.util.Vector;

public class InnovacionFacade {
    private Vector<Innovacion> innovaciones;

    public InnovacionFacade() {
        this.innovaciones = new Vector<>();
    }

    public  Vector<Innovacion> obtenerListaDeInnovaciones() {
        return innovaciones;
    }

}
