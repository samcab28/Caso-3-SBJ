package zona;

import java.util.ArrayList;
import java.util.List;
import cultivo.*;
import sector.*;

// Clase Zona que representa una zona de cultivo
public class Zona {
    private String nombre;
    private float largo;
    private float ancho;
    private Cultivo cultivo;
    private Sector sector;

    public Zona(String nombre, float largo, float ancho, Cultivo cultivo, Sector sector) {
        this.nombre = nombre;
        this.largo = largo;
        this.ancho = ancho;
        this.cultivo = cultivo;
        this.sector = sector;
    }

    // Métodos getter y setter para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getNombreCultivo() {
        if (cultivo != null) {
            return cultivo.getNombre();
        } else {
            return null;
        }
    }

    public String getNombreSector() {
        if (sector != null) {
            return sector.getNombre(); // Suponiendo que la clase Sector tiene un método getNombre()
        } else {
            return null;
        }
    }
}