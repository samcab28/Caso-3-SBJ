package cultivo;

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
}
