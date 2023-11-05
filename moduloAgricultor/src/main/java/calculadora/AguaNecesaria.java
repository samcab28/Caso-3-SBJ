package calculadora;

public class AguaNecesaria {

    private float cantidadAgua;
    private float ancho;

    private float largo;

    public AguaNecesaria(float cantidadAgua, float ancho, float largo){
        this.cantidadAgua = cantidadAgua;
        this.ancho = ancho;
        this.largo = largo;
    }

    public float calculo(){
        float resultado = cantidadAgua*(ancho*largo);
        return resultado;
    }
}
