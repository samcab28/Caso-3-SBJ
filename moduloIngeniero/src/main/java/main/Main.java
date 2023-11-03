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





    }
}
