package almacenamiento;

import java.util.ArrayList;
import java.util.List;

// Clase Cultivo que representa un cultivo
public class Cultivo {
    private String nombre;
    private float tempMinima;
    private float tempMaxima;
    private float cantidadAgua;
    private int diasMinCosecha;
    private int diasMaxCosecha;

    public Cultivo(String nombre, float tempMinima, float tempMaxima, float cantidadAgua, int diasMinCosecha, int diasMaxCosecha) {
        this.nombre = nombre;
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
        this.cantidadAgua = cantidadAgua;
        this.diasMinCosecha = diasMinCosecha;
        this.diasMaxCosecha = diasMaxCosecha;
    }

    // Métodos getter y setter para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(float tempMinima) {
        this.tempMinima = tempMinima;
    }

    public float getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(float tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public float getCantidadAgua() {
        return cantidadAgua;
    }

    public void setCantidadAgua(float cantidadAgua) {
        this.cantidadAgua = cantidadAgua;
    }

    public int getDiasMinCosecha() {
        return diasMinCosecha;
    }

    public void setDiasMinCosecha(int diasMinCosecha) {
        this.diasMinCosecha = diasMinCosecha;
    }

    public int getDiasMaxCosecha() {
        return diasMaxCosecha;
    }

    public void setDiasMaxCosecha(int diasMaxCosecha) {
        this.diasMaxCosecha = diasMaxCosecha;
    }
}