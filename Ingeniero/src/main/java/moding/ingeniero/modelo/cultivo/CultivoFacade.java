package moding.ingeniero.modelo.cultivo;


import moding.ingeniero.modelo.cultivo.Cultivo;

import java.util.Vector;

public class CultivoFacade {
    private Vector<Cultivo> cultivos;

    public CultivoFacade() {
        this.cultivos = new Vector<>();
    }

    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    public void eliminarCultivo(Cultivo cultivo) {
        cultivos.remove(cultivo);
    }

    public Vector<Cultivo> obtenerListaDeCultivos() {
        return cultivos;
    }

    public Cultivo buscarCultivoPorNombre(String nombreCultivo) {
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getNombre().equals(nombreCultivo)) {
                return cultivo;
            }
        }
        return null; // Devuelve null si no se encuentra el cultivo
    }

    public void setCultivos(Vector<Cultivo> cultivos) {
        this.cultivos = cultivos;

    }
}


