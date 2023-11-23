package moding.ingeniero.modelo.cultivo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Cultivo {
    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private double tempMinima;
    @Field
    private double tempMaxima;
    @Field
    private double cantidadAgua;
    @Field
    private int diasMinCosecha;
    @Field
    private int diasMaxCosecha;
    @Field
    private double precioUnidad;

    @Field
    private int cantidadPorMetro2;

    public Cultivo(String nombre, double tempMinima, double tempMaxima, double cantidadAgua, int diasMinCosecha, int diasMaxCosecha, double precioUnidad, int cantidadPorMetro2) {
        this.nombre = nombre;
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
        this.cantidadAgua = cantidadAgua;
        this.diasMinCosecha = diasMinCosecha;
        this.diasMaxCosecha = diasMaxCosecha;
        this.precioUnidad = precioUnidad;
        this.cantidadPorMetro2= cantidadPorMetro2;
    }

    // Métodos getter y setter para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public double getCantidadAgua() {
        return cantidadAgua;
    }

    public void setCantidadAgua(double cantidadAgua) {
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

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidadPorMetro2() {
        return cantidadPorMetro2;
    }

    public void setCantidadPorMetro2(int cantidadPorMetro2) {
        this.cantidadPorMetro2 = cantidadPorMetro2;
    }

    @Override
    public String toString() {
        return String.format("Cultivo[id='%s',nombre='%s',tempMinima='%s',tempMaxima='%s',cantidadAgua='%s',diasMinCosecha='%s',diasMaxCosecha='%s',precioUnidad='%s',cantidadPorMetro2='%s']",id,nombre,tempMinima,tempMaxima,cantidadAgua,diasMinCosecha,diasMaxCosecha,precioUnidad,cantidadPorMetro2);
    }
}