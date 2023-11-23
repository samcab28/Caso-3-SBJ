package moding.ingeniero.modelo.contacto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// Clase Contacto que representa un contacto
@Document
public class Contacto {
    @Id
    private String id;

    @Field
    private String nombreContacto;
    @Field
    private String apellidoContacto;

    @Field
    private String telefonoContacto;

    @Field
    private String correoContacto;

    @Field
    private String usuarioTelegramContacto;

    public Contacto(){}

    public Contacto(String nombreContacto, String apellidoContacto, String telefonoContacto, String correoContacto, String usuarioTelegramContacto){
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefonoContacto = telefonoContacto;
        this.correoContacto = correoContacto;
        this.usuarioTelegramContacto = usuarioTelegramContacto;
    }

    // Métodos getter y setter para acceder a los atributos


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getUsuarioTelegramContacto() {
        return usuarioTelegramContacto;
    }

    public void setUsuarioTelegramContacto(String usuarioTelegramContacto) {
        this.usuarioTelegramContacto = usuarioTelegramContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    @Override
    public String toString(){
        return String.format("Contacto[id='%s',,nombre='%s',apellido='%s',telefono='%s',correo='%s',usuarioTelegram='%s']",id, nombreContacto, apellidoContacto, telefonoContacto, correoContacto, usuarioTelegramContacto);
    }
}