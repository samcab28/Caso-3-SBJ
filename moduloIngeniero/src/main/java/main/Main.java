package main;

import dataBase.ConexionContacto;
import dataBase.MongoDatabaseConnection;
import cultivo.*;
import sector.*;
import contacto.*;
import zona.*;
import dataBase.*;



import java.util.List;

public class Main {

    public static void main(String[] args) {


        //codigo de prueba para cultivo
        CultivoFacade cultivoFacade = new CultivoFacade();

        Cultivo cultivo1 = new Cultivo("Tomate", 15.0f, 30.0f, 10.0f, 60, 90);
        Cultivo cultivo2 = new Cultivo("Maíz", 18.0f, 35.0f, 12.0f, 80, 120);

        cultivoFacade.agregarCultivo(cultivo1);
        cultivoFacade.agregarCultivo(cultivo2);

        List<Cultivo> listaDeCultivos = cultivoFacade.obtenerListaDeCultivos();

        for (Cultivo cultivo : listaDeCultivos) {
            System.out.println("Nombre: " + cultivo.getNombre());
            System.out.println("Temperatura Mínima: " + cultivo.getTempMinima());
            System.out.println("Temperatura Máxima: " + cultivo.getTempMaxima());
            System.out.println("Cantidad de Agua: " + cultivo.getCantidadAgua());
            System.out.println("Días Mínimos de Cosecha: " + cultivo.getDiasMinCosecha());
            System.out.println("Días Máximos de Cosecha: " + cultivo.getDiasMaxCosecha());
            System.out.println("--------------------");
        }

        //codigo de de prueba para sectores climaticos de costa rica
        SectorFacade sectorFacade = new SectorFacade();

        Sector pacificoNorte = new Sector("Pacifico Norte",2321,26,115,4);
        Sector pacificoCentral = new Sector("Pacifico Central",2434,28,111,5);
        /*Sector pacificoSur = new Sector("Pacifico Sur",);
        Sector zonaNorte = new Sector("Zona Norte",);
        Sector valleCentral = new Sector("Valle Central",);
        Sector vientreCaribe = new Sector("Vientre del Caribe",);*/

        sectorFacade.agregarSector(pacificoNorte);
        sectorFacade.agregarSector(pacificoCentral);

        List<Sector> listaDeSectores = sectorFacade.obtenerListaDeSectores();

        for (Sector sector : listaDeSectores) {
            System.out.println("Nombre: " + sector.getNombre());
            System.out.println("Lluvia Media Anual: " + sector.getLluviaMediaAnual());
            System.out.println("Temperatura Media: " + sector.getTemperaturaMedia());
            System.out.println("Promedio de Lluvias: " + sector.getPromedioLluvias());
            System.out.println("Duración de Periodo Seco: " + sector.getDuracionPeriodoSeco());
            System.out.println("--------------------");
        }



        //codigo de prueba para contactos
        ContactoFacade contactoFacade = new ContactoFacade();

        Contacto contacto1 = new Contacto("Juan Perez", 1234567890, "juan@example.com", "@juan_telegram");
        Contacto contacto2 = new Contacto("Maria Rodriguez", 987654321, "maria@example.com", "@maria_telegram");
        Contacto contacto3 = new Contacto("samir",12345678, "samir", "samir");
        contactoFacade.agregarContacto(new Contacto("rodrigo",12345678, "rodrigo@gmail","rodrigoTelegram"));

        contactoFacade.agregarContacto(contacto1);
        contactoFacade.agregarContacto(contacto2);
        contactoFacade.agregarContacto(contacto3);

        List<Contacto> listaDeContactos = contactoFacade.obtenerListaDeContactos();

        for (Contacto contacto : listaDeContactos) {
            System.out.println("Nombre: " + contacto.getNombre());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println("Correo: " + contacto.getCorreo());
            System.out.println("Usuario de Telegram: " + contacto.getUsuarioTelegram());
            System.out.println("--------------------");
        }


        //codigo de prueba para zonas
        ZonaFacade zonaFacade = new ZonaFacade();

        Zona zona1 = new Zona("Zona 1", 50.0f, 30.0f, cultivo1, pacificoNorte);
        Zona zona2 = new Zona("Zona 2", 40.0f, 20.0f, cultivo2, pacificoCentral);

        zonaFacade.agregarZona(zona1);
        zonaFacade.agregarZona(zona2);

        List<Zona> listaDeZonas = zonaFacade.obtenerListaDeZonas();

        for (Zona zona : listaDeZonas) {
            System.out.println("Nombre: " + zona.getNombre());
            System.out.println("Largo: " + zona.getLargo());
            System.out.println("Ancho: " + zona.getAncho());
            System.out.println("Cultivo: " + zona.getCultivo().getNombre());
            System.out.println("Sector: " + zona.getSector().getNombre());
            System.out.println("--------------------");
        }

        MongoDatabaseConnection mongoDB = MongoDatabaseConnection.getInstance();
        /*
        //agregar contactos
        ConexionContacto conexionContacto = new ConexionContacto(mongoDB.getDatabase());
        for(Contacto contacto: listaDeContactos){
            conexionContacto.agregarContacto(contacto);
        }

        //agregar cultivos
        ConexionCultivo conexionCultivo = new ConexionCultivo(mongoDB.getDatabase());
        for(Cultivo cultivo : listaDeCultivos){
            conexionCultivo.agregarCultivo(cultivo);
        }

        ConexionSector conexionSector = new ConexionSector(mongoDB.getDatabase());
        for(Sector sector : listaDeSectores){
            conexionSector.agregarSector(sector);
        }
        */
        ConexionZona conexionZona = new ConexionZona(mongoDB.getDatabase());
        for(Zona zona : listaDeZonas){
            conexionZona.agregarZona(zona);
        }


    }
}
