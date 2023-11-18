package modagri.agricultor.conexion;

import java.util.List;

public class DatosCalculo {
    private String cultivo;
    private String sector;
    private String ancho;
    private String largo;
    private List<String> innovaciones;
    
    public DatosCalculo() {
    	
    }
    
	public String getCultivo() {
		return cultivo;
	}
	public void setCultivo(String cultivo) {
		this.cultivo = cultivo;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAncho() {
		return ancho;
	}
	public void setAncho(String ancho) {
		this.ancho = ancho;
	}
	public String getLargo() {
		return largo;
	}
	public void setLargo(String largo) {
		this.largo = largo;
	}
	public List<String> getInnovaciones() {
		return innovaciones;
	}
	public void setInnovaciones(List<String> innovaciones) {
		this.innovaciones = innovaciones;
	}
	
	public int getInnovacionesNum() {
		return innovaciones.size();
	}
}
