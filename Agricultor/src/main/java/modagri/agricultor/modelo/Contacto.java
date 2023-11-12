package modagri.agricultor.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

// Clase Contacto que representa un contacto
@Document
public class Contacto {
    @Id
    private String id;

    @Field
    private String nombre;
    @Field
    private String apellido;

    @Field
    private String telefono;

    @Field
    private String correo;

    @Field
    private String usuarioTelegram;

    public Contacto(){}

    public Contacto(String nombre, String apellido,String telefono, String correo, String usuarioTelegram){
        this.nombre= nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.correo=correo;
        this.usuarioTelegram=usuarioTelegram;
    }

    // Métodos getter y setter para acceder a los atributos


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuarioTelegram() {
        return usuarioTelegram;
    }

    public void setUsuarioTelegram(String usuarioTelegram) {
        this.usuarioTelegram = usuarioTelegram;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return String.format("Contacto[id='%s',,nombre='%s',apellido='%s',telefono='%s',correo='%s',usuarioTelegram='%s']",id,nombre,apellido,telefono,correo,usuarioTelegram);
    }
}