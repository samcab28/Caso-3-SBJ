package main;

import dataBase.*;
import almacenamiento.*;
import calculadora.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MongoDataBaseConnection mongoDB = MongoDataBaseConnection.getInstance();
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



        //calculo de dinerio necesario para el funcionamiento de: maiz que necesita 12 m cubicos de agua
        // y zona uno que tiene dimensiones de:50*30

        DineroFuncionamiento dineroFuncionamiento = new DineroFuncionamiento(listaDeCultivos.get(0).getCantidadAgua(), listaDeZonas.get(0).getAncho(), listaDeZonas.get(0).getLargo(),1500);
        System.out.println("la cantidad de dinero necesaria es de: " + dineroFuncionamiento.calculo());

        AguaNecesaria aguaNecesaria = new AguaNecesaria(listaDeCultivos.get(0).getCantidadAgua(), listaDeZonas.get(0).getAncho(), listaDeZonas.get(0).getLargo());
        System.out.println("cantidad de agua necesaria: " + aguaNecesaria.calculo() + " litros");
    }
}
