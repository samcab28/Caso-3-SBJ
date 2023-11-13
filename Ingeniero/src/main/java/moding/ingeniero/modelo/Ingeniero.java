package moding.ingeniero.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Ingeniero {

    @Id
    private String id;

    @Field
    private String Correo;

    @Field
    private String Password;

    @Field
    private String nombre;

    public Ingeniero(){}

    public Ingeniero(String correo, String Password,String Nombre){
        this.Correo = correo;
        this.Password = Password;
        this.nombre=Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("Ingeniero[id='%s',nombre='%s',correo='%s',password='%s']",id,nombre,Correo,Password);
    }
}
