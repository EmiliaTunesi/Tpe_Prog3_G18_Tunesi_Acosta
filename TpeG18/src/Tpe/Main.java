package Tpe;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Maquina
    	 LectorTexto lector = new LectorTexto();
         DatosEntrada datos = lector.leerDatosDesdeArchivo(); 
         int piezasNecesarias = datos.getPiezasNecesarias();   
         ArrayList<Maquina> maquinas = datos.getMaquinas();   
         if (maquinas.isEmpty() || piezasNecesarias == 0) {
             System.out.println("No se pudieron cargar los datos correctamente desde el archivo.");
             return;
         }

        //SolucionBacktraking
        Solucion_Backtraking back = new Solucion_Backtraking();
        ArrayList <Maquina> resultadoBack = back.getSecuenciaMaquinas(maquinas, piezasNecesarias);
        System.out.println("-Backtracking-");
        imprimirResultado(resultadoBack);
        if(resultadoBack != null) {
        	System.out.println("Estados generados: " + back.getEstadosGenerados());

        }
        
        //Solucion Greedy
        Solucion_Greedy greedy = new Solucion_Greedy();
        ArrayList <Maquina> resultadoGreedy = greedy.getSecuenciaMaquinas(maquinas, piezasNecesarias);
        System.out.println();
        System.out.println("-Greedy-");
        imprimirResultado(resultadoGreedy);
        if (resultadoGreedy != null) {
        	System.out.println("Candidatos considerados: " + greedy.getCandidatosConsiderados());
        }
    }
    
    private static void imprimirResultado(ArrayList<Maquina> resultado) {
    	  if (resultado == null || resultado.isEmpty()) {
    	        System.out.println("sin solucion");
    	        return;
          }
    	  else {
    		  System.out.print("Secuencia: ");
    	        for (Maquina maquina : resultado) {
    	            System.out.print("[" + maquina.getNombre() + ", " + maquina.getPiezas() + "] " );
    	        }
    	        System.out.println();

    	        int totalPiezas = 0;
    	        for (Maquina maquina : resultado) {
    	            totalPiezas += maquina.getPiezas();
    	        }
    	        System.out.println("Piezas producidas: " + totalPiezas);
    	        System.out.println("Puestas en funcionamiento: " + resultado.size());
          }
    }
}
