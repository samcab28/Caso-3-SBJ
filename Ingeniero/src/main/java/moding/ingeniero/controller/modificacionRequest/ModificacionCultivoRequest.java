package moding.ingeniero.controller.modificacionRequest;

public class ModificacionCultivoRequest {
    private String nombre;
    private String nuevoNombre;
    private String nuevaTempMinima;
    private String nuevaTempMaxima;
    private String nuevaCantidadAgua;
    private String nuevaDiasMinCosecha;
    private String nuevaDiasMaxCosecha;
    private String nuevoPrecioUnidad;
    private String nuevaCantidadPorMetro2;
    
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
	public String getNuevaTempMinima() {
		return nuevaTempMinima;
	}
	public void setNuevaTempMinima(String nuevaTempMinima) {
		this.nuevaTempMinima = nuevaTempMinima;
	}
	public String getNuevaTempMaxima() {
		return nuevaTempMaxima;
	}
	public void setNuevaTempMaxima(String nuevaTempMaxima) {
		this.nuevaTempMaxima = nuevaTempMaxima;
	}
	public String getNuevaCantidadAgua() {
		return nuevaCantidadAgua;
	}
	public void setNuevaCantidadAgua(String nuevaCantidadAgua) {
		this.nuevaCantidadAgua = nuevaCantidadAgua;
	}
	public String getNuevaDiasMinCosecha() {
		return nuevaDiasMinCosecha;
	}
	public void setNuevaDiasMinCosecha(String nuevaDiasMinCosecha) {
		this.nuevaDiasMinCosecha = nuevaDiasMinCosecha;
	}
	public String getNuevaDiasMaxCosecha() {
		return nuevaDiasMaxCosecha;
	}
	public void setNuevaDiasMaxCosecha(String nuevaDiasMaxCosecha) {
		this.nuevaDiasMaxCosecha = nuevaDiasMaxCosecha;
	}
	public String getNuevoPrecioUnidad() {
		return nuevoPrecioUnidad;
	}
	public void setNuevoPrecioUnidad(String nuevoPrecioUnidad) {
		this.nuevoPrecioUnidad = nuevoPrecioUnidad;
	}
	public String getNuevaCantidadPorMetro2() {
		return nuevaCantidadPorMetro2;
	}
	public void setNuevaCantidadPorMetro2(String nuevaCantidadPorMetro2) {
		this.nuevaCantidadPorMetro2 = nuevaCantidadPorMetro2;
	}
}
