package moding.ingeniero.modelo.sector;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Sector {

    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private int lluviaMediaAnual;
    @Field
    private int temperaturaMedia;
    @Field
    private int promedioLluvias;
    @Field
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

    @Override
    public String toString(){
        return String.format("Sector[id='%s',,nombre='%s',lluviaMediaAnual='%s',temperaturaMedia='%s',promedioLluvias='%s',duracionPeriodoSeco='%s']",id,nombre,lluviaMediaAnual,temperaturaMedia,promedioLluvias,duracionPeriodoSeco);
    }
}
