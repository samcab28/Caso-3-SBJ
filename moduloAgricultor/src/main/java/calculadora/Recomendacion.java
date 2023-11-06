package calculadora;

public class Recomendacion {

    private float profit;

    private float inversion;

    public Recomendacion(float profit, float inversion){
        this.profit = profit;
        this.inversion = inversion;
    }

    public String calculoRecomendacion(){
        if(profit > inversion*2){
            return "se recomienda fuertemente la inversion";
        }
        if(profit > inversion){
            return "se recomienda la inversion";
        }
        if(profit <= inversion){
            return "no se recomienda la inversion";
        }
        return "";
    }
}
