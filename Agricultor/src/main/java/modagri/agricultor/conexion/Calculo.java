package modagri.agricultor.conexion;

import java.util.Random;

import modagri.agricultor.almacenamiento.Cultivo;
import modagri.agricultor.almacenamiento.CultivoFacade;
import modagri.agricultor.almacenamiento.Sector;
import modagri.agricultor.almacenamiento.SectorFacade;

public class Calculo {
	
	float precioAgua = 11;
	
	float ancho;
	float largo;
	
	
	CultivoFacade cultivoFachada;
	SectorFacade sectorFachada;
	
	public Calculo(CultivoFacade cultivoFachada, SectorFacade sectorFachada, float ancho, float largo) {
		this.cultivoFachada = cultivoFachada;
		this.sectorFachada = sectorFachada;
		this.ancho = ancho;
		this.largo = largo;
	}
	
	public float aguaNecesaria(String nombreCultivo, float ancho, float largo) {
		Cultivo cultivo = cultivoFachada.buscarCultivoPorNombre(nombreCultivo);
		
		float aguaNecesaria = cultivo.getCantidadAgua()*ancho*largo;
		return aguaNecesaria;
		
	}
	
	public float dineroCosto(float cantidadAgua, float extras) {
		float costoAgua = cantidadAgua*precioAgua;
		return costoAgua + extras;
	}
		
	public float profitBruto(String nombreCultivo, float ancho, float largo) {
		
		Cultivo cultivo = cultivoFachada.buscarCultivoPorNombre(nombreCultivo);
		
		float metro2 = cultivo.getPrecioUnidad() * cultivo.getCantidadPorMetro2();
		float profitBruto = metro2 * ancho* largo;
		
		return profitBruto;
		
	}
	
	public double probabilidadExito(String nombreSector, String nombreCultivo, int innovaciones) {
		
		Random random = new Random();
		
		int min = 2;
		int max = 7;
		int randomNumber;
		
		double percent = 0;
		
		for (int i = 0; i < innovaciones; i++) {
			randomNumber = random.nextInt(max - min + 1) + min;
			percent += randomNumber*0.01;
		}
		
		
		Sector sector = sectorFachada.buscarSectorPorNombre(nombreSector);
		Cultivo cultivo = cultivoFachada.buscarCultivoPorNombre(nombreCultivo);
		
		float tempMinima = cultivo.getTempMinima();
		float tempMaxima = cultivo.getTempMaxima();
		int temperaturamedia = sector.getTemperaturaMedia();
		int lluviaMediaAnual = sector.getLluviaMediaAnual();
		
		if (tempMinima < temperaturamedia && temperaturamedia < tempMaxima && lluviaMediaAnual >= 2000) {
            return 0.90 + percent;
        }
        if (tempMinima < temperaturamedia && temperaturamedia < tempMaxima) {
            return 0.80 + percent;
        }
        if(tempMinima > temperaturamedia || tempMaxima > temperaturamedia){
            return 0.60 + percent;
        }
        return 0.50 + percent;
	}
	
	public String recomendacion(float profitBruto, float inversion) {
		if(profitBruto > inversion*2){
            return "Se recomienda fuertemente la inversión, hay más del doble invertido en ganacias.";
        }
        if(profitBruto > inversion){
            return "Se recomienda la inversion, hay ganancias.";
        }
        if(profitBruto <= inversion){
            return "No se recomienda la inversion, no hay ganancias.";
        }
        return "";
	}
}
