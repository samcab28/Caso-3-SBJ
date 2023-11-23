package moding.ingeniero.controller;

import moding.ingeniero.modelo.contacto.Contacto;
import moding.ingeniero.repositorioConexion.ConexionContacto;
import moding.ingeniero.repositorioConexion.MongoDataBaseConnection;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class InformacionController {
    MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
    ConexionContacto conexionContacto = ConexionContacto.getInstance(mongoDB.getDatabase());
    private String direccionesCorreos;


    public InformacionController() {
        this.direccionesCorreos = direccionesCorreos();
    }

    public void cargaDatosEnvioInformacion(String asunto, String mensaje) {
        String Encabezado = asunto;
        String ContenidoCorreo = mensaje;

        if (Encabezado == null || Encabezado.isEmpty() || ContenidoCorreo == null || ContenidoCorreo.isEmpty()) {
            System.out.println("Error: mensaje no enviado, campos vacíos");
        } else {
            enviarCorreo(Encabezado, ContenidoCorreo);
        }
    }

    public void enviarCorreo(String Encabezado, String ContenidoCorreo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pruebacorreosamir@gmail.com", "nrhd vunk ipwd upwv");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pruebacorreosamir@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(direccionesCorreos));
            message.setSubject(Encabezado);
            message.setText(ContenidoCorreo);

            System.out.println("Sending...");
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private String direccionesCorreos() {
        StringBuilder direcciones = new StringBuilder();
        try {
            for (Contacto contacto : conexionContacto.getContactos()) {
                if (contacto.getCorreoContacto() != null && !contacto.getCorreoContacto().isEmpty()) {
                    direcciones.append(contacto.getCorreoContacto()).append(",");
                }
            }
            if (direcciones.length() > 0) {
                direcciones.deleteCharAt(direcciones.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Direcciones de correo: " + direcciones.toString());
        return direcciones.toString();
    }
}
