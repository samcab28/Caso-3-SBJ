package calculadora;

public class ProbabilidadExito {

    private int temperaturamedia;
    private int lluviaMediaAnual;
    private float tempMinima;
    private float tempMaxima;

    public ProbabilidadExito(int temperaturamedia, int lluviaMediaAnual, float tempMinima, float tempMaxima){
        this.temperaturamedia = temperaturamedia;
        this.lluviaMediaAnual = lluviaMediaAnual;
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
    }

    public String calculoProbabilidadExito(){
        if (tempMinima < temperaturamedia && temperaturamedia < tempMaxima && lluviaMediaAnual >= 2000) {
            return "probabilidad de 90% de éxito";
        }
        if (tempMinima < temperaturamedia && temperaturamedia < tempMaxima) {
            return "probabilidad de un 80% de éxito";
        }
        if(tempMinima > temperaturamedia || tempMaxima > temperaturamedia){
            return "probabilidad de 60%";
        }
        // Agrega un valor de retorno por defecto o manejo de caso en el que ninguna condición se cumpla
        return "probabilidad desconocida";
    }

}
