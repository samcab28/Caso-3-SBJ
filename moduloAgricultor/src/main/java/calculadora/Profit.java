package calculadora;

public class Profit {
    private float precioUnidad;
    private float ancho;
    private float largo;

    private int cantidadxMetro;

    public Profit(float precioUnidad, float ancho, float largo, int cantidadxMetro){
        this.precioUnidad = precioUnidad;
        this.ancho = ancho;
        this.largo = largo;
        this.cantidadxMetro = cantidadxMetro;
    }

    public float calculo(){
        float resultado = precioUnidad * (ancho*largo) * cantidadxMetro;
        return resultado;
    }

}
