package modagri.agricultor.conexion;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoDatabase;

import modagri.agricultor.almacenamiento.Cultivo;
import modagri.agricultor.almacenamiento.CultivoFacade;
import modagri.agricultor.almacenamiento.Sector;
import modagri.agricultor.almacenamiento.SectorFacade;
import modagri.agricultor.dataBase.ConexionCultivo;
import modagri.agricultor.dataBase.ConexionSector;
import modagri.agricultor.dataBase.MongoDataBaseConnection;

@RestController
public class Controller {
	
	String cultivoName;
	String sectorName;
	
	float ancho;
	float largo;
	float extras;
	int innovaciones;
	
	float costoEsperado;
	float profitBruto;
	float cantidadAguaEstimada;
	float cosecha;
	double probabilidadExito;
	
    @PostMapping("/calcular")
    public String procesarDatos(@RequestBody DatosCalculo datos) {
    	MongoDataBaseConnection conexionDB = new MongoDataBaseConnection();
    	MongoDatabase rootDB = conexionDB.getDatabase();
    	
    	ConexionCultivo conexionCultivo = new ConexionCultivo(rootDB);
    	Vector<Cultivo> cultivos = conexionCultivo.getCultivos();
    	
    	ConexionSector conexionSector = new ConexionSector(rootDB);
    	Vector<Sector> sectores = conexionSector.getSectores();
    	
    	CultivoFacade cultivoFachada = new CultivoFacade();
    	SectorFacade sectorFachada = new SectorFacade();
    	
    	cultivoFachada.setCultivos(cultivos);
    	sectorFachada.setSectores(sectores);
    	
        Calculo calculo = new Calculo(cultivoFachada, sectorFachada, Float.parseFloat(datos.getAncho()), Float.parseFloat(datos.getLargo()));
        
        // Datos entrantes.
        cultivoName = datos.getCultivo();
        sectorName = datos.getSector();
        ancho = Float.parseFloat(datos.getAncho());
        largo = Float.parseFloat(datos.getLargo());
        innovaciones = datos.getInnovacionesNum();
        cosecha = cultivoFachada.buscarCultivoPorNombre(cultivoName).getCantidadPorMetro2()*ancho*largo;
        extras = obtenerExtrasMonto(innovaciones);
        
        profitBruto = calculo.profitBruto(cultivoName, ancho, largo);
        		
        System.out.println("Cultivo: " + datos.getCultivo());
        System.out.println("Sector: " + datos.getSector());
        System.out.println("Ancho: " + datos.getAncho());
        System.out.println("Largo: " + datos.getLargo());
        System.out.println("Innovaciones: " + datos.getInnovaciones());
        
        //Cálculos.
        
        cantidadAguaEstimada = calculo.aguaNecesaria(cultivoName, ancho, largo);
        probabilidadExito = calculo.probabilidadExito(sectorName, cultivoName, innovaciones);
        costoEsperado = calculo.dineroCosto(cantidadAguaEstimada, extras);
        
        System.out.println("Totales innovan: " + innovaciones);
        System.out.println("Cultivito " + cultivoName);
        System.out.println("Aguita " + cantidadAguaEstimada);
        System.out.println("Success " + probabilidadExito);
        
        return "Datos recibidos correctamente";
    }
    
    @GetMapping("/obtenerDatos")
    public Map<String, Object> obtenerDatos() {
        // Datos a enviar al cliente.
        Map<String, Object> datos = new HashMap<>();
        datos.put("resultadoCostoCultivo", costoEsperado);
        datos.put("resultadoCostoProfit", profitBruto);
        datos.put("resultadoCantidadAgua", cantidadAguaEstimada);
        datos.put("resultadoCantidadUnidades", cosecha);
        datos.put("resultadoProbabilidad", probabilidadExito*100);

        return datos;
    }
    
    private float obtenerExtrasMonto (int innovaciones) {
    	Random random = new Random();
    	float sumaExtras = 0;
    	int randomNumber;
        int min = 20000;
        int max = 100000;
        
        for (int i = 0; i < innovaciones; i++) {
        	randomNumber = random.nextInt(max - min + 1) + min;
        	sumaExtras += randomNumber;
        }
        return sumaExtras;
    }
}


