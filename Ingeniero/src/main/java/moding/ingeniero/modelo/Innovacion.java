package moding.ingeniero.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Innovacion {

@Id
private String id;

@Field
private String nombre;

@Field
private String linkPagina;

@Field
private String descripcion;

@Field
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

@Override
public String toString() {
    return String.format("Innovacion[id='%s',nombre='%s,linkPagina='%s',descripcion='%s',costo='%s']",id,nombre,linkPagina,descripcion,costo);
}
}
