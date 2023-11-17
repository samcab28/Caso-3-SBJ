package modagri.agricultor.almacenamiento;


import java.util.Vector;

// Clase SectorFacade para administrar la lista de sectores
public class SectorFacade {
    private Vector<Sector> sectores;

    public SectorFacade() {
        this.sectores = new Vector<>();
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public void eliminarSector(Sector sector) {
        sectores.remove(sector);
    }

    public Vector<Sector> obtenerListaDeSectores() {
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

    public void setSectores (Vector<Sector> sectores) {
        this.sectores = sectores;
    }

}
