package moding.ingeniero.modelo.ingeniero;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Ingeniero {

    @Id
    private String id;

    @Field
    private String correoIngeniero;

    @Field
    private String passwordIngeniero;

    @Field
    private String nombreIngeniero;

    public Ingeniero(){}

    public Ingeniero(String correoIngeniero, String passwordIngeniero, String nombreIngeniero){
        this.correoIngeniero = correoIngeniero;
        this.passwordIngeniero = passwordIngeniero;
        this.nombreIngeniero = nombreIngeniero;
    }

    public String getCorreoIngeniero() {
        return correoIngeniero;
    }

    public void setCorreoIngeniero(String correoIngeniero) {
        this.correoIngeniero = correoIngeniero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswordIngeniero() {
        return passwordIngeniero;
    }

    public void setPasswordIngeniero(String passwordIngeniero) {
        this.passwordIngeniero = passwordIngeniero;
    }

    public String getNombreIngeniero() {
        return nombreIngeniero;
    }

    public void setNombreIngeniero(String nombreIngeniero) {
        this.nombreIngeniero = nombreIngeniero;
    }

    @Override
    public String toString() {
        return String.format("Ingeniero[id='%s',nombre='%s',correo='%s',password='%s']",id, nombreIngeniero, correoIngeniero, passwordIngeniero);
    }
}
