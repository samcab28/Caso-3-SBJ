package sector;

import java.util.ArrayList;
import java.util.List;

// Clase Sector que representa un sector de cultivo
public class Sector {
    private String nombre;
    private int lluviaMediaAnual;
    private int temperaturaMedia;
    private int promedioLluvias;
    private int duracionPeriodoSeco;

    public Sector(String nombre, int lluviaMediaAnual, int temperaturaMedia, int promedioLluvias, int duracionPeriodoSeco) {
        this.nombre = nombre;
        this.lluviaMediaAnual = lluviaMediaAnual;
        this.temperaturaMedia = temperaturaMedia;
        this.promedioLluvias = promedioLluvias;
        this.duracionPeriodoSeco = duracionPeriodoSeco;
    }

    // Métodos getter y setter para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLluviaMediaAnual() {
        return lluviaMediaAnual;
    }

    public void setLluviaMediaAnual(int lluviaMediaAnual) {
        this.lluviaMediaAnual = lluviaMediaAnual;
    }

    public int getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(int temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public int getPromedioLluvias() {
        return promedioLluvias;
    }

    public void setPromedioLluvias(int promedioLluvias) {
        this.promedioLluvias = promedioLluvias;
    }

    public int getDuracionPeriodoSeco() {
        return duracionPeriodoSeco;
    }

    public void setDuracionPeriodoSeco(int duracionPeriodoSeco) {
        this.duracionPeriodoSeco = duracionPeriodoSeco;
    }
}