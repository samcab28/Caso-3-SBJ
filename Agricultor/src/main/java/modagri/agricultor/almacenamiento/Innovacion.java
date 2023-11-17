package modagri.agricultor.almacenamiento;


public class Innovacion {

    private String id;

    private String nombre;

    private String linkPagina;

    private String descripcion;

    private double costo;

    public Innovacion(String nombre, String linkPagina, String descripcion, double costo){
        this.nombre = nombre;
        this.linkPagina = linkPagina;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

