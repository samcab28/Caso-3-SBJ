package moding.ingeniero.controller;

import moding.ingeniero.modelo.Contacto;
import moding.ingeniero.repositorio.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class InformacionController {

    private final ContactoRepository contactoRepository;

    private String direccionesCorreos;


    @Autowired
    public InformacionController(ContactoRepository contactoRepository){
        this.contactoRepository = contactoRepository;
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
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // TLS Port
        props.put("mail.smtp.auth", "true"); // Habilita la autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS

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
            for (Contacto contacto : contactoRepository.findAll()) {
                if (contacto.getCorreo() != null && !contacto.getCorreo().isEmpty()) {
                    direcciones.append(contacto.getCorreo()).append(",");
                }
            }
            // Elimina la última coma si hay correos en la lista
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
