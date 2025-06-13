package Tpe;

/* 
/*
Estrategia de resolución Backtracking:

-Generación del árbol de exploración:
El árbol se construye recursivamente. En cada nodo se agrega una máquina a la secuencia actual y se avanza 
hacia un nuevo estado donde se incrementa la producción acumulada. El orden de los nodos representa las 
distintas combinaciones posibles de máquinas para alcanzar la producción objetivo.

-Estados finales y solución:
Un estado final válido es aquel en el que la producción acumulada es exactamente igual a la producción requerida.
Entre todos los estados solución posibles, se guarda el que utiliza la menor cantidad de máquinas.

-Podas aplicadas:
Si al agregar una máquina la producción acumulada supera el objetivo, se descarta esa rama y no se continúa 
explorando por ese camino. Esto permite reducir la cantidad de combinaciones a evaluar.

-Consideraciones adicionales:
Las máquinas pueden repetirse, por lo tanto no es necesario llevar un control de visitadas. 
El algoritmo garantiza encontrar la solución óptima (con menor cantidad de máquinas) si existe.
*/



import java.util.*;

 public class Solucion_Backtraking{
    private ArrayList<Maquina> secuencia_maquinas = new ArrayList<>();
    private ArrayList<Maquina> secuencia_actual = new ArrayList<>();
    private int estadosGenerados = 0;
    

   public ArrayList<Maquina> getSecuenciaMaquinas (ArrayList <Maquina> maquinas, Integer produccion){
	  for(Maquina m: maquinas) {
		  getSecuenciaMaquinas(maquinas, produccion, 0,m);
	  }
      
      return secuencia_maquinas;
   }
   

   private void getSecuenciaMaquinas(List<Maquina> maquinas, int produccion, int produccion_actual, Maquina m) {
     
      estadosGenerados++;
      produccion_actual+= m.getPiezas();
      secuencia_actual.add(m);

      if (produccion_actual == produccion) {
         if (secuencia_maquinas.isEmpty() || secuencia_actual.size() < secuencia_maquinas.size()) {
               secuencia_maquinas = new ArrayList<Maquina>(secuencia_actual);
         }
      }
      else if (produccion_actual > produccion) {
    	  return;  		  
      } 
      else if (!secuencia_maquinas.isEmpty() && secuencia_actual.size()>secuencia_maquinas.size()) {
    	  return;
      }
      else {    
         for (Maquina mac : maquinas) {
        	if (produccion_actual + mac.getPiezas() <=produccion) {
        		getSecuenciaMaquinas(maquinas, produccion, produccion_actual, mac);
        	}
            
         }
      }
      
      secuencia_actual.remove(secuencia_actual.size() - 1);
      produccion_actual -= m.getPiezas();
   }  

   public int getEstadosGenerados() {
      return estadosGenerados;
   }
}