package almacenamiento;

import java.util.ArrayList;
import java.util.List;

// Clase ZonaFacade para administrar la lista de zonas
public class ZonaFacade {
    private List<Zona> zonas;

    public ZonaFacade() {
        this.zonas = new ArrayList<>();
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public void eliminarZona(Zona zona) {
        zonas.remove(zona);
    }

    public List<Zona> obtenerListaDeZonas() {
        return zonas;
    }
}
