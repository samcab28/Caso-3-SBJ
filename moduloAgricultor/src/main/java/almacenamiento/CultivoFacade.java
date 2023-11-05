package almacenamiento;

import java.util.ArrayList;
import java.util.List;
public class CultivoFacade {
    private List<Cultivo> cultivos;

    public CultivoFacade() {
        this.cultivos = new ArrayList<>();
    }

    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    public void eliminarCultivo(Cultivo cultivo) {
        cultivos.remove(cultivo);
    }

    public List<Cultivo> obtenerListaDeCultivos() {
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
}
