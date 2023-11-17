package modagri.agricultor.almacenamiento;



// Clase Cultivo que representa un cultivo
public class Cultivo {
    private String nombre;
    private float tempMinima;
    private float tempMaxima;
    private float cantidadAgua;
    private int diasMinCosecha;
    private int diasMaxCosecha;
    private int cantidadPorMetro2;

    private float precioUnidad;

    public Cultivo(String nombre, float tempMinima, float tempMaxima, float cantidadAgua, int diasMinCosecha, int diasMaxCosecha, float precioUnidad, int cantidadPorMetro2) {
        this.nombre = nombre;
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
        this.cantidadAgua = cantidadAgua;
        this.diasMinCosecha = diasMinCosecha;
        this.diasMaxCosecha = diasMaxCosecha;
        this.precioUnidad = precioUnidad;
        this.cantidadPorMetro2 = cantidadPorMetro2;
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

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidadPorMetro2() {
        return cantidadPorMetro2;
    }
}