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
        List<Cultivo> listaCultivos = cultivoFacade.obtenerListaDeCultivos();
        listaCultivos.add(new Cultivo("Maíz", 15.0f, 30.0f, 200.0f, 90, 120, 2.5f));
        listaCultivos.add(new Cultivo("Trigo", 10.0f, 25.0f, 250.0f, 100, 150, 3.0f));
        listaCultivos.add(new Cultivo("Arroz", 20.0f, 35.0f, 300.0f, 120, 160, 2.2f));
        listaCultivos.add(new Cultivo("Tomates", 18.0f, 28.0f, 400.0f, 60, 90, 4.0f));
        listaCultivos.add(new Cultivo("Papas", 8.0f, 20.0f, 350.0f, 90, 120, 1.8f));
        listaCultivos.add(new Cultivo("Manzanas", 5.0f, 30.0f, 600.0f, 150, 180, 5.5f));
        listaCultivos.add(new Cultivo("Fresas", 15.0f, 25.0f, 500.0f, 90, 120, 6.0f));
        listaCultivos.add(new Cultivo("Uvas", 18.0f, 35.0f, 700.0f, 120, 150, 7.2f));
        listaCultivos.add(new Cultivo("Naranjas", 10.0f, 35.0f, 800.0f, 180, 220, 4.8f));
        listaCultivos.add(new Cultivo("Limones", 12.0f, 30.0f, 700.0f, 120, 160, 5.2f));
        listaCultivos.add(new Cultivo("Cebollas", 10.0f, 25.0f, 350.0f, 90, 120, 2.0f));
        listaCultivos.add(new Cultivo("Zanahorias", 8.0f, 22.0f, 300.0f, 90, 120, 2.2f));
        listaCultivos.add(new Cultivo("Pimientos", 18.0f, 30.0f, 450.0f, 100, 130, 3.5f));
        listaCultivos.add(new Cultivo("Calabazas", 15.0f, 28.0f, 400.0f, 120, 150, 2.8f));
        listaCultivos.add(new Cultivo("Pepinos", 20.0f, 32.0f, 450.0f, 90, 120, 3.0f));
        listaCultivos.add(new Cultivo("Frijoles", 15.0f, 28.0f, 350.0f, 80, 110, 2.0f));
        listaCultivos.add(new Cultivo("Lentejas", 10.0f, 25.0f, 300.0f, 90, 120, 2.5f));
        listaCultivos.add(new Cultivo("Cacao", 20.0f, 30.0f, 600.0f, 180, 220, 8.0f));
        listaCultivos.add(new Cultivo("Café", 18.0f, 28.0f, 700.0f, 150, 180, 7.5f));
        listaCultivos.add(new Cultivo("Almendras", 15.0f, 35.0f, 800.0f, 200, 240, 9.0f));

        for(Cultivo c:listaCultivos){
            conexionCultivo.agregarCultivo(c);
        }

        listaCultivos.clear();

        conexionCultivo.obtenerTodosLosCultivos(listaCultivos);

        for (Cultivo cultivo : listaCultivos) {
            System.out.println("Nombre: " + cultivo.getNombre());
            System.out.println("Temperatura Mínima: " + cultivo.getTempMinima());
            System.out.println("Temperatura Máxima: " + cultivo.getTempMaxima());
            System.out.println("Cantidad de Agua: " + cultivo.getCantidadAgua());
            System.out.println("Días Mínimos de Cosecha: " + cultivo.getDiasMinCosecha());
            System.out.println("Días Máximos de Cosecha: " + cultivo.getDiasMaxCosecha());
            System.out.println("Precio por Unidad: " + cultivo.getPrecioUnidad());
            System.out.println("--------------------");
        }



    }
}
