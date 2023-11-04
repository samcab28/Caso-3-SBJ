package sector;

import java.util.ArrayList;
import java.util.List;

// Clase SectorFacade para administrar la lista de sectores
public class SectorFacade {
    private List<Sector> sectores;

    public SectorFacade() {
        this.sectores = new ArrayList<>();
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public void eliminarSector(Sector sector) {
        sectores.remove(sector);
    }

    public List<Sector> obtenerListaDeSectores() {
        return sectores;
    }

    public Sector buscarSectorPorNombre(String nombreSector) {
        for (Sector sector : sectores) {
            if (sector.getNombre().equals(nombreSector)) {
                return sector;
            }
        }
        return null; // Devuelve null si no se encuentra el sector
    }

}