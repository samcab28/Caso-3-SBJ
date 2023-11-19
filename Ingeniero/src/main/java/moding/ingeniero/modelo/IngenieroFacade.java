package moding.ingeniero.modelo;


import java.util.Vector;

public class IngenieroFacade {
    private Vector<Ingeniero> ingenieros;

    public IngenieroFacade() {
        this.ingenieros = new Vector<>();
    }

    public void agregarIngeniero(Ingeniero ingeniero) {
        ingenieros.add(ingeniero);
    }

    public void eliminarIngeniero(Ingeniero ingeniero) {
        ingenieros.remove(ingeniero);
    }

    public Vector<Ingeniero> obtenerListaDeIngenieros() {
        return ingenieros;
    }

    public Ingeniero buscarIngenieroPorCorreo(String correoIngeniero) {
        for (Ingeniero ingeniero : ingenieros) {
            if (ingeniero.getCorreoIngeniero().equals(correoIngeniero)) {
                return ingeniero;
            }
        }
        return null; // Devuelve null si no se encuentra el ingeniero
    }

    public void setIngenieros(Vector<Ingeniero> ingenieros) {
        this.ingenieros = ingenieros;
    }
}
