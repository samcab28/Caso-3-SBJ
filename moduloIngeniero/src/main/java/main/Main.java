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

        MongoDatabaseConnection mongoDB = MongoDatabaseConnection.getInstance();


        //apartado de cultivos
        ConexionCultivo conexionCultivo = new ConexionCultivo(mongoDB.getDatabase());
        CultivoFacade cultivoFacade = new CultivoFacade();
        List<Cultivo> listaDeCultivos = cultivoFacade.obtenerListaDeCultivos();
        conexionCultivo.obtenerTodosLosCultivos(listaDeCultivos);

        for (Cultivo cultivo : listaDeCultivos) {
            System.out.println("Nombre: " + cultivo.getNombre());
            System.out.println("Temperatura Mínima: " + cultivo.getTempMinima());
            System.out.println("Temperatura Máxima: " + cultivo.getTempMaxima());
            System.out.println("Cantidad de Agua: " + cultivo.getCantidadAgua());
            System.out.println("Días Mínimos de Cosecha: " + cultivo.getDiasMinCosecha());
            System.out.println("Días Máximos de Cosecha: " + cultivo.getDiasMaxCosecha());
            System.out.println("--------------------");
        }

        //apartado de contactos
        ConexionContacto conexionContacto = new ConexionContacto(mongoDB.getDatabase());
        ContactoFacade contactoFacade = new ContactoFacade();
        List<Contacto> listaDeContactos = contactoFacade.obtenerListaDeContactos();
        conexionContacto.obtenerTodosLosContactos(listaDeContactos);
        for (Contacto contacto : listaDeContactos) {
            System.out.println("Nombre: " + contacto.getNombre());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println("Correo: " + contacto.getCorreo());
            System.out.println("Usuario de Telegram: " + contacto.getUsuarioTelegram());
            System.out.println("--------------------");
        }


        //apartado de sectores NO ESTA LISTO

        ConexionSector conexionSector = new ConexionSector(mongoDB.getDatabase());
        SectorFacade sectorFacade = new SectorFacade();

        List<Sector> listaDeSectores = sectorFacade.obtenerListaDeSectores();


        conexionSector.obtenerTodosLosSectores(listaDeSectores);

        for (Sector sector : listaDeSectores) {
            System.out.println("Nombre: " + sector.getNombre());
            System.out.println("Lluvia Media Anual: " + sector.getLluviaMediaAnual());
            System.out.println("Temperatura Media: " + sector.getTemperaturaMedia());
            System.out.println("Promedio de Lluvias: " + sector.getPromedioLluvias());
            System.out.println("Duración de Periodo Seco: " + sector.getDuracionPeriodoSeco());
            System.out.println("--------------------");
        }


        //apartado de zonas
        ConexionZona conexionZona = new ConexionZona(mongoDB.getDatabase());
        ZonaFacade zonaFacade = new ZonaFacade();
        List<Zona> listaDeZonas = zonaFacade.obtenerListaDeZonas();
        conexionZona.obtenerTodosLasZonas(listaDeZonas,cultivoFacade,sectorFacade);
        for (Zona zona : listaDeZonas) {
            System.out.println("Nombre: " + zona.getNombre());
            System.out.println("Largo: " + zona.getLargo());
            System.out.println("Ancho: " + zona.getAncho());
            System.out.println("Cultivo: " + zona.getCultivo().getNombre());
            System.out.println("Sector: " + zona.getSector().getNombre());
            System.out.println("--------------------");
        }


    }
}
