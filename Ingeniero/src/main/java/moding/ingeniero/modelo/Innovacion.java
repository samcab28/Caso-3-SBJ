package moding.ingeniero.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Innovacion {

@Id
private String id;

@Field
private String nombreInnovacion;

@Field
private String linkPaginaInnovacion;

@Field
private String descripcionInnovacion;

@Field
private double costoInnovacion;

public Innovacion(String nombreInnovacion, String linkPaginaInnovacion, String descripcionInnovacion, double costoInnovacion){
    this.nombreInnovacion = nombreInnovacion;
    this.linkPaginaInnovacion = linkPaginaInnovacion;
    this.descripcionInnovacion = descripcionInnovacion;
    this.costoInnovacion = costoInnovacion;
}

public double getCostoInnovacion() {
    return costoInnovacion;
}

public void setCostoInnovacion(double costoInnovacion) {
    this.costoInnovacion = costoInnovacion;
}

public String getDescripcionInnovacion() {
    return descripcionInnovacion;
}

public void setDescripcionInnovacion(String descripcionInnovacion) {
    this.descripcionInnovacion = descripcionInnovacion;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getLinkPaginaInnovacion() {
    return linkPaginaInnovacion;
}

public void setLinkPaginaInnovacion(String linkPaginaInnovacion) {
    this.linkPaginaInnovacion = linkPaginaInnovacion;
}

public String getNombreInnovacion() {
    return nombreInnovacion;
}

public void setNombreInnovacion(String nombreInnovacion) {
    this.nombreInnovacion = nombreInnovacion;
}

@Override
public String toString() {
    return String.format("Innovacion[id='%s',nombre='%s,linkPagina='%s',descripcion='%s',costo='%s']",id, nombreInnovacion, linkPaginaInnovacion, descripcionInnovacion, costoInnovacion);
}
}
