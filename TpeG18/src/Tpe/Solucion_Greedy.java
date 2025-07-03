package Tpe;

/* 
Estrategia de resolución greedy:
- Candidatos: todas las máquinas disponibles en la lista de entrada.
- Estrategia de selección: se ordenan las máquinas de mayor a menor según la cantidad de piezas que producen. 
En cada iteración se selecciona la máquina más productiva que no exceda la producción objetivo.
- Consideraciones respecto a la solución:
No garantiza encontrar la solución óptima (es decir, con la menor cantidad de máquinas), ya que no explora todas las
combinaciones posibles.
Sí garantiza encontrar una solución válida si existe, siempre que las máquinas disponibles 
permitan alcanzar la cantidad de piezas requerida.
- Ventaja principal: alta eficiencia y velocidad de ejecución, útil para instancias grandes.
- Limitación: puede dejar de lado combinaciones mejores. No garantiza encontrar la mejor solucion, si no que encuentra la 
que mas se aproxima a la mejor solución. 
 */

import java.util.*;

public class Solucion_Greedy{
      private ArrayList<Maquina> secuencia_maquinas= new ArrayList<>();
      private int produccion_actual=0;
      private int candidatosConsiderados = 0;


      public ArrayList <Maquina> getSecuenciaMaquinas(ArrayList <Maquina> maquinas, int produccion){
          maquinas = Ordenar(maquinas);
          int i = 0;
          while ((produccion_actual < produccion) && (i < maquinas.size())) {
              candidatosConsiderados++;
              Maquina seleccion = maquinas.get(i);
              if (produccion_actual + seleccion.getPiezas() <= produccion) {
                  secuencia_maquinas.add(seleccion);
                  produccion_actual += seleccion.getPiezas();
              } else {
                  i++;
              }
          }
          if (produccion_actual != produccion) {
              return null;
          }else {
        	  return secuencia_maquinas;  
          }
      }

    public ArrayList<Maquina> Ordenar(ArrayList<Maquina> maquinas) {
    if (maquinas.size() <= 1) {
        return maquinas;
    }

    int medio = maquinas.size() / 2;

    ArrayList<Maquina> izquierda = new ArrayList<>(maquinas.subList(0, medio));
    ArrayList<Maquina> derecha = new ArrayList<>(maquinas.subList(medio, maquinas.size()));

    izquierda = Ordenar(izquierda);
    derecha = Ordenar(derecha);

    return merge(izquierda, derecha);
}

private ArrayList<Maquina> merge(ArrayList<Maquina> izquierda, ArrayList<Maquina> derecha) {
    ArrayList<Maquina> resultado = new ArrayList<>();
    int i = 0, j = 0;

    while (i < izquierda.size() && j < derecha.size()) {
        if (izquierda.get(i).getPiezas() >= derecha.get(j).getPiezas()) {
            resultado.add(izquierda.get(i));
            i++;
        } else {
            resultado.add(derecha.get(j));
            j++;
        }
    }

    while (i < izquierda.size()) {
        resultado.add(izquierda.get(i));
        i++;
    }

    while (j < derecha.size()) {
        resultado.add(derecha.get(j));
        j++;
    }

    return resultado;
}
public int getCandidatosConsiderados() {
        return candidatosConsiderados;
    }
}