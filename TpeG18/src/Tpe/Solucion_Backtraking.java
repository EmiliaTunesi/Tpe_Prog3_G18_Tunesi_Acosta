package Tpe;

import java.util.*;

public class Solucion_Backtraking {
    private ArrayList<Maquina> secuencia_maquinas = null;
    private ArrayList<Maquina> secuencia_actual = new ArrayList<>();
    private int estadosGenerados = 0;

    public ArrayList<Maquina> getSecuenciaMaquinas(ArrayList<Maquina> maquinas, Integer produccion) {
        getSecuenciaMaquinas(maquinas, produccion, 0, 0);
        if (secuencia_maquinas == null) {
            return null;
        }else {
        	return secuencia_maquinas;
        }
        
    }

   
    private void getSecuenciaMaquinas(List<Maquina> maquinas, int produccion, int produccion_actual, int start) {
     
    	
    	if (secuencia_maquinas != null && secuencia_actual.size() >= secuencia_maquinas.size()) {
        	return;
        }
        if (produccion_actual > produccion) {
        	return;
        }
        estadosGenerados++; //esto me da dudas esta bien ubicado aca? cuenta bien?

        if (produccion_actual == produccion) {
            if (secuencia_maquinas ==null || secuencia_actual.size() < secuencia_maquinas.size()) {
                secuencia_maquinas = new ArrayList<>(secuencia_actual);
            }
            return;
        }

   
        for (int i = start; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            secuencia_actual.add(m);
            getSecuenciaMaquinas(maquinas, produccion, produccion_actual + m.getPiezas(), i); 
            secuencia_actual.remove(secuencia_actual.size() - 1);
        }
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }
}

