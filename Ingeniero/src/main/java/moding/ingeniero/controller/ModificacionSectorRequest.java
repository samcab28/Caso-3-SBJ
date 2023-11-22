package moding.ingeniero.controller;

public class ModificacionSectorRequest {
	
	private String nombre;
    private String nuevoNombre;
    private String nuevaLluviaMediaAnual;
    private String nuevaTemperaturaMedia;
    private String nuevoPromedioLluvias;
    private String nuevaDuracionPeriodoSeco;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNuevoNombre() {
		return nuevoNombre;
	}
	public void setNuevoNombre(String nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}
	public String getNuevaLluviaMediaAnual() {
		return nuevaLluviaMediaAnual;
	}
	public void setNuevaLluviaMediaAnual(String nuevaLluviaMediaAnual) {
		this.nuevaLluviaMediaAnual = nuevaLluviaMediaAnual;
	}
	public String getNuevaTemperaturaMedia() {
		return nuevaTemperaturaMedia;
	}
	public void setNuevaTemperaturaMedia(String nuevaTemperaturaMedia) {
		this.nuevaTemperaturaMedia = nuevaTemperaturaMedia;
	}
	public String getNuevoPromedioLluvias() {
		return nuevoPromedioLluvias;
	}
	public void setNuevoPromedioLluvias(String nuevoPromedioLluvias) {
		this.nuevoPromedioLluvias = nuevoPromedioLluvias;
	}
	public String getNuevaDuracionPeriodoSeco() {
		return nuevaDuracionPeriodoSeco;
	}
	public void setNuevaDuracionPeriodoSeco(String nuevaDuracionPeriodoSeco) {
		this.nuevaDuracionPeriodoSeco = nuevaDuracionPeriodoSeco;
	}
}
