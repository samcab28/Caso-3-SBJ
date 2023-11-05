package calculadora;

public class DineroFuncionamiento {

    private float precioAgua;
    private float cantidadAgua;

    private float ancho;

    private float largo;

    private float extras;

    public DineroFuncionamiento(float cantidadAgua, float ancho, float largo, float extras){
        precioAgua = 409;
        this.cantidadAgua = cantidadAgua;
        this.ancho = ancho;
        this.largo = largo;
        this.extras = extras;
    }

    public float calculo(){
        float resultado = (precioAgua*(cantidadAgua*(ancho*largo)))+extras;
        return resultado;
    }

}
